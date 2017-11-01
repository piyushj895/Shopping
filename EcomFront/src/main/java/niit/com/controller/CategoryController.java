package niit.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import niit.com.dao.Dao;
import niit.com.model.Category;

@Controller
public class CategoryController 
{
		@Autowired
		Dao dao;
		@RequestMapping(value="/admincategory")
		public String showCategory(Model m)
		{
			List<Category> listCategory=dao.retrieveCategory();
			m.addAttribute("categoryList", listCategory);
			m.addAttribute("categorymodel", new Category());
			return "Category";
		}
		@RequestMapping(value="/adminshowCategory")
		public String saveTheCategory(@ModelAttribute Category category,Model m)
		{
			
			dao.saveTheCategory(category);
			List<Category> listCategory=dao.retrieveCategory();
			m.addAttribute("categoryList", listCategory);
			m.addAttribute("categorymodel", new Category());
			return "Category";
		}
		@RequestMapping(value="adminupdateCategory{cat_id}")
		public String updateCategory(@PathVariable("cat_id") int catId,Model m)
		{
			Category category=dao.getTheCategory(catId);
			m.addAttribute("categorymodel",category);
			List<Category> listCategory=dao.retrieveCategory();
			m.addAttribute("categoryList",listCategory);

			return "CategoryUpdate";
		}
		
		
		@RequestMapping(value="/adminUpdateCategory")
		public String updateMyCategory(@ModelAttribute Category category,Model m)
		{
			dao.updateTheCategory(category);
			List<Category> listCategory=dao.retrieveCategory();
			m.addAttribute("categoryList",listCategory);
			m.addAttribute("categorymodel", new Category());
			return "Category";
		}
		
		
		@RequestMapping(value="admindeleteCategory/{cat_id}")
		public String deleteTheCategory(@PathVariable("cat_id")int catId,Model m)
		{
			Category category=dao.getTheCategory(catId);
			dao.deleteTheCategory(category);
			List<Category> listCategory=dao.retrieveCategory();
			m.addAttribute("categoryList",listCategory);
			m.addAttribute("categorymodel", new Category());
			return "Category";
		}
		
		
	}

