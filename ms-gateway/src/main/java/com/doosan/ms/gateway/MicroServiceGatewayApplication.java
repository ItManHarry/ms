package com.doosan.ms.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableZuulProxy	//启用Zuul网关代理功能
@EnableSwagger2		//开启Swagger2功能
public class MicroServiceGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceGatewayApplication.class, args);
	}
}
