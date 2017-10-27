package niit.com.EcommBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.com.Hiberconfig.HiberConfig;
import niit.com.dao.RegistrationDao;
import niit.com.model.RegistrationForm;



public class RegistrationTest 
{
	static RegistrationDao registrationdao;
	@BeforeClass
	public static void intialize()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HiberConfig.class);
	context.scan("niit.com.*");
	registrationdao=(RegistrationDao) context.getBean("registrationdao");
	}	
		@Ignore
		@Test
		public void saveTheRegistration() 
		{
			RegistrationForm registrationForm=new RegistrationForm();
			registrationForm.setEmail("piyushj266@gmail.com");
			registrationForm.setFirst_name("Piyush123");
			registrationForm.setLast_name("Jain123");
			registrationForm.setContact_info("12345678");
			registrationForm.setGender("Male");
			registrationForm.setPassword("123456");
			registrationForm.setCpassword("123456");
			registrationForm.setLocation("India");
			registrationForm.setAddress("A/20,Laxmi Nagar,Andheri East,Mumbai");
			registrationdao.saveTheRegistration(registrationForm);
		}
	@Ignore
		@Test
		public void updateTheRegistration() 
		{
			RegistrationForm registrationForm=new RegistrationForm();
			
			registrationForm.setEmail("piyushj266@gmail.com");
			registrationForm.setFirst_name("Piyush");
			registrationForm.setPassword("123456");
			registrationForm.setCpassword("123456");
			registrationdao.updateTheRegistration(registrationForm);
		}
		@Ignore
		@Test
		public void deleteTheRegistration() 
		{
			RegistrationForm registrationForm=new RegistrationForm();
			
			registrationForm.setEmail("piyushj266@gmail.com");
					registrationdao.deleteTheRegistration(registrationForm);
	}
//			@Ignore
		    	@Test
		    	public void getTheRegistration()
		    	{
		    		RegistrationForm registrationForm=registrationdao.getTheRegistration("piyushj266@gmail.com");
		    		assertNotNull("Problem in Getting:"+registrationForm);
		    
		    		System.out.println("Registration Email:"+registrationForm.getEmail());
	    			System.out.println("Registration First Name:"+registrationForm.getFirst_name());
	    			System.out.println("Registration LastName  = "+registrationForm.getLast_name());
	    			System.out.println("Registration Contact"+registrationForm.getContact_info());
	    			System.out.println("Registration Gender"+registrationForm.getGender());
	    			System.out.println("Registration Password"+registrationForm.getPassword());
	    			System.out.println("Registration Confirm Password"+registrationForm.getCpassword());
	    			System.out.println("Registration Location"+registrationForm.getLocation());
	    			System.out.println("Registration Address"+registrationForm.getAddress());
			}
	}

