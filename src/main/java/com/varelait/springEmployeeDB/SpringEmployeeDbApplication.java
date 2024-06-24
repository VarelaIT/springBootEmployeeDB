package com.varelait.springEmployeeDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan("com.varelait")
@EnableJdbcHttpSession
public class SpringEmployeeDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeDbApplication.class, args);
	}

}
