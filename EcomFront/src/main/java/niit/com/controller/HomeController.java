package niit.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import niit.com.dao.Dao;
import niit.com.dao.ProductDao;
import niit.com.dao.SupplierDao;
import niit.com.model.Category;
import niit.com.model.Product;
import niit.com.model.Supplier;
@Controller
public class HomeController 
{
	@Autowired
	Dao dao;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	ProductDao productdao;
	@RequestMapping(value="/")
	public String index(HttpSession hs)
	{
		System.out.println("hello");
		List<Category> listCategory=dao.retrieveCategory();
		hs.setAttribute("categoryList", listCategory);
		return "index";
	}
	
	
//		@RequestMapping(value="/home")
//		public ModelAndView formpage(Model m)
//		{
//			List<Category> listCategory=dao.retrieveCategory();
//			m.addAttribute("categoryList", listCategory);
//			
//			return new ModelAndView("home");
//		}
		
		@RequestMapping(value="/product")
		public String viewProduct(HttpSession hs)
		{
			hs.setAttribute("category", new Category());
			hs.setAttribute("supplier", new Supplier());
			hs.setAttribute("product", new Product());
			return "product";	
}
}
