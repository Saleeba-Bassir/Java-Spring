package com.counter.codingdojo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@Controller 
@RequestMapping("")
public class counter {
	@RequestMapping("your_server")
	public String index(HttpSession session) {
		 Integer counter = (Integer) session.getAttribute("count");
	        if (counter == null) {
	            counter = 0;
	        }
	        session.setAttribute("count", counter+=1);
	        return "index.jsp";
		
	}
	@RequestMapping("your_server/counting")
	public String counting(Model model) {
		return "count.jsp";
		
	}
	@RequestMapping("your_server/your_server")
	public String rerun() {
		return "redirect:/your_server";
	}
	@RequestMapping("your_server2")
	public String index2(HttpSession session) {
		 Integer counter = (Integer) session.getAttribute("count");
	        if (counter == null) {
	            counter = 0;
	        }
	        session.setAttribute("count", counter+=2);
	        return "index2.jsp";
}
}
