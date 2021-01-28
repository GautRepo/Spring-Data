package com.nt;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.CustomerDto;
import com.nt.service.CustomerService;

@SpringBootApplication
public class SpringDataProj01CrudRepoDirectMethodApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerService service=null;
		CustomerDto dto1,dto2= null;
		
		ctx=SpringApplication.run(SpringDataProj01CrudRepoDirectMethodApplication.class, args);
		service=ctx.getBean("service",CustomerService.class);
		/*try {
			dto= new CustomerDto();
			dto.setCname("Puja");
			dto.setCadd("hyd");
			dto.setBAmt(100);
			System.out.println(service.register(dto));;
			
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}*/
		/*dto1= new CustomerDto();
		dto1.setCname("Ishita");
		dto1.setCadd("Ben");
		dto1.setBAmt(50);
		
		dto2= new CustomerDto();
		dto2.setCname("Rashmi");
		dto2.setCadd("Ben");
		dto2.setBAmt(500);
		try {
			System.out.println(service.groupRegisteration(Arrays.asList(dto1, dto2)));
			
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		
		}*/
		
		//System.out.println(service.deleteById(2));
		
		//System.out.println(service.removeGivenCust(List.of(new CustomerDto(3),new CustomerDto(4) )));
		
		//System.out.println(service.fetchCustomerCount());
		
		System.out.println(service.fetchAllCust());
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
