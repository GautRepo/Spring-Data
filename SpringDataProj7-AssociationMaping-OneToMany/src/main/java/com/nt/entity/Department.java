package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Department_OTM")
@Getter
@Setter
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptNo;
	
	@Column(length=20)
	private String deptName;
	
	@Column(length=20)
	private String deptLocation;
	
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="dept_no",referencedColumnName = "deptNo")
	private Set<Employee> emps;

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", deptLocation=" + deptLocation + "]";
	}
	
	

}
