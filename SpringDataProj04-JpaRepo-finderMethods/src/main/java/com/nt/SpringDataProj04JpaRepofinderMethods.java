package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataProj04JpaRepofinderMethods {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerRepo repo = null;
		
		ctx=SpringApplication.run(SpringDataProj04JpaRepofinderMethods.class, args);
		repo = ctx.getBean(CustomerRepo.class);
		
		//repo.findByCadd("Patna").forEach(System.out::println);
		//repo.findByCname("Gautam").forEach(System.out::println);
		
		//repo.findBybAmtLessThan(110).forEach(System.out::println);;
		
		//repo.findByCnameLike("G%").forEach(System.out::println);
		
		//repo.findByCnameStartsWith("G").forEach(System.out::println);
		
		//repo.findByCnameEndingWith("a").forEach(System.out::println);
		
		//repo.findByCnameContaining("ya").forEach(System.out::println);
		
		//repo.findByCnameNotNull().forEach(System.out::println);
		
		//repo.findByCnameLike("______").forEach(System.out::println);
		
		//repo.findByCnameLike("___%").forEach(System.out::println);
		
		//repo.findBybillAmtBetween(50, 1500);
	}
}
