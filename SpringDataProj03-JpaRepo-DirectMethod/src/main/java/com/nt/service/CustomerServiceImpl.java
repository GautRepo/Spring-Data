package com.nt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDto;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("service")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo repo;

	@Override
	public List<CustomerDto> fetchCustByGivenExampleDto(CustomerDto dto) {
		Customer entity = null;
		Example<Customer> example = null;
		List<Customer> custitr = null;
		List<CustomerDto> itrDto = new ArrayList<>();
		
		entity = new Customer();
		BeanUtils.copyProperties(dto, entity);
		
		example = Example.of(entity);
		custitr=  repo.findAll(example);
		
		custitr.forEach(ent->{
			CustomerDto dto1 = new CustomerDto();
			BeanUtils.copyProperties(ent, dto1);
			itrDto.add(dto1);
		});
		
		return itrDto;
	}

	@Override
	public String deleteAllCust() {
		
		repo.deleteAllInBatch();
		return "All Customer are deleted";
	}

	

}

























