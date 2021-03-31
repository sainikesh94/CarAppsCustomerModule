package com.cp.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cp.demo.entity.Customer;
import com.cp.demo.exception.CustomerNotFoundException;
import com.cp.demo.repository.ICustomerRepository;
import com.cp.demo.service.ICustomerImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerModuleTest {

	@InjectMocks
	ICustomerImpl iCustomerImpl;

	@Mock
	ICustomerRepository iCustomerRepository;

	@Test
	public void addAppointmentTest() {
		LocalDate dob_1 = LocalDate.of(2000, 05, 03);
		Customer customer_1 = new Customer("123", "Nikesh", "sainikesh94@gmail.com", "9494420652", dob_1);
		when(iCustomerRepository.save(customer_1)).thenReturn(customer_1);
		Customer customer_values = iCustomerImpl.addCustomer(customer_1);
		assertEquals("123", customer_values.getUserId());
		assertEquals("Nikesh", customer_values.getName());
		assertEquals("sainikesh94@gmail.com", customer_values.getEmail());
	}

	@Test
	public void removeAppointmenTest() {
		verify(iCustomerRepository, never()).delete(any(Customer.class));
	}

	@Test
	public void getCustomerTest() {
		LocalDate dob_1 = LocalDate.of(2000, 05, 03);
		Optional<Customer> customer_1=Optional.of(new Customer("123","Nikesh","sainikesh94@gmail.com","9494420652",dob_1));
		when(iCustomerRepository.findById("123")).thenReturn(customer_1);
		Customer customer_values=iCustomerImpl.getCustomer("123");
		assertEquals("123", customer_values.getUserId());
		assertEquals("Nikesh", customer_values.getName());
		assertEquals("sainikesh94@gmail.com", customer_values.getEmail());
	}
	
	@Test
	public void getAllCustomersTest() {
		List<Customer> customer_list = new ArrayList<Customer>();
		LocalDate dob_1 = LocalDate.of(2000, 05, 03); 
		Customer customer_1=new Customer("123","Nikesh","sainikesh94@gmail.com","9494420652",dob_1);
        LocalDate dob_2 = LocalDate.of(2000, 9, 03); 
        Customer customer_2=new Customer("125","Sai","sai74@gmail.com","7589512689",dob_2);
        customer_list.add(customer_2);
        customer_list.add(customer_1);
		when(iCustomerRepository.findAll()).thenReturn(customer_list);
		List<Customer> check_customer_list = iCustomerImpl.getAllCustomers();
		assertEquals(2, check_customer_list.size());
		//verify(iAppointmentRepository, times(1)).findAll();
	}
	
//	@Test
//	public void updateAppointmentTest() throws CustomerNotFoundException  {
//		LocalDate dob_1 = LocalDate.of(2000, 05, 03);
//		Customer customer_1 = new Customer("123", "Sai", "sainikesh94@gmail.com", "9494420652", dob_1);
//		when(iCustomerRepository.save(customer_1)).thenReturn(customer_1);
//		Customer customer_values = iCustomerImpl.addCustomer(customer_1);
//        customer_1.setName("Nikesh");
//        iCustomerImpl.updateCustomer("123", customer_1);
//        assertEquals("Nikesh",customer_values.getName());
		

//		LocalDate preferredDate = LocalDate.of(2007,12,03);
//		LocalTime preferredTime = LocalTime.of(8, 9);
//		Optional<Appointment> appointment_values = Optional.of(new Appointment(1,"kavoor", "Open", preferredDate ,preferredTime));
//		
//		LocalDate preferredDate_2= LocalDate.of(2007,12,03);
//		LocalTime preferredTime_2 = LocalTime.of(8, 9);
//		Appointment new_appointment_values = new Appointment(3,"mumbai", "Open", preferredDate_2 ,preferredTime_2);
//		
//		when(iAppointmentRepository.findById(3L)).thenReturn(appointment_values);
//		
//		iAppointmentServiceImpl.updateAppointment(new_appointment_values);
//		
//		assertEquals(3,new_appointment_values.getAppointmentId());
//		assertEquals("mumbai",new_appointment_values.getLocation());
//		assertEquals("Open",new_appointment_values.getInspectionType());
//		assertEquals(preferredDate_2,new_appointment_values.getPreferredDate());
//		assertEquals(preferredTime_2,new_appointment_values.getPreferredTime());
	}
	

