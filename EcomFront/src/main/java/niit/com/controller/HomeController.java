package niit.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import niit.com.model.Category;

public class HomeController 
{
		@RequestMapping(value="/home")
		public ModelAndView formpage()
		{
			return new ModelAndView("form", "category", new Category());
		}
		
	
}
