package com.doosan.ms.movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class MicroServiceMovieApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceMovieApplication.class, args);
	}
	
	/**
	 * 初始化RestTemplate
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
		@SuppressWarnings("unchecked")
		ServletRegistrationBean registration = new ServletRegistrationBean(servlet);
		registration.setLoadOnStartup(1);
		registration.addUrlMappings("/hystrix.stream");
		registration.setName("HystrixMetricsStreamServlet");
		return registration;
	}
}