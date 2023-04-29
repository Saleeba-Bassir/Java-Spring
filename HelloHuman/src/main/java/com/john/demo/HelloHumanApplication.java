package com.john.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController 
public class HelloHumanApplication {
	 public static void main(String[] args) {
         SpringApplication.run(HelloHumanApplication.class, args);
	 }
	public class HomeController {
	@RequestMapping("/")
		public String hello() {
				return "Hello Human";
	}
	}
}

