package niit.com.Hiberconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HiberConfig 
{
	 @Bean(name="sessionFactory")
	    public LocalSessionFactoryBean sessionFactory() 
	 {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[]{"niit.com.*"});
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
}
	 @Bean("dataSource")
	    public DataSource dataSource() 
	 {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/Shoping2");
	        dataSource.setUsername("sa");
	        dataSource.setPassword("sam");
	        return dataSource;
	    }
	 @Bean
	  public Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        properties.put("hibernate.show_sql","true");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        return properties;
	    }

	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) 
	    {
	        HibernateTransactionManager txManager = new HibernateTransactionManager();
	        txManager.setSessionFactory(s);
	        return txManager;
	    }
}

