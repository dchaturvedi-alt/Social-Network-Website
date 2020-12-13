package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friends")
public class Friends {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="friendship_id")
	private int friendshipId;
	
	@Column(name="source_user_id")
	private String sourceUserId;
	
	@Column(name="target_user_id")
	private String targetUserId;

	@Column(name="friendship_status")
	private String friendshipStatus = null;
	
	public Friends() {
		
	}

	public int getFriendshipId() {
		return friendshipId;
	}

	public void setFriendshipId(int friendshipId) {
		this.friendshipId = friendshipId;
	}

	public String getSourceUserId() {
		return sourceUserId;
	}

	public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public String getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
	}

	public String getFriendshipStatus() {
		return friendshipStatus;
	}

	public void setFriendshipStatus(String friendshipStatus) {
		this.friendshipStatus = friendshipStatus;
	}

	@Override
	public String toString() {
		return "Friends [friendshipId=" + friendshipId + ", sourceUserId=" + sourceUserId + ", targetUserId="
				+ targetUserId + ", friendshipStatus=" + friendshipStatus + "]";
	}
	
}
