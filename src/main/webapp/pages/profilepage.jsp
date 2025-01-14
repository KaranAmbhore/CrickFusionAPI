<%@page import="com.tka.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>

<style type="text/css">
	/* General reset */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f5f5f5;
    color: #333;
}

/* Profile Image */
.profile-img {
    text-align: center;
    margin-top: 80px;
}

.profile-img img {
	background-size:contain;
    width: 150px;
    height: 150px;
    border-radius: 50%;
    border: 3px solid #4CAF50;
}

/* Edit Button */
.edit-btn {
    text-align: center;
    margin: 20px 0;
}

.edit-btn #button-2 {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

.edit-btn #button-2:hover {
    background-color: #45a049;
}

/* Container Form */
.container {
    width: 50%;
    margin: 0 auto;
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.container form {
    display: flex;
    flex-direction: column;
}

.container label {
    margin: 10px 0 5px;
    font-weight: bold;
}

.container input[type="text"],
.container input[type="email"],
.container input[type="password"] {
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 14px;
}

.container input[readonly] {
    background-color: #f0f0f0;
    color: #888;
}

.container #button-1 {
    background-color: #4CAF50;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

.container #button-1:disabled {
    background-color: #ccc;
    cursor: not-allowed;
}

.container #button-1:hover:not(:disabled) {
    background-color: #45a049;
}

/* Logout Button */
a {
    text-decoration: none;
}

button {
    background-color: #f44336;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    display: block;
    margin: 20px auto;
}

button:hover {
    background-color: #d32f2f;
}
	

</style>
</head>
<body>


		<jsp:include page="navbar.jsp"></jsp:include>

		<% boolean enableEdit = request.getAttribute("enableEdit") != null && (boolean) request.getAttribute("enableEdit"); %>

		<% User existingUser =(User)session.getAttribute("existinguser"); %>


	<div class="profile-img">

		<img alt="Profile Picture" src="/images/profile.jpg">

	</div>
	

	<div class="edit-btn">
		<form id="form-2" action="edituser" method="get">
		
			<input type="submit" value="Edit" id="button-2"/>
		</form>
	
	</div>	

	<div class="container">

		<% if(existingUser != null){ %>
		
		<form id="form-1" action="edituserdetails" method="post">

			<label for="input-1">UserName:</label> <input id="input-1"
				placeholder="UserName" type=text name="username" value="<%= existingUser.getUsername() %>" <% if(!enableEdit){ %> readonly="readonly" <%} %> />

			<label for="input-2">Email:</label> <input id="input-2"
				placeholder="Email" type="email" name="email" value="<%= existingUser.getEmail() %>" <% if(!enableEdit){ %> readonly="readonly" <%} %> />

			<label for="input-3">Password:</label> <input id="input-3"
				placeholder="Password" type="password" name="password" value="<%= existingUser.getPassword() %>"
				 <% if(!enableEdit){ %> readonly="readonly" <%} %> />
				
		 <input type="submit" value="Save Changes" id="button-1"  <% if(!enableEdit){ %>  disabled="disabled" <%} %> />
		</form>

	</div>

	<a href="logout"><button>Logout</button></a>  
	
	
	<% }else{ %>
		<h1>Please Login First..</h1>
		<h1><a href="/api/ipl/user/">Login</a></h1>
		
	<% } %>
</body>
</html>