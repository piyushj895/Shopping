package niit.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import niit.com.dao.Dao;
import niit.com.model.Category;
@Controller
public class HomeController 
{
	@RequestMapping(value="/")
	public String index(Model m)
	{
		System.out.println("hello");
		List<Category> listCategory=dao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);
		return "index";
	}
	
	@Autowired
	Dao dao;
		@RequestMapping(value="/home")
		public ModelAndView formpage(Model m)
		{
			List<Category> listCategory=dao.retrieveCategory();
			m.addAttribute("categoryList", listCategory);
			
			return new ModelAndView("home");
		}
		
		
}

