<%@page import="com.tka.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Navigation Bar</title>
<style type="text/css">
/* Reset styles */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

/* General styles */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

/* Navigation bar styles */
.navbar {
	width: 100%;
	background-color: #007bff;
	color: white;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px 20px;
	position: fixed;
	top: 0;
	left: 0;
	z-index: 1000;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* Navigation links */
.nav-links {
	display: flex;
	gap: 20px;
	list-style: none;
	margin: 0;
	padding: 0;
}

.nav-links li {
	font-size: 16px;
	font-weight: bold;
}

.nav-links a {
	color: white;
	text-decoration: none;
	transition: color 0.3s ease;
}

.nav-links a:hover {
	color: #d9d9d9;
}
/* 
/* Profile section */
.profile {
	font-size: 16px;
	font-weight: bold;
}

.profile a {
	color: white;
	text-decoration: none;
	transition: color 0.3s ease;
}

.profile a:hover {
	color: #d9d9d9;
}

* /
.profile img {
	height: 20px;
	width: 20px;
}

/* Profile section adjustments */
/* Profile section inside the navbar */
.navbar .profile {
    display: flex;
    align-items: center; /* Vertically center items */
    gap: 10px; /* Space between the image and the username */
}

.navbar .profile img {
    width: 30px;
    height: 30px;
    border-radius: 50%; /* Make the image circular */
    border: 2px solid white;
    object-fit: cover; /* Maintain aspect ratio */
    transition: transform 0.3s ease;
}

.navbar .profile img:hover {
    transform: scale(1.1); /* Slight zoom effect on hover */
}

.navbar .profile a {
    display: flex;
    align-items: center;
    color: white;
    font-size: 16px;
    font-weight: bold;
    text-decoration: none;
    transition: color 0.3s ease;
}

.navbar .profile a:hover {
    color: #dfe6e9; /* Slightly lighter color on hover */
}


</style>
</head>
<body>

	<%
	User user = (User) session.getAttribute("existinguser");
	%>


	<nav class="navbar">
		<ul class="nav-links">
			<li><a href="/api/ipl/user/choice">Home</a></li>
			<li><a href="/api/ipl/user/playerschoice">Player</a></li>
			<li><a href="/api/ipl/user/teamschoice">Teams</a></li>
			<li><a href="/api/ipl/user/matcheschoice">Matches</a></li>
		<% if( user != null && user.getAutority().equalsIgnoreCase("admin")){ %>
			<li><a href="/api/ipl/user/all-users">All Users</a> </li>
			<% } %>
		</ul>
		<% if(user != null){ %>
		<div class="profile">
			<a href="/api/ipl/user/profile"><img id="image-1" alt="Profile Icon"
				src="/images/profile.jpg"  /> <%= user.getUsername() %> </a>
				</div>
	<% }else { %>
			<div class="profile">
			<a href="/api/ipl/user/"> Login</a>
				</div>
			<% 
	}
			%>
		
	</nav>


	<div></div>

</body>
</html>
