package com.doosan.ms.movie.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.doosan.ms.movie.ofs.UserServiceInf;
import com.doosan.ms.movie.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@RequestMapping("/movie")
@RestController
public class MovieController {
	
	@Autowired	
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;
	/**
	 * restTemplate way
	 * @return
	 */
	@PostMapping("/order")
	public String order() {
		//模拟当前用户
		Integer id = 1;
		//远程调用用户微服务
		User user = restTemplate.getForObject("http://localhost:9001/user/find/"+id, User.class);
		
		//调用用户微服，获取用户具体信息
		System.out.println(user.getName() + " is buying the movie tickets...");
		
		return "Sale successfully";
	}
	
	/**
	 * Eureka way
	 * @return
	 */
	@PostMapping("/sale")
	public String sale() {
		//模拟当前用户
		Integer id = 1;
		//获取Eureka中的用户微服务 - 根据名称获取
		List<ServiceInstance> instances = discoveryClient.getInstances("microservice-user");
		//如果没有负载均衡，只能获取一个服务器
		ServiceInstance instance = instances.get(0);
		User user = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/user/find/"+id, User.class);
		//调用用户微服，获取用户具体信息
		System.out.println(user.getName() + " is buying the movie tickets...(Use eureka to get the serivce infomation)");
		return "Sale successfully";
	}
	
	/**
	 * Eureka way-使用Ribbon负载均衡
	 * @return
	 */
	//注入负载均衡客户端
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@PostMapping("/buy")
	@HystrixCommand(fallbackMethod =  "fallback")
	public String buy() {
		//模拟当前用户
		Integer id = 1;
		//使用Ribbon选择合适的服务实例
//		ServiceInstance instance = loadBalancerClient.choose("microservice-user");
//		User user = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/user/find/"+id, User.class);
		//使用简化版(地址栏直接使用微服名称)-前提是启动类在RrestTemplate初始化的时候增加@LoadBalanced注解
		User user = restTemplate.getForObject("http://microservice-user/user/find/"+id, User.class);
		//调用用户微服，获取用户具体信息
		System.out.println(user.getName() + " is buying the movie tickets...(Use eureka to get the serivce infomation)");
		return "Sale successfully";
	}
	
	/**
	 * 熔断器回滚方法
	 */
	public String fallback() {
		return "Service can not be used!";
	}
	
	@Autowired
	private UserServiceInf usi;
	@PostMapping("/get")
	public String getTicket() {
		Integer id = 1;
		User user = usi.getUserById(id);
		//调用用户微服，获取用户具体信息
		System.out.println(user.getName() + " is buying the movie tickets...(Use OpenFeign to get the serivce infomation)");
		return "Get ticket successfully";
	}
	
}