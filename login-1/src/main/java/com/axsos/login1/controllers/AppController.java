package com.axsos.login1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.login1.models.LoginUser;
import com.axsos.login1.models.User;
import com.axsos.login1.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {

     @Autowired
     private UserService userServ;
	 @GetMapping("/")
	    public String index(Model model) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "main.jsp";
	    }
	 
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        userServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "main.jsp";
	        }
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/home";
	    }
	 
	 
	 
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "main.jsp";
	        }
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/home";
	    }
	 
	 
	 
	 @GetMapping("/home")
	    public String home(Model model, HttpSession session) {
	    	Long user_id = (Long) session.getAttribute("user_id");
	    	User thisUser = userServ.findUserById(user_id);
	        model.addAttribute("thisUser", thisUser);
	        return "home.jsp";
	    }
	 
	 
	 
	 
}
