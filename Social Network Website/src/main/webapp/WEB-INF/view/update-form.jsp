<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<title>Update</title>

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
	
	<div class="form-group">
							<div class="col-xs-15">
								<div>

									<!-- Check for registration error -->
									<c:if test="${dateError == 1}">

										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										<p style="font-size:20px; text-align: center;"><c:out value="Please Enter a valid date"></c:out></p>
										</div>
										<br><br><br><br>
									</c:if>
									
									<c:if test="${dateError == 3}">

										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										<p style="font-size:20px; text-align: center;"><c:out value="Please enter valid Email id !"></c:out></p>
										</div>
										<br><br><br><br>
									</c:if>
									
									<c:if test="${dateError == 4}">

										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										<p style="font-size:20px; text-align: center;"><c:out value="First Name is required !"></c:out></p>
										</div>
										<br><br><br><br>
									</c:if>
									
									<c:if test="${dateError == 5}">

										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
										<p style="font-size:20px; text-align: center;"><c:out value="Email id already exists"></c:out></p>
										</div>
										<br><br><br><br>
									</c:if>

								</div>
							</div>
						</div>
	
	<h1 style="text-align: center; font-size:25px;">Welcome to update form</h1>

	<form:form
		action="${pageContext.request.contextPath}/employee/updateInfo"
		modelAttribute="employee" method="GET">
		
		<form:hidden path="id" />
		<label for="employeeId" style="font-size:15px;">Employee ID</label>
		<input class="form-control" type="text" placeholder="${employee.getId()}" style="font-size:15px;" id="employeeId" readonly><br>
		<div class="form-row">
			<div class="form-group col-md-4">
		      <label for="firstName" style="font-size:15px;">First Name*</label>
		      <form:input path="firstName" style="font-size:15px;" value="${employee.getFirstName()}" class="form-control" id="firstName"/>
		    </div>
		    
		    <div class="form-group col-md-4">
		      <label for="middleName" style="font-size:15px;">Middle Name</label>
		      <form:input path="middleName" style="font-size:15px;" value="${employee.getMiddleName()}" class="form-control" id="middleName"/>
		    </div>
		    
		    <div class="form-group col-md-4">
		      <label for="lastName" style="font-size:15px;">Last Name</label>
		      <form:input path="lastName" style="font-size:15px;" value="${employee.getLastName()}" class="form-control" id="lastName"/>
		    </div>
		</div>
		
		<div class="form-group">
			<label for="emailAddress" style="font-size:15px;">Email ID*</label>
			<form:input path="email" style="font-size:15px;" value="${employee.getEmail()}" class="form-control" id="emailAddress"/>
		</div>
		
		<p style="font-size:20px;">Please select your gender:</p>
		<div class="form-check form-check-inline">
			<form:radiobutton path="gender" style="font-size:15px;" value="Male" class="form-check-input" name="inlineRadioOptions" id="inlineRadio1"/>
			<label class="form-check-label" for="inlineRadio1" style="font-size:15px;">Male</label>
		</div>
		
		<div class="form-check form-check-inline">
			<form:radiobutton path="gender" style="font-size:15px;" value="Female" class="form-check-input" name="inlineRadioOptions" id="inlineRadio2"/>
			<label class="form-check-label" for="inlineRadio2" style="font-size:15px;">Female</label>
		</div>
		
		<div class="form-check form-check-inline">
			<form:radiobutton path="gender" style="font-size:15px;" value="Other" class="form-check-input" name="inlineRadioOptions" id="inlineRadio3"/>
			<label class="form-check-label" for="inlineRadio3" style="font-size:15px;">Other</label>
		</div>
		
		<div class="form-check form-check-inline">
			<form:radiobutton path="gender" style="font-size:15px;" value="Prefer not to say" class="form-check-input" name="inlineRadioOptions" id="inlineRadio4"/>
			<label class="form-check-label" for="inlineRadio4" style="font-size:15px;">Prefer not to say</label>
		</div>
		<br><br>
		
		<label class="form-check-label" for="dob" style="font-size:15px;">Date of birth*</label>
		<form:input path="date" class="form-control" style="font-size:15px;" id="dob"/>
		<br>
		<p style="font-size:20px;">Address</p>
		<label class="form-check-label" for="hNo" style="font-size:15px;">House Number</label>
		<form:input path="addressHouseNo" style="font-size:15px;" class="form-control" id="hNo"/>
		<br>
		<label class="form-check-label" for="city" style="font-size:15px;">City</label>
		<form:input path="addressCity" style="font-size:15px;" class="form-control" id="city"/>
		<br>
		<label class="form-check-label" for="pincode" style="font-size:15px;">Pincode</label>
		<form:input path="addressPincode" style="font-size:15px;" class="form-control" id="pincode"/>
		<br>
		<button type="submit" style="font-size:15px;" class="btn btn-success btn-lg">Update</button>
		
	</form:form>

</body>

</html>