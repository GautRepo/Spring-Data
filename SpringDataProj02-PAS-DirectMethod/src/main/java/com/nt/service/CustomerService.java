package com.nt.service;

import com.nt.dto.CustomerDto;

public interface CustomerService {
	
	public Iterable<CustomerDto> fetchCustByShort(String properties,boolean asc);
	public Iterable<CustomerDto> fetchCustByShort(boolean asc,String... properties);
	public Iterable<CustomerDto> fetchCustByPageNoAndSize(int pageNo,int pageSize);
	public void fetchRecordByPagination(int pageSize);
}
