package com.codingdojo.omikujiForm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class OmikujiFormContoller {
	@GetMapping("/")
	public String home() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String process(@RequestParam(value= "number") int number, @RequestParam(value= "city") String city, @RequestParam(value= "person") String person, @RequestParam(value= "hobby") String hobby, @RequestParam(value= "livingThing") String livingThing, @RequestParam(value= "message") String message, HttpSession session) {
		
		String result = String.format(
				"In %s years you will live in %s with %s as your roommate, %s. The next time you see a %s, you will have good luck. Also, %s.",
				number, city, person, hobby, livingThing, message);
		session.setAttribute("result", result);
		return "redirect:/omikuji/show";
	}
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		
		String result = (String) session.getAttribute("result");
		model.addAttribute("result", result);
		
		return "show.jsp";
	}
}
