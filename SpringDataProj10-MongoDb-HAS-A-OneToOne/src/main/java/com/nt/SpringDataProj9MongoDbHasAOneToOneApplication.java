package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.doc.DrivingLicence;
import com.nt.doc.Person;
import com.nt.repo.IPersonRepo;

@SpringBootApplication
public class SpringDataProj9MongoDbHasAOneToOneApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringDataProj9MongoDbHasAOneToOneApplication.class, args);
	
		IPersonRepo repo=ctx.getBean(IPersonRepo.class);
		
		DrivingLicence dl = new DrivingLicence(517l, "domastic", LocalDate.of(2021, 10, 26));
		
		System.out.println(repo.save(new Person(12,"Gautam","pat",dl)));
	
	}

}
