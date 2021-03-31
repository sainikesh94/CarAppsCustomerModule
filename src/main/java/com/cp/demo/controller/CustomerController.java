package com.cp.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.demo.entity.Customer;
import com.cp.demo.exception.CustomerNotFoundException;
import com.cp.demo.exception.ModelAddException;
import com.cp.demo.service.ICustomerService;

import io.swagger.annotations.Api;


@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/c1")
public class CustomerController {
	@Autowired
	private ICustomerService iService;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to CapG";
	}
	
	@PostMapping("/cus")
	public Customer addCustomer(@RequestBody Customer customer) throws ModelAddException
	{
		return iService.addCustomer(customer);
	}
	
	@GetMapping("/customer/{userId}")
	public Customer getcustomer(@PathVariable String userId)
	{
			return iService.getCustomer(userId);
	}
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomers(){
		return iService.getAllCustomers();
	}
	
	@DeleteMapping("/delete/{userId}")
	public Optional<Customer> removeCustomer(@PathVariable String userId)
	{
		return iService.removeCustomer(userId);
	}
	@PostMapping("/cus/{userId}")
	public Customer updateCustomer(@PathVariable String userId, @RequestBody Customer customer) throws CustomerNotFoundException
	{
		return iService.updateCustomer(userId, customer);
	}
//	@GetMapping("/city")
//	public List<Customer> getCustomersBycity(@PathVariable String city){
//		return iService.getCustomersBycity(city);
//	}
}
