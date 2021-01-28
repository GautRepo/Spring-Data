package com.nt.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.Project;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PersistenceConfig {
	
	@Autowired
	private DataSource hkds;
	
	
	@Bean(name="sesfact")
	public LocalSessionFactoryBean createLocalSession() {
		
		LocalSessionFactoryBean bean= null;
		Properties props = null;
		
		bean= new LocalSessionFactoryBean();
		bean.setDataSource(hkds);
		bean.setAnnotatedClasses(Project.class);
		props= new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		bean.setHibernateProperties(props);
		
		return bean;
	}
	
	@Bean(name="ht")
	public HibernateTemplate createHT() {
		return new HibernateTemplate(createLocalSession().getObject());
	}

}

