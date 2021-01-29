package com.nt.service;


import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDto;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("service")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo repo;

	@Override
	public Iterable<CustomerDto> fetchCustByShort(String property, boolean asc) {
		
		Iterable<Customer> itrCust= null;
		Iterable<CustomerDto> itrDto = new ArrayList<>();
		
		itrCust=repo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC,property));
		
		itrCust.forEach(entity->{
			 CustomerDto dto = new CustomerDto();
			 BeanUtils.copyProperties(entity, dto);
			 ((ArrayList<CustomerDto>) itrDto).add(dto);
			 
		});
		
		return itrDto;
	}

	@Override
	public Iterable<CustomerDto> fetchCustByShort(boolean asc, String... properties) {
		Iterable<Customer> itrCust= null;
		Iterable<CustomerDto> itrDto = new ArrayList<>();
		
		itrCust=repo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC,properties));
		
		itrCust.forEach(entity->{
			 CustomerDto dto = new CustomerDto();
			 BeanUtils.copyProperties(entity, dto);
			 ((ArrayList<CustomerDto>) itrDto).add(dto);
			 
		});
		
		return itrDto;
	
	}
	
	@Override
	public Iterable<CustomerDto> fetchCustByPageNoAndSize(int pageNo, int pageSize) {
		Pageable pageable = null;
		//Page<Customer> page = null;
		Slice<Customer> slice= null;
		Iterable<Customer> itrCust= null;
		
		pageable=PageRequest.of(pageNo,pageSize);
		
		//page=repo.findAll(pageable);
		
		slice =repo.findAll(pageable);
		
		itrCust=slice.getContent();
		
		System.out.println(slice.getSize()+"**"+slice.getNumber()+"**"+slice.hasContent()+"**"+slice.isEmpty());
		
		Iterable<CustomerDto> itrDto = new ArrayList<>();
		
		itrCust.forEach(entity->{
			 CustomerDto dto = new CustomerDto();
			 BeanUtils.copyProperties(entity, dto);
			 ((ArrayList<CustomerDto>) itrDto).add(dto);
			 
		});
		
		return itrDto;
	}
	
	@Override
	public void fetchRecordByPagination(int pageSize) {
		long recordCount =0;
		long pageCount=0;
		
		Pageable pageable = null;
		Page<Customer> page = null;
		
		recordCount =repo.count();
		pageCount =recordCount/pageSize ;
		
		pageCount=pageCount%pageSize==0?pageCount:++pageCount;
		
		for(int i=0;i<pageCount;i++) {
			pageable=PageRequest.of(i, pageSize);
			page=repo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("Page "+(i+1)+" of "+page.getTotalPages());
		}
		
	}

}





















