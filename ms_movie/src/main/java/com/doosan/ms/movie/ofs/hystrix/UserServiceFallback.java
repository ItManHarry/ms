package com.doosan.ms.movie.ofs.hystrix;
import org.springframework.stereotype.Component;
import com.doosan.ms.movie.ofs.UserServiceInf;
import com.doosan.ms.movie.pojo.User;
/**
 * Feign熔断器类
 * @author 20112004
 *
 */
@Component
public class UserServiceFallback implements UserServiceInf{

	@Override
	public User getUserById(Integer id) {
		System.out.println("UserService Hystrix...");
		return null;
	}

}