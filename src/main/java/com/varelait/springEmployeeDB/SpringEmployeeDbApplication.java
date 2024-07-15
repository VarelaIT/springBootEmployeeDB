package com.varelait.springEmployeeDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@ComponentScan("com.varelait")
public class SpringEmployeeDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeDbApplication.class, args);
	}

}
