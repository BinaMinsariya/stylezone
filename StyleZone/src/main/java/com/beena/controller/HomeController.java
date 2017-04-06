package com.beena.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beena.dao.UserDao;
import com.beena.model.UserDetails;

@SuppressWarnings("unused")
@Controller
public class HomeController 
{
	@Autowired
	UserDao userDao;
	
	@RequestMapping({"/","/home"})
	public String home(Principal principal,ModelMap model)
	{UserDetails userobj;
	if(principal!=null)
	{
		userobj=userDao.getUserByEmail(principal.getName());
		System.out.println(userobj.getEmailid());
		if(userobj.getRole().equals("ROLE_ADMIN"))
		{
			return "redirect:/adminpage";
		}
		else
		{
			return "home";
		}
		
	}
	else
	{
		return "home";
	}	
	}
	@RequestMapping("/adminpage")
	public ModelAndView AdminPage()
	{
		return new ModelAndView("AdminHome");
	}
	@GetMapping("/login")
	public String Login(@RequestParam(value="error",required=false)String error,ModelMap model)
	{
		System.out.println(error);
		if(error!=null)
		{
			model.addAttribute("error","Authentication Failed");
			return "loginform";
		}
		model.addAttribute("title","Login");
		model.addAttribute("loginform",true);
		return "loginform";
	}
	@RequestMapping("/abt")
	public ModelAndView AboutPage()
	{
		return new ModelAndView("about");
	}
	@RequestMapping("/cont")
	public ModelAndView ContactPage()
	{
		return new ModelAndView("contact");
	}
}
