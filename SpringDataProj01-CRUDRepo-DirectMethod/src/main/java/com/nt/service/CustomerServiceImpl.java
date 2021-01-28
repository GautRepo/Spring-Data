package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDto;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("service")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo repo;
	
	@Override
	public String register(CustomerDto dto) {
		System.out.println(repo.getClass()+"------>"+Arrays.toString(repo.getClass().getInterfaces()));
		Customer entity = null;
		
		entity= new Customer();
		BeanUtils.copyProperties(dto, entity);
		entity = repo.save(entity);
		return entity!=null?"Object Saved":"Object Not Saved";
	}

	@Override
	public String groupRegisteration(List<CustomerDto> listdto) {
		List<Customer> listcust= new ArrayList<>();
		List<Customer> listcust1= null;
		
		listdto.forEach(dto->{
			Customer entity = new Customer();
			BeanUtils.copyProperties(dto, entity);
			listcust.add(entity);
		});
		listcust1=(List<Customer>) repo.saveAll(listcust);
		
		return listcust1!=null?"All entity are saved":"Operation failed";
	}

	@Override
	public String deleteById(int id) {
		boolean flag =false;
		flag=repo.existsById(id);
		if(flag)
			repo.deleteById(id);
		return flag?"deleted":"not delete";
	}

	@Override
	public String removeGivenCust(Iterable<CustomerDto> itdto) {
		Iterable<Customer> itEntities= new ArrayList<>(); 
		
		itdto.forEach(dto->{
			Customer entity = new Customer();
			BeanUtils.copyProperties(dto, entity);
			((List<Customer>) itEntities).add(entity);
		});
		repo.deleteAll(itEntities);
		return "Bulk Record are deleted";
	}

	@Override
	public int fetchCustomerCount() {
		
		return (int)repo.count();
	}

	@Override
	public Iterable<CustomerDto> fetchAllCust() {
		Iterable<Customer> custitr=null;
		Iterable<CustomerDto> itrDto= new ArrayList<>();
		custitr= repo.findAll();
		custitr.forEach(entity->{
			CustomerDto dto = new CustomerDto();
			BeanUtils.copyProperties(entity, dto);
			((List<CustomerDto>) itrDto).add(dto);
		});
		
		return itrDto;
	}
	

}





















