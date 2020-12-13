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
@Table(name="comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="post_id")
	private int postId;
	
	@Column(name="post_author_id")
	private String postAuthorId;
	
	@Column(name="comment_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date commentDate;
	
	@Column(name="coomment_content")
	private String commentContent;
	
	public Comments() {
		
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostAuthorId() {
		return postAuthorId;
	}

	public void setPostAuthorId(String postAuthorId) {
		this.postAuthorId = postAuthorId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", userId=" + userId + ", postId=" + postId + ", postAuthorId="
				+ postAuthorId + ", commentDate=" + commentDate + ", commentContent=" + commentContent + "]";
	}
	
}
