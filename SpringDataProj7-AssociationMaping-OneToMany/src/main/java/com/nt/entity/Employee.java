package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Employee_MTO")
@Getter
@Setter
public class Employee {
	
	@Id
	@SequenceGenerator(name = "emp1",sequenceName = "emp_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator="emp1", strategy = GenerationType.AUTO)
	private Integer eno;
	
	@Column(length=20)
	private String ename;
	
	@Column(length=20)
	private String eaddrs;
	
	private Float esal;
	
	@ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_no",referencedColumnName = "deptNo")
	private Department dept;

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eaddrs=" + eaddrs + ", esal=" + esal + "]";
	}
	
	
	
}
