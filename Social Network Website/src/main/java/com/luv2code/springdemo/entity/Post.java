package com.luv2code.springdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private int postId;
	
	@Column(name="user_id")
	private String userId;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name="post_date")
	private Date postDate;
	
	@Column(name="post_content")
	private String postContent;
	
	public Post() {
		
	}
	
	public Post(int postId, String userId, Date postDate, String postContent) {
		this.postId = postId;
		this.userId = userId;
		this.postDate = postDate;
		this.postContent = postContent;
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", postDate=" + postDate + ", postContent="
				+ postContent + "]";
	}
	
}
