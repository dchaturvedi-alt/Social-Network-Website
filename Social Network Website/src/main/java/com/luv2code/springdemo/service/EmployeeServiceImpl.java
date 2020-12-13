package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.EmployeeDAO;
import com.luv2code.springdemo.entity.About;
import com.luv2code.springdemo.entity.AboutAlmaMatter;
import com.luv2code.springdemo.entity.Comments;
import com.luv2code.springdemo.entity.Employee;
import com.luv2code.springdemo.entity.Friends;
import com.luv2code.springdemo.entity.Likes;
import com.luv2code.springdemo.entity.Post;
import com.luv2code.springdemo.entity.UserPhoneNumbers;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeeDAO.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(String theId) {
		
		return employeeDAO.getEmployee(theId);
	}

	@Override
	@Transactional
	public List<AboutAlmaMatter> getAlmaMatters(String userName) {
		
		return employeeDAO.getAlmaMatters(userName);
	}

	@Override
	@Transactional
	public void saveAlmaMatter(AboutAlmaMatter theAlmaMatter) {
		employeeDAO.saveAlmaMatter(theAlmaMatter);
	}

	@Override
	@Transactional
	public void saveAbout(About about) {
		employeeDAO.saveAbout(about);
	}

	@Override
	@Transactional
	public About getAbout(String userName) {
		return employeeDAO.getAbout(userName);
	}

	@Override
	@Transactional
	public List<UserPhoneNumbers> getPhoneNumbers(String userName) {
		return employeeDAO.getPhoneNumbers(userName);
	}

	@Override
	@Transactional
	public void savePhoneNumber(UserPhoneNumbers thePhoneNumber) {
		employeeDAO.savePhoneNumber(thePhoneNumber);
	}

	@Override
	@Transactional
	public List<Employee> searchUsers(String query) {
		return employeeDAO.searchUsers(query);
	}

	@Override
	@Transactional
	public Friends getFriendshipStatus(String userNameId, String userName) {
		return employeeDAO.getFriendshipStatus(userNameId, userName);
	}

	@Override
	@Transactional
	public List<Friends> getPendingFriendRequests(String userName) {
		return employeeDAO.getPendingFriendRequests(userName);
	}

	@Override
	@Transactional
	public void addFriend(String sourceUserId, String targetUserId) {
		employeeDAO.addFriend(sourceUserId, targetUserId);
	}

	@Override
	@Transactional
	public void removeFriendRequest(String sourceUserId, String targetUserId) {
		employeeDAO.removeFriendRequest(sourceUserId, targetUserId);
	}

	@Override
	@Transactional
	public void acceptFriendRequest(String sourceUserId, String targetUserId) {
		employeeDAO.acceptFriendRequest(sourceUserId, targetUserId);
	}

	@Override
	@Transactional
	public List<Employee> getFriends(String userName) {
		return employeeDAO.getFriends(userName);
	}

	@Override
	@Transactional
	public void savePost(Post post) {
		employeeDAO.savePost(post);
	}

	@Override
	@Transactional
	public List<Post> getAllPosts() {
		return employeeDAO.getAllPosts();
	}

	@Override
	@Transactional
	public List<Post> getFriendPosts(String userName) {
		return employeeDAO.getFriendPosts(userName);
	}

	@Override
	@Transactional
	public void removeFriend(String userName, String targetUserId) {
		employeeDAO.removeFriend(userName, targetUserId);
	}

	@Override
	@Transactional
	public List<Post> getMyPosts(String userName) {
		return employeeDAO.getMyPosts(userName);
	}

	@Override
	@Transactional
	public Post getPost(int postId) {
		return employeeDAO.getPost(postId);
	}

	@Override
	@Transactional
	public void deletePost(int postId) {
		employeeDAO.deletePost(postId);
	}

	@Override
	@Transactional
	public void saveLike(Likes like) {
		employeeDAO.saveLike(like);
	}


	@Override
	@Transactional
	public void unlikeExistingPost(String userName, Post post) {
		employeeDAO.unlikeExistingPost(userName, post);
	}

	@Override
	@Transactional
	public Likes getLike(String userName, int postId) {
		return employeeDAO.getLike(userName, postId);
	}

	@Override
	@Transactional
	public List<Likes> getLikes(int postId) {
		return employeeDAO.getLikes(postId);
	}

	@Override
	@Transactional
	public void postComment(Comments comment) {
		employeeDAO.postComment(comment);
	}

	@Override
	@Transactional
	public List<Comments> getAllComments(int postId) {
		return employeeDAO.getAllComments(postId);
	}

	@Override
	@Transactional
	public Comments getComment(int commentId) {
		return employeeDAO.getComment(commentId);
	}

	@Override
	@Transactional
	public void deleteComment(int commentId) {
		employeeDAO.deleteComment(commentId);
	}

	@Override
	@Transactional
	public List<String> getAllPhones() {
		return employeeDAO.getAllPhones();
	}

	@Override
	@Transactional
	public List<String> getAllEmails() {
		return employeeDAO.getAllEmails();
	}

	
	
}
