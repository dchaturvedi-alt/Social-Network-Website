<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>My Profile</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
	.left {
		float: left;
		width: 30%;
	}
	.right {
		float: right;
		width: 10%;
	}
	.upar:after {
	  content: "";
	  display: table;
	  clear: both;
	}
	.button {
	  background-color: #4CAF50; /* Green */
	  border: none;
	  color: white;
	  padding: 15px 32px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	}
	.button5 {
		background-color: #2C9CC8;
		padding: 10px 24px;
		border-radius: 12px;
	}
	.button5:hover {
	  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
	}
	.navbar a{
		font-size: 2.2em;
	}
</style>
</head>

<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			
			<div class="col-xs-2">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/employee/myProfile">Home</a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
			</div>
			<div class="col-xs-2">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/employee/showProfile">My Profile</a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
			</div>
			<div class="col-xs-2">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/employee/showFriends">My Friends</a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
			</div>
			<div class="col-xs-3">
			  <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/employee/searchUsers">
				  
				  <input class="form-control ml-5 mr-2" type="search" id="query" name="query" placeholder="Search users" size="33">
				  <button class="btn btn-outline-success my-2 my-sm-0 btn-lg mr-5" type="submit">Search</button>
				</form>
			</div>
			<div class="col-xs-2">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/employee/viewAllPosts">View Posts</a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
			</div>
			<div class="col-xs-1">
			<form:form class="form-inline my-2" action="${pageContext.request.contextPath}/logout"
				method="POST">
				<button class=" form-group btn btn-outline-success my-2 my-sm-0 btn-lg mx-5" type="submit">Logout</button>
				
			</form:form>
			</div>
		</div>
		  
		</nav>


	<div class="jumbotron">
	 	<h1 class="display-4">Welcome,
			<c:out value="${employee.getFirstName()} ${employee.getLastName()}" />
		</h1>
		
		<hr class="my-4">

		
	  <p>What are you feeling now ?</p>
	  <p>Want to share something with the world? Shoot the below button !</p>
	  <p class="lead">
	    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/employee/createPost" role="button">New Post</a>
	  </p>
	  <hr class="my-4">
	  <p>These people want to be your friends, which means they will be able to follow your activities.</p>
	  <p>It is highly advised to accept friend requests of only those people you know as internet can also prove to be a very unfriendly place.</p>
	  <p class="lead">
	    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/employee/pendingFriendRequests" role="button">Friend Requests</a>
	  </p>
	  <hr class="my-4">
	  <p>Keep your profile updated so that other people can get to know you better.</p>
	  <p class="lead">
	    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/employee/showFormForUpdate" role="button">Update Profile</a>
	  </p>
	  <hr class="my-4">
	  <p>Where you studied is a very important aspect of your life as it is a matter of pride. Make sure you add all your schools, who knows when you might get a friend request from one of your school best friends !</p>
	  <p class="lead">
	    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/employee/showFormForAlmaMatter" role="button">Update Alma Matter</a>
	  </p>
	  <hr class="my-4">
	  <p>These are some personal details about you, which you may leave empty, but we suggest you fill them so that we can connect you with people of similar interests.</p>
	  <p class="lead">
	    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/employee/showAbout" role="button">About You</a>
	  </p>
	  <hr class="my-4">
	  <p>How can one contact you?</p>
	  <p>Fill your active phone numbers in the following form. Make sure to give us some emergency phone numbers as well.</p>
	  <p class="lead">
	    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/employee/addPhone" role="button">Contact Numbers</a>
	  </p>
	  
	</div>
</body>

</html>