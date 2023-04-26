package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class HelloWorldApplication {
        public static void main(String[] args) {
                SpringApplication.run(HelloWorldApplication.class, args);
        }
        @RestController
        @RequestMapping("/Daikichi")
        public class HomeController {
                @RequestMapping("/today")
                public String today() {
                        return "<h1>Today you will find luck in all your endeavors!</h1>";
                }
                @RequestMapping("/tomorrow")
                public String future() {
                		return "<h1>tomorrow is a mystery</h1>";
                }
                @RequestMapping("/yesterday")
                public String past() {
                		return "<h1>yesterday is history</h1>";
        }
                @RequestMapping("")
                public String now() {
                		return "<h1>welcome</h1>";

        }

	}
}

