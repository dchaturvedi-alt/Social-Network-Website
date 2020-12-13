package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.About;
import com.luv2code.springdemo.entity.AboutAlmaMatter;
import com.luv2code.springdemo.entity.Comments;
import com.luv2code.springdemo.entity.Employee;
import com.luv2code.springdemo.entity.Friends;
import com.luv2code.springdemo.entity.Likes;
import com.luv2code.springdemo.entity.Post;
import com.luv2code.springdemo.entity.UserPhoneNumbers;
import com.luv2code.springdemo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private int flag = 0;
	
	
	@GetMapping("/myProfile")
	public String myProfile(Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		Employee employee = employeeService.getEmployee(userName);
		theModel.addAttribute("employee", employee);
		
		return "my-profile";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		
		Employee theEmployee = employeeService.getEmployee(userName);
		theModel.addAttribute("employee" ,theEmployee);
		
		theModel.addAttribute("dateError", flag);
		flag = 0;
		
		return "update-form";
	}
	
	@GetMapping("/updateInfo")
	public String updateInfo(@ModelAttribute("employee") Employee theEmployee) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		try {
			Date dateobj = new Date();
			dateobj.toInstant();
			if(theEmployee.getDate() == null) {
				flag = 1;
				return "redirect:/employee/showFormForUpdate";
			}
			
			if(theEmployee.getDate().compareTo(dateobj) >= 0) {
				flag = 1;
				return "redirect:/employee/showFormForUpdate";
			}
			if(theEmployee.getEmail() == "") {
				flag = 3;
				return "redirect:/employee/showFormForUpdate";
			}
			if(theEmployee.getEmail().matches("^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$")==false) {
				flag = 3;
				return "redirect:/employee/showFormForUpdate";
			}
			if(theEmployee.getFirstName() == "") {
				flag = 4;
				return "redirect:/employee/showFormForUpdate";
			}
			List<String> allEmails = new ArrayList<String>();
			allEmails = employeeService.getAllEmails();
			Employee someEmployee = employeeService.getEmployee(userName);
			if(allEmails.contains(theEmployee.getEmail()) && !someEmployee.getEmail().equals(theEmployee.getEmail())) {
				flag = 5;
				return "redirect:/employee/showFormForUpdate";
			}
			employeeService.saveEmployee(theEmployee);
			return "redirect:/employee/myProfile";
		}
		catch(Exception e){
			flag = 1;
			return "redirect:/employee/showFormForUpdate";
		}
	}
	
	@GetMapping("/showProfile")
	public String showProfile(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		
		Employee theEmployee = employeeService.getEmployee(userName);
		theModel.addAttribute("employee" ,theEmployee);
		
		List<AboutAlmaMatter> almaMatters = employeeService.getAlmaMatters(userName);
		theModel.addAttribute("almaMatters", almaMatters);
		
		About about = employeeService.getAbout(userName);
		theModel.addAttribute("about", about);
		
		List<UserPhoneNumbers> phoneNumbers = employeeService.getPhoneNumbers(userName);
		theModel.addAttribute("phoneNumbers",phoneNumbers);
		
		String friendFlag = "null";
		theModel.addAttribute("friendflag",friendFlag);
		
		return "show-profile";
	}
	
	@GetMapping("/showFormForAlmaMatter")
	public String showFormForAlmaMatter(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		List<AboutAlmaMatter> almaMatters = employeeService.getAlmaMatters(userName);
		theModel.addAttribute("almaMatters",almaMatters);
		
		return "show-form-for-alma-matter";
	}
	
	@GetMapping("/showFormForAddAlmaMatter")
	public String showFormForAddAlmaMatter(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		
		AboutAlmaMatter almaMatter = new AboutAlmaMatter();
		almaMatter.setUserId(userName);
		theModel.addAttribute("almaMatter" ,almaMatter);
		
		return "add-alma-matter";
	}
	
	@PostMapping("/saveAlmaMatter")
	public String saveAlmaMatter(@ModelAttribute("almaMatter") AboutAlmaMatter theAlmaMatter) {
		employeeService.saveAlmaMatter(theAlmaMatter);
		
		return "redirect:/employee/showFormForAlmaMatter";
	}
	
	@RequestMapping("/showAbout")
	public String showAbout(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		
		About about = employeeService.getAbout(userName);
		theModel.addAttribute("about", about);
		
		return "show-about";
	}
	
	@RequestMapping("/updateAbout")
	public String updateAbout(@ModelAttribute("about") About about) {
		
		employeeService.saveAbout(about);
		
		return "redirect:/employee/myProfile";
	}
	
	@RequestMapping("/addPhone")
	public String addPhone(Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		List<UserPhoneNumbers> phoneNumbers = employeeService.getPhoneNumbers(userName);
		theModel.addAttribute("phoneNumbers", phoneNumbers);
		
		return "add-phone";
	}
	
	@RequestMapping("/showFormForAddPhoneNumber")
	public String showFormForAddPhoneNumber(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		
		UserPhoneNumbers phoneNumber = new UserPhoneNumbers();
		phoneNumber.setUserId(userName);
		theModel.addAttribute("phonenumber" ,phoneNumber);
		theModel.addAttribute("phoneExists", flag);
		flag = 0;
		return "save-phone";
	}
	
	@RequestMapping("/savePhoneNumber")
	public String savePhoneNumber(@ModelAttribute("phoneNumber") UserPhoneNumbers thePhoneNumber) {
		
		List<String> allPhones = new ArrayList<String>();
		allPhones = employeeService.getAllPhones();
		if(allPhones.contains(thePhoneNumber.getPhoneNumber())) {
			flag = 1;
			return "redirect:/employee/showFormForAddPhoneNumber";
		}
		if(thePhoneNumber.getPhoneNumber().matches("[7-9][0-9]{9}") == false) {
			flag = 2;
			return "redirect:/employee/showFormForAddPhoneNumber";
		}
		String str = thePhoneNumber.getPhoneNumber();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)<'0' || str.charAt(i)>'9') {
				flag = 2;
				return "redirect:/employee/showFormForAddPhoneNumber";
			}
		}
		employeeService.savePhoneNumber(thePhoneNumber);
		
		return "redirect:/employee/addPhone";
	}
	
	@RequestMapping("/searchUsers")
	public String searchUsers(@RequestParam("query") String query, Model theModel) {
		
		List<Employee> searchResults = employeeService.searchUsers(query);
		if(searchResults.isEmpty()) {
			return "no-matches";
		}
		List<Employee> allResults = new ArrayList<Employee>();
		
		Set<String> set = new HashSet<String>();
		for(Employee emp : searchResults) {
			if(set.contains(emp.getId())) continue;
			set.add(emp.getId());
			allResults.add(emp);
		}
		theModel.addAttribute("searchResults",allResults);
		return "search-results";
	}
	
	@RequestMapping("/searchUserProfile")
	public String searchUserProfile(@RequestParam("searchUserId") String userName,
									Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userNameId = user.getUsername();
		
		if(userNameId.equals(userName)) {
			
			return "redirect:/employee/showProfile";
		}
		Employee theEmployee = employeeService.getEmployee(userName);
		theModel.addAttribute("employee" ,theEmployee);
		
		List<AboutAlmaMatter> almaMatters = employeeService.getAlmaMatters(userName);
		theModel.addAttribute("almaMatters", almaMatters);
		
		About about = employeeService.getAbout(userName);
		theModel.addAttribute("about", about);
		
		List<UserPhoneNumbers> phoneNumbers = employeeService.getPhoneNumbers(userName);
		theModel.addAttribute("phoneNumbers",phoneNumbers);
		
		String friendFlag = "not_null";
		theModel.addAttribute("friendflag", friendFlag);
		
		Friends requestSent = employeeService.getFriendshipStatus(userNameId, userName);
		theModel.addAttribute("requestSent",requestSent);
		
		Friends requestReceived = employeeService.getFriendshipStatus(userName, userNameId);
		theModel.addAttribute("requestReceived",requestReceived);
		
		return "show-profile";
	}
	
	@RequestMapping("/pendingFriendRequests")
	public String pendingFriendRequests(Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		List<Friends> friends = employeeService.getPendingFriendRequests(userName);
		
		List<Employee> wannabeFriends = new ArrayList<Employee>();
		for(Friends friend : friends) {
			Employee emp = employeeService.getEmployee(friend.getSourceUserId());
			wannabeFriends.add(emp);
		}
		theModel.addAttribute("wannabeFriends",wannabeFriends);
		
		return "pending-requests";
	}
	
	@RequestMapping("/addFriend")
	public String addFriend(@RequestParam("targetUserId") String targetUserId,
							Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		employeeService.addFriend(userName, targetUserId);
		
		userName = targetUserId;
		
		Employee theEmployee = employeeService.getEmployee(userName);
		theModel.addAttribute("employee" ,theEmployee);
		
		List<AboutAlmaMatter> almaMatters = employeeService.getAlmaMatters(userName);
		theModel.addAttribute("almaMatters", almaMatters);
		
		About about = employeeService.getAbout(userName);
		theModel.addAttribute("about", about);
		
		List<UserPhoneNumbers> phoneNumbers = employeeService.getPhoneNumbers(userName);
		theModel.addAttribute("phoneNumbers",phoneNumbers);
		
		String friendFlag = "not_null";
		theModel.addAttribute("friendflag", friendFlag);
		
		Friends requestSent = employeeService.getFriendshipStatus(user.getUsername(), targetUserId);
		theModel.addAttribute("requestSent",requestSent);
		
		Friends requestReceived = employeeService.getFriendshipStatus(targetUserId, user.getUsername());
		theModel.addAttribute("requestReceived",requestReceived);
		
		return "show-profile";
	}
	
	@RequestMapping("/acceptRequest")
	public String acceptRequest(@RequestParam("sourceUserId") String sourceUserId,
								Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String targetUserId = user.getUsername();
		Friends friend = employeeService.getFriendshipStatus(sourceUserId, targetUserId);
		if(friend == null || friend.getFriendshipStatus().equals("accepted")) {
			String userName = sourceUserId;
			
			Employee theEmployee = employeeService.getEmployee(userName);
			theModel.addAttribute("employee" ,theEmployee);
			
			List<AboutAlmaMatter> almaMatters = employeeService.getAlmaMatters(userName);
			theModel.addAttribute("almaMatters", almaMatters);
			
			About about = employeeService.getAbout(userName);
			theModel.addAttribute("about", about);
			
			List<UserPhoneNumbers> phoneNumbers = employeeService.getPhoneNumbers(userName);
			theModel.addAttribute("phoneNumbers",phoneNumbers);
			
			String friendFlag = "not_null";
			theModel.addAttribute("friendflag", friendFlag);
			
			Friends requestSent = employeeService.getFriendshipStatus(user.getUsername(), sourceUserId);
			theModel.addAttribute("requestSent",requestSent);
			
			Friends requestReceived = employeeService.getFriendshipStatus(sourceUserId, user.getUsername());
			theModel.addAttribute("requestReceived",requestReceived);
			
			return "show-profile";
		}
		employeeService.removeFriendRequest(sourceUserId, targetUserId);
		
		employeeService.acceptFriendRequest(sourceUserId, targetUserId);
		
		return "redirect:/employee/showFriends";
	}
	
	@RequestMapping("/rejectRequest")
	public String rejectRequest(@RequestParam("sourceUserId") String sourceUserId,
								Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String targetUserId = user.getUsername();
		Friends friend = employeeService.getFriendshipStatus(sourceUserId, targetUserId);
		logger.info(friend.getFriendshipStatus());
		if(friend == null || friend.getFriendshipStatus().equals("accepted")) {
			String userName = sourceUserId;
			
			Employee theEmployee = employeeService.getEmployee(userName);
			theModel.addAttribute("employee" ,theEmployee);
			
			List<AboutAlmaMatter> almaMatters = employeeService.getAlmaMatters(userName);
			theModel.addAttribute("almaMatters", almaMatters);
			
			About about = employeeService.getAbout(userName);
			theModel.addAttribute("about", about);
			
			List<UserPhoneNumbers> phoneNumbers = employeeService.getPhoneNumbers(userName);
			theModel.addAttribute("phoneNumbers",phoneNumbers);
			
			String friendFlag = "not_null";
			theModel.addAttribute("friendflag", friendFlag);
			
			Friends requestSent = employeeService.getFriendshipStatus(user.getUsername(), sourceUserId);
			theModel.addAttribute("requestSent",requestSent);
			
			Friends requestReceived = employeeService.getFriendshipStatus(sourceUserId, user.getUsername());
			theModel.addAttribute("requestReceived",requestReceived);
			
			return "show-profile";
		}
		employeeService.removeFriendRequest(sourceUserId, targetUserId);
		
		String userName = sourceUserId;
		
		Employee theEmployee = employeeService.getEmployee(userName);
		theModel.addAttribute("employee" ,theEmployee);
		
		List<AboutAlmaMatter> almaMatters = employeeService.getAlmaMatters(userName);
		theModel.addAttribute("almaMatters", almaMatters);
		
		About about = employeeService.getAbout(userName);
		theModel.addAttribute("about", about);
		
		List<UserPhoneNumbers> phoneNumbers = employeeService.getPhoneNumbers(userName);
		theModel.addAttribute("phoneNumbers",phoneNumbers);
		
		String friendFlag = "not_null";
		theModel.addAttribute("friendflag", friendFlag);
		
		Friends requestSent = employeeService.getFriendshipStatus(sourceUserId, targetUserId);
		theModel.addAttribute("requestSent",requestSent);
		
		Friends requestReceived = employeeService.getFriendshipStatus(targetUserId, sourceUserId);
		theModel.addAttribute("requestReceived",requestReceived);
		
		return "show-profile";
	}
	
	@RequestMapping("/removeFriend")
	public String removeFriend(@RequestParam("targetUserId") String targetUserId,
								Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		employeeService.removeFriend(userName, targetUserId);
		
		return "redirect:/employee/showFriends";
	}
	
	@RequestMapping("/showFriends")
	public String showFriends(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		List<Employee> allFriends = employeeService.getFriends(userName);
		theModel.addAttribute("allFriends" ,allFriends);
		
		return "show-friends";
	}
	
	@RequestMapping("/createPost")
	public String createPost(Model theModel) {
		
		Post newPost = new Post();
		
		theModel.addAttribute("newPost",newPost);
		return "new-post";
	}
	
	@RequestMapping("/sharePost")
	public String sharePost(@ModelAttribute("newPost") Post post,
							Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		
		post.setUserId(userName);
		Date dateobj = new Date();
		dateobj.toInstant();
		post.setPostDate(dateobj);
		employeeService.savePost(post);
		
		List<Post> allPosts = employeeService.getAllPosts();
		theModel.addAttribute("allPosts",allPosts);
		String whosePostsToDisplay = "all";
		theModel.addAttribute("whosePostsToDisplay",whosePostsToDisplay);
		
		return "view-all-posts";
	}
	
	@RequestMapping("/viewAllPosts")
	public String viewAllPosts(Model theModel) {
		List<Post> allPosts = employeeService.getAllPosts();
		theModel.addAttribute("allPosts",allPosts);
		String whosePostsToDisplay = "all";
		theModel.addAttribute("whosePostsToDisplay",whosePostsToDisplay);
		return "view-all-posts";
	}
	
	@RequestMapping("/viewFriendsPost")
	public String viewFriendsPost(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		List<Post> allPosts = employeeService.getFriendPosts(userName);
		theModel.addAttribute("allPosts",allPosts);
		String whosePostsToDisplay = "friends";
		theModel.addAttribute("whosePostsToDisplay",whosePostsToDisplay);
		
		return "view-all-posts";
	}
	
	@RequestMapping("/viewMyPosts")
	public String viewMyPosts(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		List<Post> myPosts = employeeService.getMyPosts(userName);
		theModel.addAttribute("allPosts",myPosts);
		String whosePostsToDisplay = "myposts";
		theModel.addAttribute("whosePostsToDisplay",whosePostsToDisplay);
		
		return "view-all-posts";
	}
	
	@RequestMapping("/viewIndPost")
	public String viewIndPost(@RequestParam("postid") int postId ,Model theModel) {
		
		Post post = employeeService.getPost(postId);
		theModel.addAttribute("indPost",post);
		
		Employee theEmployee = employeeService.getEmployee(post.getUserId());
		theModel.addAttribute("employee",theEmployee);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		theModel.addAttribute("currentUser",userName);
		
		String ifLiked = null;
		Likes like = employeeService.getLike(userName, postId);
		if(like == null) ifLiked = "notLiked";
		else {
			ifLiked = "liked";
			String likeReaction = like.getReaction();
			theModel.addAttribute("likeReaction",likeReaction);
		}
		theModel.addAttribute("ifLiked",ifLiked);
		return "ind-post";
	}
	
	@RequestMapping("/deletePost")
	public String deletePost(@RequestParam("postid") int postId, Model theModel) {
		employeeService.deletePost(postId);
		
		return "redirect:/employee/viewMyPosts";
	}
	
	@RequestMapping("/editPost")
	public String editPost(@RequestParam("postid") int postId, Model theModel) {
		
		Post post = employeeService.getPost(postId);
		theModel.addAttribute("editIndPost",post);
		
		return "edit-post";
	}
	
	@RequestMapping("/updatePost")
	public String updatePost(@ModelAttribute("editIndPost") Post post,
			Model theModel) {
		
		employeeService.savePost(post);
		
		return "redirect:/employee/viewMyPosts";
	}
	
	@RequestMapping("/shareExistingPost")
	public String shareExistingPost(@ModelAttribute("indPost") Post oldPost, Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		Post post = new Post();
		post.setUserId(userName);
		Date dateobj = new Date();
		dateobj.toInstant();
		post.setPostDate(dateobj);
		post.setPostContent(oldPost.getPostContent());
		System.out.println(oldPost);
		
		employeeService.savePost(post);
		
		return "redirect:/employee/viewMyPosts";
	}
	
	@RequestMapping("/likeExistingPost")
	public String likeExistingPost(@ModelAttribute("indPost") Post post, Model theModel) {
		theModel.addAttribute("indPost", post);
		return "like-reaction";
	}
	
	@RequestMapping("/likeReaction")
	public String likeReaction(@RequestParam("reaction") String reaction,
							   @RequestParam("postId") int postId, Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		Likes like = new Likes();
		like.setPostId(postId);
		like.setReaction(reaction);
		like.setUserId(userName);
		employeeService.saveLike(like);
		
		return "redirect:/employee/viewAllPosts";
	}
	
	@RequestMapping("/unlikeExistingPost")
	public String unlikeExistingPost(@ModelAttribute("indPost") Post post, Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		employeeService.unlikeExistingPost(userName, post);
		
		return "redirect:/employee/viewAllPosts";
	}
	
	@RequestMapping("/viewLikes")
	public String viewLikes(@ModelAttribute("indPost") Post post, Model theModel) {
		
		List<Likes> likes = employeeService.getLikes(post.getPostId());
		int count = likes.size();
		theModel.addAttribute("count", count);
		List<Employee> employeeLiked = new ArrayList<Employee>();
		List<Employee> employeeLaughed = new ArrayList<Employee>();
		List<Employee> employeeCried = new ArrayList<Employee>();
		List<Employee> employeeAngry = new ArrayList<Employee>();
		Employee tempEmployee;
		
		for(Likes like : likes) {
			if(like.getReaction().equals("Liked")) {
				tempEmployee = employeeService.getEmployee(like.getUserId());
				employeeLiked.add(tempEmployee);
			}
		}
		for(Likes like : likes) {
			if(like.getReaction().equals("Laughed")) {
				tempEmployee = employeeService.getEmployee(like.getUserId());
				employeeLaughed.add(tempEmployee);
			}
		}
		for(Likes like : likes) {
			if(like.getReaction().equals("Cried")) {
				tempEmployee = employeeService.getEmployee(like.getUserId());
				employeeCried.add(tempEmployee);
			}
		}
		for(Likes like : likes) {
			if(like.getReaction().equals("Got Angry")) {
				tempEmployee = employeeService.getEmployee(like.getUserId());
				employeeAngry.add(tempEmployee);
			}
		}
		theModel.addAttribute("employeeLaugh", employeeLaughed);
		theModel.addAttribute("employeeLike", employeeLiked);
		theModel.addAttribute("employeeCried", employeeCried);
		theModel.addAttribute("employeeAngry", employeeAngry);
		
		
		return "view-likes";
	}
	
	@RequestMapping("/addComment")
	public String addComment(@ModelAttribute("indPost") Post post, Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		
		String userName = user.getUsername();
		Comments newComment = new Comments();
		newComment.setPostAuthorId(post.getUserId());
		newComment.setPostId(post.getPostId());
		newComment.setUserId(userName);
		Date dateobj = new Date();
		dateobj.toInstant();
		newComment.setCommentDate(dateobj);
		theModel.addAttribute("newComment", newComment);
		return "add-comment";
	}
	
	@RequestMapping("/postComment")
	public String postComment(@ModelAttribute("newComment") Comments comment, Model theModel) {
		
		employeeService.postComment(comment);
		return "redirect:/employee/viewAllPosts";
	}
	
	@RequestMapping("/viewComments")
	public String viewComments(@ModelAttribute("indPost") Post post, Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		List<Comments> comments = employeeService.getAllComments(post.getPostId());
		theModel.addAttribute("comments", comments);
		int count = comments.size();
		theModel.addAttribute("count", count);
		
		List<Employee> employees = new ArrayList<Employee>();
		Set<String> set = new HashSet<String>();
		for(Comments comment : comments) {
			if(set.contains(comment.getUserId())) continue;
			set.add(comment.getUserId());
			Employee temp = employeeService.getEmployee(comment.getUserId());
			employees.add(temp);
		}
		theModel.addAttribute("employees",employees);
		String userName = user.getUsername();
		theModel.addAttribute("currentUser",userName);
		return "view-comments";
	}
	
	@RequestMapping("/editComment")
	public String editComment(@RequestParam("commentId") int commentId, Model theModel) {
		Comments comment = employeeService.getComment(commentId);
		theModel.addAttribute("editComment", comment);
		return "edit-comment";
	}
	
	@RequestMapping("/updateComment")
	public String updateComment(@ModelAttribute("editComment") Comments comment, Model theModel) {
		
		employeeService.postComment(comment);
		return "redirect:/employee/viewAllPosts";
	}
	
	@RequestMapping("/deleteComment")
	public String deleteComment(@RequestParam("commentId") int commentId, Model theModel) {
		employeeService.deleteComment(commentId);
		return "redirect:/employee/viewAllPosts";
	}
}
