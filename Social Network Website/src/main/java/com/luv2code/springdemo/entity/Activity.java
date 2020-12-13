package com.luv2code.springdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="activity_id")
	private int activityId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="activity_date")
	private Date activityDate;
	
	@Column(name="activity_type")
	private String activityType;
	
	@Column(name="activity_content")
	private String activityContent;
	
	public Activity() {
		
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", userId=" + userId + ", activityDate=" + activityDate
				+ ", activityType=" + activityType + ", activityContent=" + activityContent + "]";
	}
	
}
