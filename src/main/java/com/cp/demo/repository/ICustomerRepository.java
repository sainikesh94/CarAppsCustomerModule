package com.cp.demo.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cp.demo.entity.Customer;



@Repository
public interface ICustomerRepository  extends JpaRepository<Customer,String>{

	Optional<Customer> findById(String userId);
//	public List<Customer> getCustomersBycity(String city);

	

	


}
