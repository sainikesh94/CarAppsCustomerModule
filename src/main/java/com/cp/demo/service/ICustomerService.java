package com.cp.demo.service;

import java.util.List;
import java.util.Optional;

import com.cp.demo.entity.Customer;
import com.cp.demo.exception.CustomerNotFoundException;
import com.cp.demo.exception.ModelAddException;

public interface ICustomerService {
	public Customer addCustomer(Customer customer) throws ModelAddException;
	public Customer getCustomer(String userId);
	public List<Customer> getAllCustomers(); 
	public Optional<Customer> removeCustomer(String userId);
	public Customer updateCustomer(String userId, Customer customer) throws CustomerNotFoundException;
//	public List<Customer> getCustomersBycity(String city);

}
