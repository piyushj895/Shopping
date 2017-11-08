package niit.com.EcommBackend;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.com.Hiberconfig.HiberConfig;
import niit.com.dao.CartDao;
import niit.com.model.Cart;

public class CartTest 
{
	static CartDao cartDao;
	 @BeforeClass
	    public static void initialize()
	    {
	    	
	    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HiberConfig.class);
	    	context.scan("niit.com.*");
	     
	     cartDao=(CartDao) context.getBean("cartDao");
	    }

	@Test  
	public void saveTheCart()
	{
		 Cart cart=new Cart();
//		 cart.setName("Piyush");
//		 cart.setCartItemId(1);
		 cart.setOrderId(2);
		 cart.setProd_id(101);
		 cart.setPrice(2000);
		 cart.setEmail("piyushj895@gmail.com");
		 cart.setQuantity(2);
		 cart.setProd_name("Book");
		 cartDao.saveTheCart(cart);
		 
				 
	}
@Ignore
	@Test
	public void updateTheCart()
	{
		Cart cart=new Cart();
		cart.setCartItemId(1);
		 cart.setOrderId(2);
		 cart.setProd_id(3);
		 cart.setPrice(3000);
		 cart.setEmail("piyushj895@gmail.com");
		 cart.setQuantity(2);
		 cartDao.updateTheCart(cart);
				
	}
	@Ignore
	@Test
	public void deleteTheCart()
	{
		Cart cart=new Cart();
		cart.setCartItemId(1);
		 cart.setOrderId(2);
		 cart.setProd_id(3);
		 cart.setPrice(3000);
		 cart.setEmail("piyushj895@gmail.com");
		 cart.setQuantity(2);
		 cart.setProd_name("Book");
		 cartDao.deleteTheCart(cart);
	}
	@Ignore
	@Test
	public void getCartItemsTest()
	{
		String email="piyushj895@gmail.com";
		List<Cart> listCartItems=cartDao.retrieveTheCart(email);
		assertNotNull("Problem in Listing CartItem",listCartItems);
		this.showCartItem();
	}
	@Ignore
	@Test
	public void showCartItem()
	{
		List<Cart> listCartItem=cartDao.retrieveTheCart("email");
		for(Cart cart:listCartItem)
		{
			System.out.println("Order Id:"+cart.getOrderId());
			System.out.println("Product Id :"+cart.getProd_id());
		}
	}
	
	
}
