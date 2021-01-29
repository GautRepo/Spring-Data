package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.CustomerService;

@SpringBootApplication
public class SpringDataProj02PASDirectMethodApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerService service=null;
	
		
		ctx=SpringApplication.run(SpringDataProj02PASDirectMethodApplication.class, args);
		service=ctx.getBean("service",CustomerService.class);
		
		//service.fetchCustByShort("cname", false).forEach(System.out::println);
		
		//service.fetchCustByShort(false,"cname","cadd").forEach(System.out::println);
		
		//service.fetchCustByPageNoAndSize(1, 3).forEach(System.out::println);
		
		service.fetchRecordByPagination(3);
		
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
