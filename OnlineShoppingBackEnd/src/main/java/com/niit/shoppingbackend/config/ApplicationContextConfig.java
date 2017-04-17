package com.niit.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import com.niit.shoppingbackend.model.Product;

@Configuration
@ComponentScan("com.niit.shoppingbackend.*")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name="datasource")
	public DataSource getH2Datasource(){
		BasicDataSource ds= new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/shopping");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;
	}
	
	private Properties getHibernateProperties(){
		Properties p= new Properties();
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;
	}
	
	public SessionFactory getSessionFactory(DataSource datasource){
		LocalSessionFactoryBuilder sessionbuilder= new LocalSessionFactoryBuilder(datasource);
		sessionbuilder.addProperties(getHibernateProperties());
		sessionbuilder.addAnnotatedClass(Product.class);
		return sessionbuilder.buildSessionFactory();
		
	}
	
	

}
