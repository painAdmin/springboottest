package com.springtest;

import com.springtest.web.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringboottestApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringboottestApplication.class, args);
	}
}
