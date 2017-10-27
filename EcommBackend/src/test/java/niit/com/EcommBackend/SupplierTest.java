package niit.com.EcommBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.com.Hiberconfig.HiberConfig;
import niit.com.dao.SupplierDao;
import niit.com.model.Supplier;


public class SupplierTest 
{
	static SupplierDao supplierDao;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HiberConfig.class);
	    context.scan("niit.com.*");
	    supplierDao=(SupplierDao) context.getBean("supplierdao");
	}
@Ignore	
	@Test
	public void saveTheSupplier() 
	{
		Supplier supplierCategory=new Supplier();
		supplierCategory.setSup_id(9);
	     supplierCategory.setSup_name("def");
	     supplierCategory.setSup_email("def@gmail.com");
	     supplierCategory.setSup_contact("6477878");
	     supplierCategory.setSup_address("Mumbai,Andheri,Mahakali");
	    supplierDao.saveTheSupplier(supplierCategory);

	}
@Ignore
@Test
public void updateTheSupplier()
{
	Supplier supplierCategory=new Supplier();
	supplierCategory.setSup_id(9);
    supplierCategory.setSup_name("def");
    supplierCategory.setSup_email("def@gmail.com");
    supplierCategory.setSup_contact("9827871");
    supplierCategory.setSup_address("Mumbai,Andheri,Mahakali");
   supplierDao.updateTheSupplier(supplierCategory);
}
@Ignore
@Test
public void deleteTheCategory()
{
	Supplier supplierCategory=new Supplier();
    supplierCategory.setSup_id(3);
    
   
   supplierDao.deleteTheSupplier(supplierCategory);
}
@Ignore
@Test
public void retrieveSupplier()
   {
   List<Supplier> Category=supplierDao.retrieveSupplier();
   assertNotNull("Problem in Retriving ",Category);
   this.show(Category);
   }
   	
   	public void show(List<Supplier> listSupplier)
   	{
   		for(Supplier category:listSupplier)
   		{
   			System.out.println("Supplier ID:"+category.getSup_id());
   			System.out.println("Supplier Name:"+category.getSup_name());
   			System.out.println("Supplier Email  = "+category.getSup_email());
   			System.out.println("Supplier Contact"+category.getSup_contact());
   			System.out.println("Supplier Address "+category.getSup_address());
   		}
   	}
   	
   	@Test
   	public void getSupplier()
   	{
   		Supplier category=supplierDao.getTheSupplier(9);
   		assertNotNull("Problem in Getting:",category);
   		System.out.println("Supplier ID:"+category.getSup_id());
			System.out.println("Supplier Name:"+category.getSup_name());
			System.out.println("Supplier Email  = "+category.getSup_email());
			System.out.println("Supplier Contact"+category.getSup_contact());
			System.out.println("Supplier Address "+category.getSup_address());
   			}

}
