package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.CustomerDto;
import com.nt.service.CustomerService;

@SpringBootApplication
public class SpringDataProj03JpaRepoDirectMethodApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerService service=null;
	
		
		ctx=SpringApplication.run(SpringDataProj03JpaRepoDirectMethodApplication.class, args);
		service=ctx.getBean("service",CustomerService.class);
		/*
		 * CustomerDto dto =new CustomerDto();
		 * 
		 * dto.setBAmt(150d);
		 * 
		 * service.fetchCustByGivenExampleDto(dto).forEach(System.out::println);
		 */
		
		System.out.println(service.deleteAllCust());
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
