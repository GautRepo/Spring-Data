package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.Projectdto;
import com.nt.service.ProjectService;

@SpringBootApplication
public class OrmProj03SpringWithHbBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= null;
		Projectdto dto = null;
		String result=null;
		
		ctx=SpringApplication.run(OrmProj03SpringWithHbBootApplication.class, args);
		
		ProjectService services=ctx.getBean("service",ProjectService.class);
		
		try {
			dto= new Projectdto();
			dto.setCompany("OpenFx1");
			dto.setCost(20000.0);
			dto.setLocation("Patna");
			dto.setProjName("Student Mgmt");
			dto.setTeamSize(8);
			result=services.registerService(dto);
			System.out.println(result);
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	}

}
