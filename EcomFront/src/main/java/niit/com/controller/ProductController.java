package niit.com.controller;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
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
		List<Category> listCategory=dao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
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
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
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
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		List<Category> listCategory=dao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);
		return "ProductUpdate";
		
	}
	@RequestMapping(value="/adminUpdateProduct")
	public String updateMyProduct(@ModelAttribute Product product,Model m)
	{
		productdao.updateTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("productmodel", new Product());
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);
		List<Category> listCategory=dao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);
		return "Product";
	}
	@RequestMapping(value="admindeleteProduct{prod_id}")
	public String deleteTheProduct(@PathVariable("prod_id")int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		productdao.deleteTheProduct(product);
		List<Product> listProduct=productdao.retrieveProduct();
		m.addAttribute("productList",listProduct);
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		m.addAttribute("supplierList",listSupplier);m.addAttribute("productmodel", new Product());
		
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
	public List<String> getCategories()
	{
		List<Category> listCategory=dao.retrieveCategory();
		List<String> categoryList=new LinkedList<String>();
		
		for(Category category:listCategory)
		{
			categoryList.add(category.getCat_name());
		}
		
		return categoryList;
	}
	public List<String> getSuppliers()
	{
		List<Supplier> listSupplier=supplierDao.retrieveSupplier();
		List<String> supplierList=new LinkedList<String>();
		
		for(Supplier supplier:listSupplier)
		{
			supplierList.add(supplier.getSup_name());
			
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
	@RequestMapping(value="adminshowProduct{prod_id}")
	public String showProduct(@PathVariable("prod_id")int prodId,Model m)
	{
		Product product=productdao.getTheProduct(prodId);
		m.addAttribute("product",product);
		m.addAttribute("productmodel", new Product());
		return "Product";
}

}