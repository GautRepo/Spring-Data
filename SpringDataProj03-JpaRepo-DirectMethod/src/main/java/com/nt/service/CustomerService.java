package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDto;

public interface CustomerService {
	
	public List<CustomerDto> fetchCustByGivenExampleDto(CustomerDto dto);
	public String deleteAllCust();
}
