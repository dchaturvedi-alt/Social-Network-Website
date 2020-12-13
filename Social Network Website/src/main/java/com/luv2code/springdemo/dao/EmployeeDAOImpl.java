package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.About;
import com.luv2code.springdemo.entity.AboutAlmaMatter;
import com.luv2code.springdemo.entity.Comments;
import com.luv2code.springdemo.entity.Employee;
import com.luv2code.springdemo.entity.Friends;
import com.luv2code.springdemo.entity.Likes;
import com.luv2code.springdemo.entity.Post;
import com.luv2code.springdemo.entity.UserPhoneNumbers;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public void saveEmployee(Employee theEmployee) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theEmployee);
	}
	
	@Override
	public Employee getEmployee(String theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Employee theEmployee = new Employee();
		theEmployee = currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public List<AboutAlmaMatter> getAlmaMatters(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<AboutAlmaMatter> theQuery = 
				currentSession.createQuery("from AboutAlmaMatter where userId=:userid",
						AboutAlmaMatter.class);
		theQuery.setParameter("userid", userName);
		List<AboutAlmaMatter> almaMatters = theQuery.getResultList();
		
		return almaMatters;
	}

	@Override
	public void saveAlmaMatter(AboutAlmaMatter theAlmaMatter) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theAlmaMatter);
	}

	@Override
	public void saveAbout(About about) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(about);
		
	}

	@Override
	public About getAbout(String userName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		About about = new About();
		Query<About> theQuery = 
				currentSession.createQuery("from About where userId=:userid",
						About.class);
		theQuery.setParameter("userid", userName);
		about = theQuery.getSingleResult();
		return about;
	}

	@Override
	public List<UserPhoneNumbers> getPhoneNumbers(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserPhoneNumbers> theQuery = 
				currentSession.createQuery("from UserPhoneNumbers where userId=:userid",
						UserPhoneNumbers.class);
		theQuery.setParameter("userid", userName);
		List<UserPhoneNumbers> phoneNumbers = theQuery.getResultList();
		
		return phoneNumbers;
	}

	@Override
	public void savePhoneNumber(UserPhoneNumbers thePhoneNumber) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(thePhoneNumber);
		
	}

	@Override
	public List<Employee> searchUsers(String query) {
		
		String[] parts = query.split(" "); 
		List<Employee> result = new ArrayList<Employee>();
		List<Employee> temp = new ArrayList<Employee>();
		Session currentSession = sessionFactory.getCurrentSession();
		
		if(parts.length == 1) {
			Query<Employee> theQuery = 
					currentSession.createQuery("from Employee where id=:userquery or "
							+ "firstName=:userquery or middleName=:userquery or lastName=:userquery",
							Employee.class);
			theQuery.setParameter("userquery", parts[0]);
			result = theQuery.getResultList();
			return result;
		}
		else if(parts.length == 2) {
			Query<Employee> theQuery = 
					currentSession.createQuery("from Employee where firstName=:part0 and lastName=:part1",
							Employee.class);
			theQuery.setParameter("part0", parts[0]);
			theQuery.setParameter("part1", parts[1]);
			temp = theQuery.getResultList();
			result.addAll(temp);
			
			theQuery = 
					currentSession.createQuery("from Employee where firstName=:part0 and middleName=:part1",
							Employee.class);
			theQuery.setParameter("part0", parts[0]);
			theQuery.setParameter("part1", parts[1]);
			temp = theQuery.getResultList();
			result.addAll(temp);
			
			theQuery = 
					currentSession.createQuery("from Employee where middleName=:part0 and lastName=:part1",
							Employee.class);
			theQuery.setParameter("part0", parts[0]);
			theQuery.setParameter("part1", parts[1]);
			temp = theQuery.getResultList();
			result.addAll(temp);
			
			theQuery = 
					currentSession.createQuery("from Employee where id=:part or "
							+ "firstName=:part or middleName=:part or lastName=:part",
							Employee.class);
			theQuery.setParameter("part", parts[0]);
			temp = theQuery.getResultList();
			result.addAll(temp);
			
			theQuery.setParameter("part", parts[1]);
			temp = theQuery.getResultList();
			result.addAll(temp);
		}
		else {
			Query<Employee> theQuery = 
					currentSession.createQuery("from Employee where firstName=:part0 and middleName=:part1 and lastName=:part2",
							Employee.class);
			theQuery.setParameter("part0", parts[0]);
			theQuery.setParameter("part1", parts[1]);
			theQuery.setParameter("part2", parts[2]);
			temp = theQuery.getResultList();
			result.addAll(temp);
			
			theQuery = 
					currentSession.createQuery("from Employee where firstName=:part0 and lastName=:part1",
							Employee.class);
			theQuery.setParameter("part0", parts[0]);
			theQuery.setParameter("part1", parts[1]);
			temp = theQuery.getResultList();
			result.addAll(temp);
			
			theQuery = 
					currentSession.createQuery("from Employee where firstName=:part0 and middleName=:part1",
							Employee.class);
			theQuery.setParameter("part0", parts[0]);
			theQuery.setParameter("part1", parts[1]);
			temp = theQuery.getResultList();
			result.addAll(temp);
			
			theQuery = 
					currentSession.createQuery("from Employee where middleName=:part0 and lastName=:part1",
							Employee.class);
			theQuery.setParameter("part0", parts[0]);
			theQuery.setParameter("part1", parts[1]);
			temp = theQuery.getResultList();
			result.addAll(temp);
			
			for(int i=0; i<parts.length; i++) {
				theQuery = 
						currentSession.createQuery("from Employee where id=:part or "
								+ "firstName=:part or middleName=:part or lastName=:part",
								Employee.class);
				theQuery.setParameter("part", parts[i]);
				temp = theQuery.getResultList();
				result.addAll(temp);
			}
			return result;
		}
		
		return result;
	}

	@Override
	public Friends getFriendshipStatus(String userNameId, String userName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Friends friend = new Friends();
		Query<Friends> theQuery = 
				currentSession.createQuery("from Friends where sourceUserId=:userNameId and "
						+ "targetUserId=:userName",
						Friends.class);
		theQuery.setParameter("userNameId", userNameId);
		theQuery.setParameter("userName", userName);
		friend = theQuery.uniqueResult();
		
		return friend;
	}

	@Override
	public List<Friends> getPendingFriendRequests(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Friends> theQuery = 
				currentSession.createQuery("from Friends where targetUserId=:userid and "
						+ "friendshipStatus=:status",
						Friends.class);
		theQuery.setParameter("userid", userName);
		theQuery.setParameter("status", "pending");
		List<Friends> friends = theQuery.getResultList();
		
		return friends;
	}

	@Override
	public void addFriend(String sourceUserId, String targetUserId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Friends friend = new Friends();
		friend.setSourceUserId(sourceUserId);
		friend.setTargetUserId(targetUserId);
		friend.setFriendshipStatus("pending");
		currentSession.saveOrUpdate(friend);
	}

	@Override
	public void removeFriendRequest(String sourceUserId, String targetUserId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Friends where sourceUserId=:sourceUserId " +
						"and targetUserId=:targetUserId");
		theQuery.setParameter("sourceUserId", sourceUserId);
		theQuery.setParameter("targetUserId", targetUserId);
		theQuery.executeUpdate();
		
		theQuery.setParameter("sourceUserId", targetUserId);
		theQuery.setParameter("targetUserId", sourceUserId);
		theQuery.executeUpdate();
	}

	@Override
	public void acceptFriendRequest(String sourceUserId, String targetUserId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Friends friend1 = new Friends();
		friend1.setSourceUserId(sourceUserId);
		friend1.setTargetUserId(targetUserId);
		friend1.setFriendshipStatus("accepted");
		currentSession.saveOrUpdate(friend1);
		
		Friends friend2 = new Friends();
		friend2.setSourceUserId(targetUserId);
		friend2.setTargetUserId(sourceUserId);
		friend2.setFriendshipStatus("accepted");
		currentSession.saveOrUpdate(friend2);
	}

	@Override
	public List<Employee> getFriends(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Friends> theQuery = 
				currentSession.createQuery("from Friends where sourceUserId=:username and "
						+ "friendshipStatus=:status", Friends.class);
		theQuery.setParameter("username", userName);
		theQuery.setParameter("status", "accepted");
		
		List<Friends> friends = theQuery.getResultList();
		List<Employee> allFriends = new ArrayList<Employee>();
		for(Friends friend : friends) {
			Query<Employee> aQuery = 
					currentSession.createQuery("from Employee where id=:friendId", Employee.class);
			aQuery.setParameter("friendId", friend.getTargetUserId());
			List<Employee> temp = aQuery.getResultList();
			allFriends.addAll(temp);
		}
		return allFriends;
	}

	@Override
	public void savePost(Post post) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(post);
		
	}

	@Override
	public List<Post> getAllPosts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Post> theQuery = currentSession.createQuery("from Post order by postId DESC", Post.class);
		List<Post> allPosts = theQuery.getResultList();
		
		return allPosts;
	}

	@Override
	public List<Post> getFriendPosts(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Post> theQuery = currentSession.createQuery("select new Post(post.postId, post.userId, post.postDate, post.postContent) "
				+ "from Post as post, Friends as friends "
				+ "where post.userId=friends.sourceUserId and friends.targetUserId=:username "
				+ "and friends.friendshipStatus=:status ORDER BY post.postId DESC", Post.class);
		theQuery.setParameter("username", userName);
		theQuery.setParameter("status", "accepted");
		
		List<Post> posts = theQuery.getResultList();
		
		return posts;
	}

	@Override
	public void removeFriend(String userName, String targetUserId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Friends where sourceUserId=:sourceUserId " +
						"and targetUserId=:targetUserId");
		theQuery.setParameter("sourceUserId", userName);
		theQuery.setParameter("targetUserId", targetUserId);
		theQuery.executeUpdate();
		
		theQuery.setParameter("sourceUserId", targetUserId);
		theQuery.setParameter("targetUserId", userName);
		theQuery.executeUpdate();
	}

	@Override
	public List<Post> getMyPosts(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Post> theQuery = currentSession.createQuery("from Post where userId=:username", Post.class);
		theQuery.setParameter("username", userName);
		
		List<Post> posts = theQuery.getResultList();
		
		return posts;
	}

	@Override
	public Post getPost(int postId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Post post = new Post();
		post = currentSession.get(Post.class, postId);
		return post;
	}

	@Override
	public void deletePost(int postId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Post where postId=:postid ");
		theQuery.setParameter("postid", postId);
		theQuery.executeUpdate();
	}

	@Override
	public void saveLike(Likes like) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(like);
	}


	@Override
	public void unlikeExistingPost(String userName, Post post) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Likes where "
						+ "postId=:postid and userId=:username");
		theQuery.setParameter("postid", post.getPostId());
		theQuery.setParameter("username", userName);
		theQuery.executeUpdate();
	}

	@Override
	public Likes getLike(String userName, int postId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Likes> theQuery = 
				currentSession.createQuery("from Likes where "
						+ "postId=:postid and userId=:username", Likes.class);
		theQuery.setParameter("postid", postId);
		theQuery.setParameter("username", userName);
		Likes like = theQuery.uniqueResult();
		return like;
	}

	@Override
	public List<Likes> getLikes(int postId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Likes> theQuery = 
				currentSession.createQuery("from Likes where "
						+ "postId=:postid", Likes.class);
		theQuery.setParameter("postid", postId);
		List<Likes> likes = theQuery.getResultList();
		return likes;
	}

	@Override
	public void postComment(Comments comment) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(comment);
	}

	@Override
	public List<Comments> getAllComments(int postId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Comments> theQuery = 
				currentSession.createQuery("from Comments where "
						+ "postId=:postid order by commentId DESC", Comments.class);
		theQuery.setParameter("postid", postId);
		List<Comments> comments = theQuery.getResultList();
		return comments;
	}

	@Override
	public Comments getComment(int commentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Comments comment = new Comments();
		comment = currentSession.get(Comments.class, commentId);
		return comment;
	}

	@Override
	public void deleteComment(int commentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Comments where commentId=:commentid ");
		theQuery.setParameter("commentid", commentId);
		theQuery.executeUpdate();
	}

	@Override
	public List<String> getAllPhones() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserPhoneNumbers> theQuery = 
				currentSession.createQuery("from UserPhoneNumbers",
						UserPhoneNumbers.class);
		
		List<UserPhoneNumbers> results = theQuery.getResultList();
		List<String> allPhoneNumbers = new ArrayList<String>(); 
		for(UserPhoneNumbers phoneNumber : results) {
			allPhoneNumbers.add(phoneNumber.getPhoneNumber());
		}
		
		return allPhoneNumbers;
	}

	@Override
	public List<String> getAllEmails() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee",
						Employee.class);
		
		List<Employee> results = theQuery.getResultList();
		List<String> allEmails = new ArrayList<String>(); 
		for(Employee employee : results) {
			allEmails.add(employee.getEmail());
		}
		
		return allEmails;
	}

}
