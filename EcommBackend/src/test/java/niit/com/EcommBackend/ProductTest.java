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
		product.setId(3);
		product.setBooks("java Books");
		product.setShoes("Spikes Shoes");
		productdao.saveTheProduct(product);
	}
@Ignore
@Test
public void updateTheProduct()
{
	Product product=new Product();
	product.setId(3);
	product.setBooks("Engg Books");
	product.setShoes("Shoes");
	productdao.updateTheProduct(product);
}
@Ignore
@Test
public void deleteTheProduct()
{
	Product product=new Product();
	product.setId(1);
	product.setBooks("Engg Books");
	product.setShoes("Spikes Shoes");
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
   			System.out.println("Product ID:"+category.getId());
   			System.out.println("Product Books:"+category.getBooks());
   			System.out.println("Product Shoes  = "+category.getShoes());
   		}
   	}
   	
   	@Test
   	public void getTheProduct()
   	{
   		Product product=productdao.getTheProduct(3);
   		assertNotNull("Problem in Getting:",product);
   		System.out.println("Product ID:"+product.getId());
   		System.out.println("Product Books:"+product.getBooks());
   		System.out.println("Product Shoes  = "+product.getShoes());
	}
}


