package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment_likes")
public class CommentLikes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_like_id")
	private int commentLikeId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="comment_id")
	private int commentId;
	
	@Column(name="comment_author_id")
	private String commentAuthorId;
	
	@Column(name="reaction")
	private String reaction;
	
	public CommentLikes() {
		
	}

	public int getCommentLikeId() {
		return commentLikeId;
	}

	public void setCommentLikeId(int commentLikeId) {
		this.commentLikeId = commentLikeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentAuthorId() {
		return commentAuthorId;
	}

	public void setCommentAuthorId(String commentAuthorId) {
		this.commentAuthorId = commentAuthorId;
	}

	public String getReaction() {
		return reaction;
	}

	public void setReaction(String reaction) {
		this.reaction = reaction;
	}

	@Override
	public String toString() {
		return "CommentLikes [commentLikeId=" + commentLikeId + ", userId=" + userId + ", commentId=" + commentId
				+ ", commentAuthorId=" + commentAuthorId + ", reaction=" + reaction + "]";
	}
	
}
