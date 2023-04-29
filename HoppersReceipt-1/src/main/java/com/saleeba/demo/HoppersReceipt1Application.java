package com.saleeba.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class HoppersReceipt1Application {
	public static void main(String[] args) {
		SpringApplication.run(HoppersReceipt1Application.class, args);
	}

	@RequestMapping("/")
	public String index(Model model) {
	    String name = "John rider";
	    String itemName = "Copper wire";
	    double price = 5.25;
	    String description = "Metal strips, also an illustration of nanoseconds.";
	    String vendor = "Little Things Corner Store";
	    model.addAttribute("name", name);
	    model.addAttribute("itemName", itemName);
	    model.addAttribute("price", price);
	    model.addAttribute("description", description);
	    model.addAttribute("vendor", vendor);
	    return "NewFile.jsp";
	}
}

