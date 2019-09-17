package com.doosan.ms.movie.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.doosan.ms.movie.pojo.User;
@RequestMapping("/movie")
@RestController
public class MovieController {
	
	@Autowired	
	private RestTemplate restTemplate;

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
}
