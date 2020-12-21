package com.antra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name="laptop")
public class Laptop {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@GenericGenerator(strategy="increment",name="inc")
	@Column(name="laptop_id")
	Integer laptopId;
	
	@Column(name="laptop_name")
	String laptopName;
	
	public Integer getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(Integer laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	
	
}
