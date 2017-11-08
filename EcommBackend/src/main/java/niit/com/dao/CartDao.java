package niit.com.dao;

import java.util.List;

import niit.com.model.Cart;

public interface CartDao 
{
	public void saveTheCart(Cart cart);
	public void updateTheCart(Cart cart);
	public void deleteTheCart(Cart cart);
	public Cart getTheCart(int productId); 
	public List<Cart> retrieveTheCart(String email);
}
