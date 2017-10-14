import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controller.Category;
import controller.Dao;

@Controller
public class HomeController 
{
	private Dao dao;
	@RequestMapping(value="/home")
	public ModelAndView formpage()
	{
		return new ModelAndView("form", "category", new Category());
	}
	@RequestMapping(value="/formsubmit",method=RequestMethod.POST)
	public String formsubmit(@ModelAttribute Category category)
	{
		dao.saveTheCategory(category);
		return "succcess";
		
}
