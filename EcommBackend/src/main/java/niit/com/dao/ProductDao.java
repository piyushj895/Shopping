package niit.com.dao;

import java.util.List;

import niit.com.model.Product;

public interface ProductDao 
{
	public void saveTheProduct(Product product);
	public void updateTheProduct(Product product);
	public void deleteTheProduct(Product product);
	public Product getTheProduct(int productId);
	public List<Product> retrieveProduct();
}
