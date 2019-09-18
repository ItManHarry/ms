package com.doosan.ms.movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceMovieApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceMovieApplication.class, args);
	}
	
	/**
	 * 初始化RestTemplate
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
