package com.cp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cp.demo.entity.Customer;
import com.cp.demo.entity.Address;
import com.cp.demo.exception.CustomerNotFoundException;
import com.cp.demo.repository.ICustomerRepository;


import com.cp.demo.exception.ModelNotFoundException;

import com.cp.demo.exception.ModelAddException;




@Service
@Transactional
public class ICustomerImpl implements ICustomerService{
	
	private static final String userIdnotFound = "UserId is Invalid";
	@Autowired
	private ICustomerRepository ICustomerRepository;
	

	@Override
	public Customer addCustomer(Customer customer) throws ModelAddException {
		// TODO Auto-generated method stub
		Optional<Customer> result = ICustomerRepository.findById(customer.getUserId());
		try {
			if(result.isPresent()) {
				throw new ModelAddException("Invalid Details");
			}
		}catch(Exception e2) {
			throw new ModelAddException("UserId is already Exists");
		}
		return ICustomerRepository.save(customer);
	}


	@Override
	public Customer getCustomer(String userId) {
		// TODO Auto-generated method stub
		Optional<Customer> result = ICustomerRepository.findById(userId);
		try {
			if(result.isPresent()) {
				return result.get();
			}else {
				throw new CustomerNotFoundException("Record not found with id : " + userId);
			}
			}
			catch(Exception e) {
				throw new ModelNotFoundException("Couldnt find the appointment by id"+ userId );
			}
		}
		
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return ICustomerRepository.findAll();
	}


	@Override
	public Optional<Customer> removeCustomer(String userId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer=ICustomerRepository.findById(userId);
		try{if(customer != null) {
			ICustomerRepository.deleteById(userId);
		return customer;
		}
		else {
			throw new CustomerNotFoundException("Record not found with id : " + userId);
		}
		}catch(Exception e) {
			throw new ModelNotFoundException("Couldnt find the appointment by id"+ userId );
		}
	
	}
	@Override
	public Customer updateCustomer(String userId, Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer1 = ICustomerRepository.findById(userId);
		try{if(customer1.isPresent())
		{
			return ICustomerRepository.save(customer);
		}
		else
		{
			throw new CustomerNotFoundException(userIdnotFound);
		}
	}catch(Exception e1){
		throw new CustomerNotFoundException("Record not found with id : " + userId);
		
	}
	}


//	@Override
//	public List<Customer> getCustomersBycity(String city) {
//		// TODO Auto-generated method stub
//		return ICustomerRepository.getCustomersBycity(city);
//	}
		
	}
