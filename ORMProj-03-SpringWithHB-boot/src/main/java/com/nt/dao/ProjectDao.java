package com.nt.dao;

import java.util.List;

import com.nt.entity.Project;

public interface ProjectDao {
	
	public Integer insert(Project proj);
	public Project getProjById(int id);
	public boolean updateById(int id, int teamSize,double projCost);
	public boolean deleteById(int id);
	public List<Project> getProjByCost(double start, double end);
	

}
