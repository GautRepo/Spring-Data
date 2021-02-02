package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	interface ResultView1 extends View{
		int getCno();
		String getCname();
	}
	
	List<ResultView1> findByCadd(String name);
	
	interface ResultView2 extends View{
		String getCname();
		Double getBillAmt();
	}
	
	List<ResultView2> findByCnoBetween(int min, int max);
	
	
	/*-------------Dynamic Projection-----------------*/
	
	/*<T>List<T> findByCadd (String name,Class<T> clazz);*/
	
	interface View {
		
	}
	<T extends View>List<T> findByCadd(String add,Class<T> clazz);
}


































