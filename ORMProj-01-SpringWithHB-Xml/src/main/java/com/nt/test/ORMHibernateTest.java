package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.Projectdto;
import com.nt.service.ProjectService;

public class ORMHibernateTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ProjectService services = null;
		String result = null;
		Projectdto dto= null;
		
		ctx= new ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
		services=ctx.getBean("service",ProjectService.class);
		
		/*try {
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
		}*/
		//System.out.println(services.fetchProjById(1));
		
		//System.out.println(services.modifyProjById(1, 14, 12000));
		//System.out.println(services.removeProjById(1));
		
		List<Projectdto> listdto=services.fetchProjByCost(8000, 25000);
		
		listdto.forEach(System.out::println);
		
		((AbstractApplicationContext) ctx).close();
	}

}
