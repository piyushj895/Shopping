package niit.com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.dao.CartDao;
import niit.com.model.Cart;
@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public void saveTheCart(Cart cart) 
	{
		System.out.println("in cart"+sessionFactory);
		sessionFactory.getCurrentSession().save(cart);
		
	}

	public void updateTheCart(Cart cart) 
	{
		sessionFactory.getCurrentSession().update(cart);
		
	}

	public void deleteTheCart(Cart cart) 
	{
		sessionFactory.getCurrentSession().delete(cart);
		
	}

	public Cart getTheCart(int prodId) 
	{
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class,prodId);
		session.close();
		return cart;
	}

	public List<Cart> retrieveTheCart(String email) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where email=:email");
		query.setParameter("email", email);
		List<Cart> listCartItem=query.list();
		session.close();
		return listCartItem;
	}



}


