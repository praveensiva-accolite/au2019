package com.accolite.au;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AUController
{
	@RequestMapping("/hello")
	public String greet(Model m) 
	{
		//Model m= new ExtendedModelMap();
		String message="Helloboys";
		m.addAttribute("message",message);
		
		return "hello";
	}
	
	@RequestMapping("/one")
	public String gotoone(Model m) 
	{
		
		
		return "one";
	}
	
	
	
}
