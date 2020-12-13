package com.luv2code.springdemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="about")
public class About {
	
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="past_experience")
	private String aboutYou;
	
	@Column(name="relationship_status")
	private String relationshipStatus;
	
	public About() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAboutYou() {
		return aboutYou;
	}

	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	@Override
	public String toString() {
		return "About [userId=" + userId + ", designation=" + designation + ", pastExperience=" + aboutYou
				+ ", relationshipStatus=" + relationshipStatus + "]";
	}

}
