package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.About;
import com.luv2code.springdemo.entity.AboutAlmaMatter;
import com.luv2code.springdemo.entity.Comments;
import com.luv2code.springdemo.entity.Employee;
import com.luv2code.springdemo.entity.Friends;
import com.luv2code.springdemo.entity.Likes;
import com.luv2code.springdemo.entity.Post;
import com.luv2code.springdemo.entity.UserPhoneNumbers;

public interface EmployeeDAO {
	
	public void saveEmployee(Employee theEmployee);
	public Employee getEmployee(String theId);
	public List<AboutAlmaMatter> getAlmaMatters(String userName);
	public void saveAlmaMatter(AboutAlmaMatter theAlmaMatter);
	public void saveAbout(About about);
	public About getAbout(String userName);
	public List<UserPhoneNumbers> getPhoneNumbers(String userName);
	public void savePhoneNumber(UserPhoneNumbers thePhoneNumber);
	public List<Employee> searchUsers(String query);
	public Friends getFriendshipStatus(String userNameId, String userName);
	public List<Friends> getPendingFriendRequests(String userName);
	public void addFriend(String sourceUserId, String targetUserId);
	public void removeFriendRequest(String sourceUserId, String targetUserId);
	public void acceptFriendRequest(String sourceUserId, String targetUserId);
	public List<Employee> getFriends(String userName);
	public void savePost(Post post);
	public List<Post> getAllPosts();
	public List<Post> getFriendPosts(String userName);
	public void removeFriend(String userName, String targetUserId);
	public List<Post> getMyPosts(String userName);
	public Post getPost(int postId);
	public void deletePost(int postId);
	public void saveLike(Likes like);
	public void unlikeExistingPost(String userName, Post post);
	public Likes getLike(String userName, int postId);
	public List<Likes> getLikes(int postId);
	public void postComment(Comments comment);
	public List<Comments> getAllComments(int postId);
	public Comments getComment(int commentId);
	public void deleteComment(int commentId);
	public List<String> getAllPhones();
	public List<String> getAllEmails();
}
