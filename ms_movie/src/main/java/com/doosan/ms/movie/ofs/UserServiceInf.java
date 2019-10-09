package com.doosan.ms.movie.ofs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.doosan.ms.movie.ofs.hystrix.UserServiceFallback;
import com.doosan.ms.movie.pojo.User;
/**
 * 注意事项
 * 1.使用@FeignClient注解
 * 2.检查@GetMapping的路径是否完整
 * 3.@PathVariable的value一定不能省略
 * @author 20112004
 *
 */
@FeignClient(value = "microservice-user", fallback = UserServiceFallback.class)
public interface UserServiceInf {
	
	@GetMapping("/user/find/{id}")
	public User getUserById(@PathVariable("id") Integer id) ;
}