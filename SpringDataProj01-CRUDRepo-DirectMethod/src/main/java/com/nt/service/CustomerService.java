package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDto;
import com.nt.entity.Customer;

public interface CustomerService {
	
	public String register(CustomerDto dto);
	public String groupRegisteration(List<CustomerDto> listdto);
	public String deleteById(int id);
	public String removeGivenCust(Iterable<CustomerDto> itdto);
	public int fetchCustomerCount();
	public Iterable<CustomerDto> fetchAllCust();

}
