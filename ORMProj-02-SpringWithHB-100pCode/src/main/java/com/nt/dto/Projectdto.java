package com.nt.dto;

import java.io.Serializable;


public class Projectdto implements Serializable {
	
	private Integer projId;
	private String projName;
	private Integer teamSize;
	private String location;
	private Double cost;
	private String company;
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Projectdto [projName=" + projName + ", teamSize=" + teamSize + ", location=" + location + ", cost="
				+ cost + ", company=" + company + "]";
	}
	
	

}
