package niit.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController 
{
	@RequestMapping(value="/login")  
	 public ModelAndView login(@RequestParam(name="error",required=false)String error)
	 {
		ModelAndView mv=new ModelAndView("login");
		if(error!=null)
		{
			mv.addObject("message", "Invalid Email or Password");
		}
		return mv;		
	 }
	@RequestMapping(value="/access-denied")  
	 public ModelAndView accessDenied()
	 {
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("403-Access Denied");
		mv.addObject("errorTitle", "Aha! caught you");
		mv.addObject("errorDescription","You are not allowed to view this page");
		return mv;		
	 }
	@RequestMapping("admin")  
	 public String getAdminPage() 
	{  
	  return "admin";  
}	
}