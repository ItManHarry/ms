package com.doosan.ms.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@SpringBootApplication
@EnableZuulProxy	//启用Zuul网关代理功能
public class MicroServiceGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceGatewayApplication.class, args);
	}
}
