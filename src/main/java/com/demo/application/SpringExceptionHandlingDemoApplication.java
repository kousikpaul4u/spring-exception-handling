package com.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.demo.controller.ProductController;

@SpringBootApplication
@ComponentScan(basePackageClasses = ProductController.class)
public class SpringExceptionHandlingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExceptionHandlingDemoApplication.class, args);
	}
}
