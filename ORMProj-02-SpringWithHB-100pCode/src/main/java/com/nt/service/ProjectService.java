package com.nt.service;

import java.util.List;

import com.nt.dto.Projectdto;

public interface ProjectService {
	
	public String registerService(Projectdto dto);
	public Object fetchProjById(int id); 
	public String modifyProjById(int id, int teamSize,double projCost);
	public String removeProjById(int id);
	public List<Projectdto> fetchProjByCost(double start, double end);
}
