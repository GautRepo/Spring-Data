package com.nt.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.repository.DepartmentRepositery;
import com.nt.repository.EmployeeRepositery;

@Service("comService")
public class CompanyMgmtServiceImpl implements ICompanyManegmentServices{
	
	@Autowired
	private EmployeeRepositery empRepo;
	
	@Autowired
	private DepartmentRepositery deptRepo;

	@Override
	public void saveDataUsingParent() {
		//child property
		
		Employee emp = new Employee();
		emp.setEaddrs("Patna"); emp.setEname("Gautam"); emp.setEsal(60000.0f);
		
		//parent prop
		Department dept = new Department();
		dept.setDeptLocation("hyd"); dept.setDeptName("IT"); dept.setEmps(Set.of(emp));
		emp.setDept(dept);
		
		deptRepo.save(dept);

	}

	@Override
	public void saveDataUsingChild() {
	//child property
		
		Employee emp = new Employee();
		emp.setEaddrs("Pat"); emp.setEname("Shivam"); emp.setEsal(60000.0f);
		
		//parent prop
		Department dept = new Department();
		dept.setDeptLocation("Bombay"); dept.setDeptName("CIVIL"); dept.setEmps(Set.of(emp));
		emp.setDept(dept);
		
		empRepo.save(emp);
		
	}

	@Override
	@Transactional
	public void loadDetailsUsingParent() {
		List<Department> listDept=deptRepo.findAll();
		
		listDept.forEach(dept->{
			System.out.println(dept);
			Set<Employee> setEmp=dept.getEmps();
			setEmp.forEach(emp->{
				System.out.println(emp);
			});
		});
	}
	
	@Override
	@Transactional
	public void loadDataUsingChild() {
		List<Employee> listEmp =empRepo.findAll();
		
		listEmp.forEach(emp->{
			System.out.println(emp);
			Department dept = emp.getDept();
			System.out.println(dept);
		});
	}

	
	
	
	
	
}
