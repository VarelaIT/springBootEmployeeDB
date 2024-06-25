package com.varelait.springEmployeeDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan("com.varelait")
@EnableTransactionManagement
public class SpringEmployeeDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeDbApplication.class, args);
	}

}
