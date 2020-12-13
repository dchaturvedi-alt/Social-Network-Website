<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Pending Friend Requests</title>

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
	p{
		font-size: 20px;
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
	<p>The following users have sent you a friend request</p>
	<div class="list-group">
		<c:forEach var="result" items="${wannabeFriends}">
			
			<c:url var="profileLink" value="/employee/searchUserProfile">
				<c:param name="searchUserId" value="${result.getId()}" />
			</c:url><br>
			
			<a href="${profileLink}" class="list-group-item list-group-item-action flex-column align-items-start">
			    <div class="d-flex w-100 justify-content-between">
			      <p><c:out value="${result.getFirstName()}" /> <c:out value="${result.getMiddleName()}"/> <c:out value="${result.getLastName()}"/></p>
			      <p><c:out value="${result.getId()}"/></p>
			    </div>
			  </a>
		</c:forEach>
	</div>
</body>

</html>