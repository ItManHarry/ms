package com.doosan.ms.movie.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/movie")
@RestController
public class MovieController {

	@PostMapping("/order")
	public String order() {
		//模拟当前用户
		Integer id = 2;
		
		//调用用户微服，获取用户具体信息
		System.out.println("do the ordering...");
		
		return "Sale successfully";
	}
}
