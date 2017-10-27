package niit.com.controller;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import niit.com.dao.Dao;
import niit.com.dao.ProductDao;
import niit.com.dao.SupplierDao;
import niit.com.model.Category;
import niit.com.model.Product;


@Controller
public class ProductController 
{
	@Autowired
	ProductDao productdao;
	@Autowired
	Dao dao;
	@Autowired
	SupplierDao supplierDao;
	@RequestMapping(value="/product")
	public String showTheProduct(Model m)
	{
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute(listProduct);
//		m.addAttribute("categoryList",getCategories());
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
	@RequestMapping(value="updateProduct{prod_id}")
	public String updateProduct(@PathVariable("prod_id") int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		m.addAttribute("productmodel",product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList", listProduct);
		return "ProductUpdate";
		
	}
	@RequestMapping(value="/UpdateProduct")
	public String updateMyProduct(@ModelAttribute Product product,Model m)
	{
		productdao.updateTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("productmodel", new Product());
		return "Product";
	}
	@RequestMapping(value="deleteProduct{prod_id}")
	public String deleteTheProduct(@PathVariable("prod_id")int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		productdao.deleteTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("productmodel", new Product());
		return "Product";
	}
	@RequestMapping(value="/uploadfile")
	public String uploadfile(@RequestParam("pimage") MultipartFile file)
	{
		String path = "C:\\Users\\pratik\\Desktop\\image\\ja.jpg";
	
		File fileupload= new File(path);
		
		if(!file.isEmpty())
		{
			try {
				byte[] arr = file.getBytes();
				FileOutputStream fos = new FileOutputStream(fileupload);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(arr);
				bos.close();
			} catch (IOException e) {
				System.out.println("File not uploaded");
			}
		}
		else{
			System.out.println("File not found");
		}
		System.out.println("File uploaded successfully");
		
		return "Product";
	}
}

