package com.nt;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.doc.BankAccount;
import com.nt.doc.PersonInfo;
import com.nt.doc.VisaInfo;
import com.nt.repo.PersonInfoRepo;

@SpringBootApplication
public class SpringDataProj11MongoDbHasAOneToManyApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringDataProj11MongoDbHasAOneToManyApplication.class, args);
	
		PersonInfoRepo repo= ctx.getBean(PersonInfoRepo.class);
		BankAccount ac1 = new BankAccount(123l,"saving",2020.0f);
		BankAccount ac2 = new BankAccount(124l,"saving",7000.0f);
		
		VisaInfo info1 = new VisaInfo(544l,"US",LocalDate.of(2025, 8, 25));
		VisaInfo info2 = new VisaInfo(540l,"Russia",LocalDate.of(2014, 8, 25));
		
		PersonInfo pinfo = new PersonInfo();
		pinfo.setMapAcc(Map.of("gautam", ac1,"shubh",ac2));
		pinfo.setVisaSet(Set.of(info1,info2));
		pinfo.setPadd("Patna");
		pinfo.setPid(new Random().nextInt(1000));
		pinfo.setPname("gautam");
		
		System.out.println(repo.save(pinfo));
		
		
	
	}

}
