package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.ICompanyManegmentServices;

@SpringBootApplication
public class SpringDataProj7AssociationMapingOneToManyApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringDataProj7AssociationMapingOneToManyApplication.class, args);
	

		ICompanyManegmentServices service =ctx.getBean("comService",ICompanyManegmentServices.class);
		
		try {
			//service.saveDataUsingParent();
			//service.saveDataUsingChild();
			//service.loadDetailsUsingParent();
			service.loadDataUsingChild();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	
	}

}
