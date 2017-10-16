package niit.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import niit.com.dao.Dao;
import niit.com.model.Category;

@Controller
public class CategoryController 
{
	@Autowired
	Dao dao;
	@RequestMapping(value="/category")
	public String showCategory(Model m)
	{
		List<Category> listCategory=dao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);
		return "Category";
	}
//	@RequestMapping(value="deleteTheCategory/{cat_id}")
//	public String deleteCategory
}

