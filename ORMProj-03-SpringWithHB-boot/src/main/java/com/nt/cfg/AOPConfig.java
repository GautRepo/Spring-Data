package com.nt.cfg;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class AOPConfig {

	@Autowired
	private SessionFactory sf;

	@Bean(name="tx")
	public HibernateTransactionManager hbTxMgmr() {
		return new HibernateTransactionManager(sf);
	}


}
