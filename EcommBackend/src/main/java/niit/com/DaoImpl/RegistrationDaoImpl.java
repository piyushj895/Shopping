package niit.com.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import niit.com.dao.RegistrationDao;
import niit.com.model.RegistrationForm;
@Repository("registrationdao")
@Transactional
public class RegistrationDaoImpl implements RegistrationDao

{
	@Autowired
	SessionFactory sessionFactory;

	public void saveTheRegistration(RegistrationForm registrationForm)
	{
		sessionFactory.getCurrentSession().save(registrationForm);
		System.out.println("in category"+sessionFactory);
		
	}

	public void updateTheRegistration(RegistrationForm registrationForm) 
	{
		sessionFactory.getCurrentSession().update(registrationForm);
		
	}

	public void deleteTheRegistration(RegistrationForm registrationForm) 
	{
		sessionFactory.getCurrentSession().delete(registrationForm);
		
	}

	public RegistrationForm getTheRegistration(int registrationId) 
	{
		Session session=sessionFactory.openSession();
		RegistrationForm registrationForm=(RegistrationForm)session.get(RegistrationForm.class, registrationId);
		session.close();
		return registrationForm;
		
	}
	

	public List<RegistrationForm> retrieveRegistrationForm() 
	{

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from RegistrationForm");
		List<RegistrationForm> retrieveCategory=query.list();
		sessionFactory.close();
		return retrieveRegistrationForm();
	}
}

