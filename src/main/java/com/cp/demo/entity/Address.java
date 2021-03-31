package com.cp.demo.entity;



import javax.persistence.*;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="address")
public class Address {
	
	
	@Id
	@GeneratedValue
    private String doorNo;
	
	@Column(name = "street")
	private String street;
	@Column(name = "area")
	private String area;  
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private int pincode;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String area, String city, String state, int pincode) {
		super();
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}


