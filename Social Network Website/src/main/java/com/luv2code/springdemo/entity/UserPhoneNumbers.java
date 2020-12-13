package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_phone_numbers")
public class UserPhoneNumbers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="phone_id")
	private int phoneId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	public UserPhoneNumbers() {
		
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserPhoneNumbers [phoneId=" + phoneId + ", userId=" + userId + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
