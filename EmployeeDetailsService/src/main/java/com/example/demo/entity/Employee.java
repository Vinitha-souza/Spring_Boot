package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="companyname")
	private String companyName;
	@Column(name="firstname")
	private String firstName;
	@Column(name="secondname")
	private String secondName;
	@Column(name="dob")
	private Date dob;
	
	//@OneToMany(mappedBy="employee" ,cascade={CascadeType.ALL})
	//private List<Address> address;

//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="address_id")  
//	//@JoinColumn(name="address_id",nullable=false) returns null if incase address is null
	
	//For joining one employee with many addresses
	@OneToMany(targetEntity = Address.class,cascade={CascadeType.ALL})
	@JoinColumn(name="employeeid" ,referencedColumnName = "id")  
	private List<Address> address;
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	

	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", companyName=" + companyName + ", firstName=" + firstName + ", secondName="
				+ secondName + ", dob=" + dob + ", address=" + address + "]";
	}
	
	
}
