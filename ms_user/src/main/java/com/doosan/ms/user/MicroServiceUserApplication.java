package com.doosan.ms.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceUserApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceUserApplication.class, args);
	}
}
