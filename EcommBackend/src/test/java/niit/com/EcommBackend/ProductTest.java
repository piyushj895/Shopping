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
		product.setProd_id(2);
		product.setProd_name("Engg Books");
		product.setProd_desc("Best book");
		productdao.saveTheProduct(product);
	}
@Ignore
@Test
public void updateTheProduct()
{
	Product product=new Product();
	product.setProd_id(2);
	product.setProd_name("Java Books");
	product.setProd_desc("Best book");
	productdao.updateTheProduct(product);
}
@Ignore
@Test
public void deleteTheProduct()
{
	Product product=new Product();
	product.setProd_id(2);
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
   			System.out.println("Product Description  = "+category.getProd_desc());
   			
   		}
   	}
   	
   	@Test
   	public void getTheProduct()
   	{
   		Product product=productdao.getTheProduct(2);
   		assertNotNull("Problem in Getting:",product);
   		System.out.println("Product ID:"+product.getProd_id());
   		System.out.println("Product Books:"+product.getProd_name());
   		System.out.println("Product Shoes  = "+product.getProd_desc());
	}
}


