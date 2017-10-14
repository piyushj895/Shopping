package niit.com.EcommBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.com.Hiberconfig.HiberConfig;
import niit.com.dao.Dao;
import niit.com.model.Category;

public class CategoryTest
{
	static Dao d;
	 @BeforeClass
	    public static void initialize()
	    {
	    	
	    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HiberConfig.class);
	    	context.scan("niit.com.*");
	     d =(Dao) context.getBean("dao");
	    }
	 @Ignore
	@Test  
	    public void saveTheCategory()
	    {
	    	 Category category=new Category();
	         category.setCat_id(6);
	         category.setCat_name("shoes");
	         category.setCat_desc("best shoes");
	         category.setCat_id(8);
	         category.setCat_name("shoe");
	         category.setCat_desc(" shoes");
	        
	        d.saveTheCategory(category) ;
	    }
	 
	 @Ignore
	 @Test
	public void updateTheCategory()
	{
		 Category category=new Category();
        category.setCat_id(6);
        category.setCat_name("Nike shoes");
        category.setCat_desc("best shoes in the market");
   	 
     category.setCat_id(8);
     category.setCat_name("Nike shoes");
     category.setCat_desc("best shoes in the market");
    
       d.updateTheCategory(category);
	}
	 @Ignore
	 @Test
	 public void deleteTheCategory()
		{
			 Category category=new Category();
	         category.setCat_id(8);
	         
	        d.deleteTheCategory(category);
		}
	 @Ignore
	 @Test
	 public void retrieveCategory()
	    {
	    List<Category> Category=d.retrieveCategory();
	    assertNotNull("Problem in Retriving ",Category);
	    this.show(Category);
	    }
	    	
	    	public void show(List<Category> listCategory)
	    	{
	    		for(Category category:listCategory)
	    		{
	    			System.out.println("Category ID:"+category.getCat_id());
	    			System.out.println("Category Name:"+category.getCat_name());
	    			System.out.println("Category Description  = "+category.getCat_desc());
	    		}
	    	}
	    	
	    	@Test
	    	public void getCategoryTest()
	    	{
	    		Category category=d.getTheCategory(3);
	    		assertNotNull("Problem in Getting:",category);
	    		System.out.println("Category ID:"+category.getCat_id());
	    		System.out.println("Category Name:"+category.getCat_name());
	    		System.out.println("Category Description  = "+category.getCat_desc());
		}
}
