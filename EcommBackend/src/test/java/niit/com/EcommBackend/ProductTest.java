package niit.com.EcommBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.com.Hiberconfig.HiberConfig;
import niit.com.dao.ProductDao;
import niit.com.model.Product;

public class ProductTest 
{
	static ProductDao productdao;
	@BeforeClass
	public static void initialize()
	{	
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HiberConfig.class);
	context.scan("niit.com.*");
	productdao =(ProductDao) context.getBean("productdao");
	}
	@Ignore
	@Test
	public void saveTheProduct() 
	{
		Product product=new Product();
		product.setProd_id(100);
		product.setProd_name("Engg Books");
		product.setProd_desc("Best book");
		product.setStock(10);
		product.setPrice(600);
		product.setCat_id(102);
		product.setSupplierId(101);
		productdao.saveTheProduct(product);
	}
@Ignore
@Test
public void updateTheProduct()
{
	Product product=new Product();
	product.setProd_id(100);
	product.setProd_name("Java Books");
	product.setProd_desc("Best book");
	product.setStock(10);
	product.setPrice(600);
	product.setCat_id(102);
	product.setSupplierId(101);

	productdao.updateTheProduct(product);
}
@Ignore
@Test
public void deleteTheProduct()
{
	Product product=new Product();
	product.setProd_id(100);
	productdao.deleteTheProduct(product);
}
@Ignore
@Test
public void retrieveProduct()
   {
   List<Product> Product=productdao.retrieveProduct();
   assertNotNull("Problem in Retriving ",Product);
   this.show(Product);
   }
   	
   	public void show(List<Product> product)
   	{
   		for(Product category:product)
   		{
   			System.out.println("Product ID:"+category.getProd_id());
   	   		System.out.println("Product Name:"+category.getProd_name());
   	   		System.out.println("Product Category ID= "+category.getCat_id());
   	   		System.out.println("Product Stock = "+category.getStock());
   	   		System.out.println("Product Price= "+category.getPrice());
   	   		System.out.println("Product Supplier ID = "+category.getSupplierId());
   	   		
   			
   		}
   	}
//   	@Ignore
   	@Test
   	public void getTheProduct()
   	{
   		Product product=productdao.getTheProduct(100);
   		assertNotNull("Problem in Getting:",product);
   		System.out.println("Product ID:"+product.getProd_id());
   		System.out.println("Product Name:"+product.getProd_name());
   		System.out.println("Product Category ID= "+product.getCat_id());
   		System.out.println("Product Stock = "+product.getStock());
   		System.out.println("Product Price= "+product.getPrice());
   		System.out.println("Product Supplier ID = "+product.getSupplierId());
   		
	}
}


