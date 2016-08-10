package com.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@SpringBootConfiguration
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.controller","com.service","com.service.morphia"})
@Controller
public class BetaVersionApplication {
//This is root application which starts the execution 
//and component scan annotation is used to make other services/controllers visible using packages
	public static void main(String[] args) {
		SpringApplication.run(BetaVersionApplication.class, args);
	}
}
