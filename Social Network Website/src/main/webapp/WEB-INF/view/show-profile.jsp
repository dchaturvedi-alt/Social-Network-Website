<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Profile</title>

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
	
	<c:if test="${friendflag == 'not_null'}" >
		<c:if test="${requestSent.getFriendshipStatus() == 'accepted'}">
			<p style="font-size:25px; text-align: center; color:green">You are friends !</p>
			<c:url var="removeFriend" value="/employee/removeFriend">
				<c:param name="targetUserId" value="${requestSent.getTargetUserId()}" />
			</c:url>
			<a href="${removeFriend}" class="btn btn-danger btn-lg" style="float:right;">Remove Friend</a><br>
		</c:if>
		<c:if test="${requestReceived.getFriendshipStatus() == 'pending'}">
			<c:url var="acceptRequest" value="/employee/acceptRequest">
				<c:param name="sourceUserId" value="${requestReceived.getSourceUserId()}" />
			</c:url>
			<a href="${acceptRequest}" class="btn btn-success btn-lg" style="float:right;">Accept Friend Request</a>
			<c:url var="rejectRequest" value="/employee/rejectRequest">
				<c:param name="sourceUserId" value="${requestReceived.getSourceUserId()}" />
			</c:url>
			<a href="${rejectRequest}" class="btn btn-warning btn-lg" style="float:right;">Reject Friend Request</a><br>
		</c:if>
		<c:if test="${requestSent.getFriendshipStatus() == 'pending'}">
			<p style="font-size:25px; text-align: center; color:magenta">Friend Request Sent</p>
		</c:if>
		<c:if test="${requestSent.getFriendshipStatus() == null}">
			<c:if test="${requestReceived.getFriendshipStatus() == null}">
				<c:url var="addFriend" value="/employee/addFriend">
					<c:param name="targetUserId" value="${employee.getId()}" />
				</c:url><br>
				<a href="${addFriend}" class="btn btn-success btn-lg" style="float:right;">Add Friend</a>
			</c:if>
		</c:if>
	</c:if>
	<br><br>
	
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="EmployeeID" class="col-sm-2 col-form-label">Employee ID</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="EmployeeID" value="${employee.getId()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="Name" class="col-sm-2 col-form-label">Name</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="Name" value="${employee.getFirstName()} ${employee.getMiddleName()} ${employee.getLastName()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="Email" class="col-sm-2 col-form-label">Email</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="Email" value="${employee.getEmail()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="Gender" class="col-sm-2 col-form-label">Gender</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="Gender" value="${employee.getGender()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="dob" class="col-sm-2 col-form-label">Date of Birth</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="dob" value="${employee.getDate()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<br><br>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="HouseNumber" class="col-sm-2 col-form-label">House Number</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="HouseNumber" value="${employee.getAddressHouseNo()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="City" class="col-sm-2 col-form-label">City</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="HouseNumber" value="${employee.getAddressCity()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="Pincode" class="col-sm-2 col-form-label">Pincode</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="Pincode" value="${employee.getAddressPincode()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<fieldset class="form-group">
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0" style="font-size:25px;">Alma Matter Names</legend>
      <div class="col-sm-10">
      	<c:forEach var="tempAlmaMatter" items="${almaMatters}">
			<div class="form-check">
	          <input type="text" class="form-control" value="${tempAlmaMatter.getAlmaMatterName()}" readonly style="font-size: 15px;">
	        </div>
		</c:forEach>
      </div>
    </div>
  </fieldset>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="Designation" class="col-sm-2 col-form-label">Designation</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="Designation" value="${about.getDesignation()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="AboutYou" class="col-sm-2 col-form-label">About You</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="AboutYou" value="${about.getAboutYou()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<form>
	  <div class="form-group row" style="font-size: 20px;">
	    <label for="RelationshipStatus" class="col-sm-2 col-form-label">Relationship Status</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="RelationshipStatus" value="${about.getRelationshipStatus()}" readonly style="font-size: 15px;">
	    </div>
	  </div>
	</form>
	
	<fieldset class="form-group">
    <div class="row">
      <legend class="col-form-label col-sm-2 pt-0" style="font-size:25px;">Phone Numbers</legend>
      <div class="col-sm-10">
      	<c:forEach var="tempPhoneNumber" items="${phoneNumbers}">
			<div class="form-check">
	          <input type="text" class="form-control" value="${tempPhoneNumber.getPhoneNumber()}" readonly style="font-size: 15px;">
	        </div>
		</c:forEach>
      </div>
    </div>
  </fieldset>

	
</body>

</html>