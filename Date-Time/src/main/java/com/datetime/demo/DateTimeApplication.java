package com.datetime.demo;

import org.springframework.boot.SpringApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@SpringBootApplication
public class DateTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DateTimeApplication.class, args);
	}
	@RequestMapping("/")
	public String index() {
	return "*index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		String formattedDate = dateFormat.format(currentDate);
		model.addAttribute("formatDate", formattedDate);
		return "Date.jsp";	
	}
	@RequestMapping("time")
	public String time(Model model) {
		Date currentTime = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		String formattedTime = timeFormat.format(currentTime);
		 model.addAttribute("formattedTime", formattedTime);
		return "Time.jsp";
}
}