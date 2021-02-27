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
	/*__________________________Notes-------------------------------*/
	/*// -------------------------static Projections -----------------------------------------
	interface ResultsView1 extends View{
		Integer getCno();
		String   getCname();
	}
	
	 //SELECT CNO,CNAME FROM CUSTOMER  WHERE CADD=?
	 List<ResultsView1>  findByCadd(String addrs);
	
	 interface ResultsView2 extends View{
			String getCname();
			double   getBillAmt();
		}	         
	 
	 
	//SELECT CNAME,BILLAMT FROM CUSTOMER  WHERE CNO BETWEEN(1,5)
		 List<ResultsView2>  findByCnoBetween(int min,int max);
	        
  //------------------------- Dyanamic Projections-----------------------------------------------------	                          
         interface View{
        	 
         }
		 
		 //design the method with generics  with dynamic Projections 
		 // <T> List<T>  findByCadd(String addrs,Class<T> clzz);
         <T extends View> List<T>  findByCadd(String addrs,Class<T> clzz);*/
}


































