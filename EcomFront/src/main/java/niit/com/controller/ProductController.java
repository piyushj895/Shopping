package niit.com.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import niit.com.dao.ProductDao;
import niit.com.model.Product;


@Controller
public class ProductController 
{
	@Autowired
	ProductDao productdao;
	@RequestMapping(value="/product")
	public String showTheProduct(Model m)
	{
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList", listProduct);
		return "Product";
}
	
}
