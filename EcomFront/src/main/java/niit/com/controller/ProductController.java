package niit.com.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		m.addAttribute("productmodel", new Product());
		return "Product";
}
	@RequestMapping(value="/showTheProduct")
	public String saveTheProduct(@ModelAttribute Product product,Model m)
{
		productdao.saveTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList", listProduct);
		m.addAttribute("productmodel", new Product());
	return "Product";
	
}
	@RequestMapping(value="updateProduct/{prod_id}")
	public String updateProduct(@PathVariable("prod_id") int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		m.addAttribute("productmodel",product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList", listProduct);
		return "Product";
		
	}
	@RequestMapping(value="/UpdateProduct")
	public String updateMyProduct(@ModelAttribute Product product,Model m)
	{
		productdao.updateTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("productmodel", new Product());
		return "redirect:/product";
	}
	@RequestMapping(value="deleteProduct/{prod_id}")
	public String deleteTheProduct(@PathVariable("prod_id")int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		productdao.deleteTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("productmodel", new Product());
		return "Product";
	}
	
}
