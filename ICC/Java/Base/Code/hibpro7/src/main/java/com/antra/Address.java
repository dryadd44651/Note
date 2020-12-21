package com.antra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GenericGenerator(strategy="increment", name="inc")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="address_id")
	Integer addressId;
	
	@Column(name="address_street")
	String street;
	
	@Column(name="address_city")
	String city;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	

}
