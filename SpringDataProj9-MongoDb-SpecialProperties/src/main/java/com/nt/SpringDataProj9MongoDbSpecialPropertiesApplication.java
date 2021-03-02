package com.nt;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.document.Student;
import com.nt.generator.IDGenerator;
import com.nt.repo.StudentRepo;

@SpringBootApplication
public class SpringDataProj9MongoDbSpecialPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringDataProj9MongoDbSpecialPropertiesApplication.class, args);
		StudentRepo repo=ctx.getBean(StudentRepo.class);
		
		Properties batchInfo = new Properties();
		batchInfo.put("java", "11am");
		Student std = new Student();
		std.setSid(IDGenerator.generateId());
		std.setAgeDetails(Map.of("Gautam",24,"khushi",10));
		std.setBatchInfo(batchInfo);
		std.setPhone(Set.of(100l,20l,500l,40l));
		std.setMarks(new Integer[] {10,20,30});
		std.setSub(List.of("java","spring","microservices"));
		std.setSname("Gautam");
		std.setSno(new Random().nextInt(1000));
		
		System.out.println(repo.save(std));
		
		((ConfigurableApplicationContext) ctx).close();
	
	}

}
