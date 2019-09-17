package com.doosan.ms.dooms.controller.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/demo")
public class HelloController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		
		return "Hello World";
	}
}
