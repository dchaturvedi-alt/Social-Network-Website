package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="about_alma_matter")
public class AboutAlmaMatter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="a_id")
	private int aId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="alma_matter_name")
	private String almaMatterName;
	
	public AboutAlmaMatter() {
		
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAlmaMatterName() {
		return almaMatterName;
	}

	public void setAlmaMatterName(String almaMatterName) {
		this.almaMatterName = almaMatterName;
	}

	@Override
	public String toString() {
		return "AboutAlmaMatter [aId=" + aId + ", userId=" + userId + ", almaMatterName=" + almaMatterName + "]";
	}
	
}
