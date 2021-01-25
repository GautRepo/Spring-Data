package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.ProjectDao;
import com.nt.dto.Projectdto;
import com.nt.entity.Project;

@Service("service")
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao dao;

	@Override
	public String registerService(Projectdto dto) {
		Project entity= null; 
		Integer id_val= null;
		
		entity= new Project();
		BeanUtils.copyProperties(dto, entity);
		id_val=dao.insert(entity);
		
		return "Project is registerd with id value "+id_val;
	}

	@Override
	public Object fetchProjById(int id) {
		Project proj = null;
		Projectdto dto =null;
		proj=dao.getProjById(id);
		if(proj!=null) {
			dto = new Projectdto();
			BeanUtils.copyProperties(proj, dto);
		}
		return dto!=null?dto:"record not found";
	}

	@Override
	public String modifyProjById(int id, int teamSize, double projCost) {
		boolean flag =false;
		
		flag=dao.updateById(id, teamSize, projCost);
		
		return flag==false?"Project not found to update":"project found and updated";
	}
	@Override
	public String removeProjById(int id) {
		boolean flag = false;
		flag=dao.deleteById(id);
		
		return flag!=false?"Project found and deleted":" project not found to delete";
	}

	@Override
	public List<Projectdto> fetchProjByCost(double start, double end) {
		
		List<Projectdto> listdto=  new ArrayList<>();;
		
		
		List<Project> listProj=dao.getProjByCost(start, end);
		
		
		listProj.forEach(p->{
			Projectdto dto =new Projectdto();
			BeanUtils.copyProperties(p, dto);
			listdto.add(dto);
		});
		
		return listdto;
	}

}














