package com.axsos.omikuji;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	@RequestMapping("")
	public String form(){
		return "form.jsp";
	}
	@RequestMapping(value="/handle", method=RequestMethod.POST)
	public String handle(
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="name") String name,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="creature") String creature,
			@RequestParam(value="compliment") String compliment,
			HttpSession session) {
			session.setAttribute("number",number);
			session.setAttribute("city",city);
			session.setAttribute("hobby",hobby);
			session.setAttribute("creature",creature);
			session.setAttribute("compliment",compliment);
			session.setAttribute("name",name);
		return "redirect:/omikuji/show";
	}
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
		
	}
		
	


