package com.sesac.springBootMVCProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com","kr"})
@EntityScan(basePackages = {"com","kr"})
public class SpringBootMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcProjectApplication.class, args);
	}

}
