package org.siy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SiyEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiyEurekaServerApplication.class, args);
	}

}
