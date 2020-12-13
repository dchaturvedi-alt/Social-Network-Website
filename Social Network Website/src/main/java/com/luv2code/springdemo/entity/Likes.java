package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="likes")
public class Likes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="like_id")
	private int likeId;
	
	@Column(name="post_id")
	private int postId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="reaction")
	private String reaction;
	
	public Likes() {
		
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReaction() {
		return reaction;
	}

	public void setReaction(String reaction) {
		this.reaction = reaction;
	}

	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", postId=" + postId + ", userId=" + userId + ", reaction=" + reaction + "]";
	}
	
}
