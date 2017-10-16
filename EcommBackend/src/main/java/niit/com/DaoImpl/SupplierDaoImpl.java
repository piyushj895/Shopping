package niit.com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.com.dao.SupplierDao;
import niit.com.model.Supplier;

@Repository("supplierdao")
@Transactional
public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	SessionFactory sessionFactory;

	public void saveTheSupplier(Supplier supplier) 
	{
		System.out.println("in category"+sessionFactory);
		sessionFactory.getCurrentSession().save(supplier);
			
		
	}

	public void updateTheSupplier(Supplier supplier) 
	{
	sessionFactory.getCurrentSession().update(supplier);	
		
	}

	public void deleteTheSupplier(Supplier supplier) 
	{
	sessionFactory.getCurrentSession().delete(supplier);
		
	}

	public Supplier getTheSupplier(int supplierId) 
	{
		Session session=sessionFactory.openSession();
		Supplier supplierCategory=(Supplier)session.get(Supplier.class, supplierId);
			return supplierCategory;
	}

	public List<Supplier> retrieveSupplier() 
		 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Supplier");
			List<Supplier> retrieveSupplier=query.list();
//			sessionFactory.close();
			return retrieveSupplier;	
		
		}
	}

