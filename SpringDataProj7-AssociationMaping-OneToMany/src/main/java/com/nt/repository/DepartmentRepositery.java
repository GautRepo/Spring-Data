package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Department;

public interface DepartmentRepositery extends JpaRepository<Department, Integer> {

}
