package niit.com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.dao.ProductDao;
import niit.com.model.Category;
import niit.com.model.Product;
@Transactional
@Repository("productdao")
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	SessionFactory sessionFactory;

	public void saveTheProduct(Product product) 
	{
		sessionFactory.getCurrentSession().save(product);
		
	}

	public void updateTheProduct(Product product) 
	{
		sessionFactory.getCurrentSession().update(product);
		
	}

	public void deleteTheProduct(Product product) 
	{
		sessionFactory.getCurrentSession().delete(product);
		
	}

	public Product getTheProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class, productId);
		session.close();
		return product;
	}

	public List<Product> retrieveProduct() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Category> retrieveCategory=query.list();
		sessionFactory.close();
		return retrieveProduct();
	}

}