package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	/*List<Customer> findByCadd(String addrs);
	
	List<Customer> findByCname(String name);*/
	
	//List<Customer> findBybAmtGreaterThan(double bill);
	
	//List<Customer> findBybAmtLessThan(double bill);
	
	List<Customer> findByCnameLike(String ch);
}
