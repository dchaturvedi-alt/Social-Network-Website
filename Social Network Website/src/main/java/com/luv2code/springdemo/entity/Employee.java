package com.luv2code.springdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name="date_of_birth")
	private Date date;
	
	@Column(name="address_house_no")
	private String addressHouseNo;
	
	@Column(name="address_city")
	private String addressCity;
	
	@Column(name="address_pincode")
	private String addressPincode;
	
	public Employee() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		Date dateobj = new Date();
		dateobj.toInstant();
		try{
			this.date = date;
		}
		catch(Exception e) {
			this.date = dateobj;
		}
	}

	public String getAddressHouseNo() {
		return addressHouseNo;
	}

	public void setAddressHouseNo(String addressHouseNo) {
		this.addressHouseNo = addressHouseNo;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressPincode() {
		return addressPincode;
	}

	public void setAddressPincode(String addressPincode) {
		this.addressPincode = addressPincode;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", gender=" + gender + ", date=" + date + ", addressHouseNo="
				+ addressHouseNo + ", addressCity=" + addressCity + ", addressPincode=" + addressPincode + "]";
	}

}
