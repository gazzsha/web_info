package com.school.web_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WebInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebInfoApplication.class, args);
	}

}
