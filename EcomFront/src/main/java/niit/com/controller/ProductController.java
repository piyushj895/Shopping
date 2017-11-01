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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import niit.com.dao.Dao;
import niit.com.dao.ProductDao;
import niit.com.dao.SupplierDao;
import niit.com.model.Category;
import niit.com.model.Product;
import niit.com.model.Supplier;


@Controller
public class ProductController 
{
	@Autowired
	ProductDao productdao;
	@Autowired
	Dao dao;
	@Autowired
	SupplierDao supplierDao;
	@RequestMapping(value="/adminproduct")
	public String showTheProduct(Model m)
	{
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute(listProduct);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());
		m.addAttribute("productmodel", new Product());
		return "Product";
}
	
	@RequestMapping(value="/adminshowTheProduct")
	public String saveTheProduct(@ModelAttribute Product product,Model m ,@RequestParam("pimage") MultipartFile file)
{
		productdao.saveTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList", listProduct);
		m.addAttribute("productmodel", new Product());
		String path = "C:\\Users\\pratik\\Desktop\\Shopping-master\\EcomFront\\src\\main\\webapp\\resources\\images\\";
		String totalFileWithPath=path+String.valueOf(product.getProd_id())+".jpg";
		File fileupload= new File(totalFileWithPath);
		
		if(!file.isEmpty())
		{
			try {
				byte[] arr = file.getBytes();
				FileOutputStream fos = new FileOutputStream(fileupload);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				bos.write(arr);
				bos.close();
			} 
			catch (IOException e) 
			{
				System.out.println("File not uploaded");
			}
		}
		else
		{
			System.out.println("File not found");
		}
		System.out.println("File uploaded successfully");
		
		return "Product";


	
}
	@RequestMapping(value="adminupdateProduct{prod_id}")
	public String updateProduct(@PathVariable("prod_id") int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		m.addAttribute("productmodel",product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList", listProduct);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());
		return "ProductUpdate";
		
	}
	@RequestMapping(value="/adminUpdateProduct")
	public String updateMyProduct(@ModelAttribute Product product,Model m)
	{
		productdao.updateTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("productmodel", new Product());
		return "Product";
	}
	@RequestMapping(value="admindeleteProduct{prod_id}")
	public String deleteTheProduct(@PathVariable("prod_id")int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		productdao.deleteTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("productmodel", new Product());
		return "Product";
	}
	@RequestMapping(value="userHome")
	public String showProducts(@ModelAttribute Product product,Model m)
	{
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("productmodel", new Product());
		
		return "UserHome";
	}
	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category> listCategory=dao.retrieveCategory();
		LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
		
		for(Category category:listCategory)
		{
			categoryList.put(category.getCat_id(),category.getCat_name());
		}
		
		return categoryList;
	}
	public LinkedHashMap<Integer,String> getSuppliers()
	{
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		LinkedHashMap<Integer,String> supplierList=new LinkedHashMap<Integer,String>();
		
		for(Supplier supplier:listSupplier)
		{
			supplierList.put(supplier.getSup_id(),supplier.getSup_name());
		}
		
		return supplierList;
	}
	@RequestMapping(value="prod_desc/{prod_id}")
	public String showProductDesc(@PathVariable("prod_id")int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		m.addAttribute("product",product);
		m.addAttribute("productmodel", new Product());
		return "ProdDesc";
	}
}

