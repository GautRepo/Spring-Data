package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataProj04JpaRepofinderMethods {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerRepo repo = null;
		
		ctx=SpringApplication.run(SpringDataProj04JpaRepofinderMethods.class, args);
		repo = ctx.getBean(CustomerRepo.class);
		
		//repo.getAllCustomer().forEach(cust->System.out.println(cust));
		
		//repo.getAllCustomerByCadd("Patna").forEach(System.out::println);
		
		//repo.getAllCustomerByCities(50, 5000).forEach(System.out::println);
		
		
		//repo.getAllCustomerByCities("Patna", "Gaya", "abc").forEach(System.out::println);
		
		/*repo.getAllCustomerByCity("Patna").forEach(v->{
		
				for(Object val : v ) {
					System.out.print(val+" ");
					
				}});*/
		
		//repo.getCustomerByName("Gautam").forEach(System.out::println);
		
		/*List<Object[]> list=repo.getDateValueByCname("Gautam");
		
		Object[] obj=list.get(0);
		System.out.println(obj[0]+" "+obj[1]);*/
		
		//System.out.println(repo.modifyCustBillAmtByCity("Patna",100.0));
		
		System.out.println(repo.deleteCustByCity("Patna"));
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
