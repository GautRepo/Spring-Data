package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.Project;

@Repository("dao")
public class ProjectImpl implements ProjectDao {
	
	private static final String GET_PROJECT_BY_RANGE="FROM com.nt.entity.Project WHERE cost>=:min AND cost<=:max"; 
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer insert(Project proj) {
		Integer pk= null;
		pk =(Integer)ht.save(proj);
		return pk;
	}

	@Override
	public Project getProjById(int id) {
		Project proj =null;
		
		proj=ht.get(Project.class, id);
		
		return proj;
	}

	@Override
	public boolean updateById(int id, int teamSize, double projCost) {
		Project proj = null;
		boolean flag = false;
		
		proj=ht.get(Project.class, id);
		if(proj!=null) {
			proj.setTeamSize(teamSize);
			proj.setCost(projCost);
			ht.update(proj);
			flag= true;
		}
		
		return flag;
	}

	@Override
	public boolean deleteById(int id) {
		boolean flag= false;
		
		Project proj =ht.get(Project.class, id);
		if(proj!=null) {
			ht.delete(proj);
			flag=true; 
		}
		return flag;
	}

	@Override
	public List<Project> getProjByCost(double start, double end) {
		List<Project> list= null;
		
		list=(List<Project>)ht.findByNamedParam(GET_PROJECT_BY_RANGE, new String[] {"min","max"},new Object[] {start,end});
		return list;
	}

}
