package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	/*List<Customer> findByCadd(String addrs);
	
	List<Customer> findByCname(String name);*/
	
	//List<Customer> findBybAmtGreaterThan(double bill);
	
	//List<Customer> findBybAmtLessThan(double bill);
	
	//List<Customer> findByCnameLike(String ch);
	
	//List<Customer> findByCnameStartsWith(String word);
	
	//List<Customer> findByCnameEndingWith(String word);
	
	//Iterable<Customer> findByCnameContaining(String snip);
	
	//Iterable<Customer> findByCnameNotNull();
	
	/*SELECT CNO,CNAME,CADD,BAMT WHERE CNAME LIKE "____"
	List<Customer> findByCnameLike(String input);*/
	
	/*SELECT CNO,CNAME,CADD,BAMT WHERE CNAME LIKE "___%"
	List<Customer> findByCnameLike(String input);*/
	
	/*SELECT CNO,CNAME,CADD,BAMT WHERE BAMT BETWEEN(50,1500)*/
	
	Iterable<Customer> findBybillAmtBetween(double a, double b);
	
	
	
}


































