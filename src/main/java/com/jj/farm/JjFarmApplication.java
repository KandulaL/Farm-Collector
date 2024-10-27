package com.jj.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.jj.farm"})
public class JjFarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JjFarmApplication.class, args);
	}

}
