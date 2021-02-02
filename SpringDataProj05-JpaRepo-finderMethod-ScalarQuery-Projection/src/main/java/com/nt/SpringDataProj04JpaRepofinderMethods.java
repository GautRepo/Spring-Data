package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repo.CustomerRepo;
import com.nt.repo.CustomerRepo.ResultView1;
import com.nt.repo.CustomerRepo.ResultView2;

@SpringBootApplication
public class SpringDataProj04JpaRepofinderMethods {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CustomerRepo repo = null;
		
		ctx=SpringApplication.run(SpringDataProj04JpaRepofinderMethods.class, args);
		repo = ctx.getBean(CustomerRepo.class);
		
		/*List<ResultView1> listView=repo.findByCadd("Patna");
		
		for(ResultView1 v : listView) {
			System.out.println(v.getCname()+" "+v.getCno()+" "+v.getClass());
		}
		
		
		List<ResultView2> listView2=repo.findByCnoBetween(0, 5);
		
		for(ResultView2 v2 :listView2) {
			System.out.println(v2.getCname()+" "+ v2.getBillAmt()+" "+v2.getClass());
		}*/
		
		repo.findByCadd("Kol", ResultView1.class).forEach(v->System.out.println(v.getCname()+" "+v.getCno()));
		
		
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
