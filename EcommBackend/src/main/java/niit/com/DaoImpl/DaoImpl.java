package niit.com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.dao.Dao;
import niit.com.model.Category;
@Repository("dao")
@Transactional
public class DaoImpl implements Dao
{
	@Autowired
	SessionFactory sessionFactory;

	public void saveTheCategory(Category category) 
	{
		System.out.println("in category"+sessionFactory);
		sessionFactory.getCurrentSession().save(category);	
		
	}

	public void updateTheCategory(Category category) 
	{
		sessionFactory.getCurrentSession().update(category);	
		
	}

	public void deleteTheCategory(Category category) 
	{
		sessionFactory.getCurrentSession().delete(category);
		
	}

	public Category getTheCategory(int catId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class, catId);
		session.close();
		return category;
		
		
	}

	public List<Category> retrieveCategory() 
	{
		

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> retrieveCategory=query.list();
		return retrieveCategory;
	}
	
	
	
}

