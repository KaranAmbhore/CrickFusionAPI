<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Make Your Choice</title>
<style type="text/css">

/* General styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
}

/* Navbar styles */
.navbar {
    width: 100%;
    background-color:#333;
    display: flex;
    justify-content: space-between;
    padding: 10px 20px;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1000;
}

.navbar a {
    color: white;
    text-decoration: none;
    font-size: 18px;
    padding: 10px 20px;
    transition: background-color 0.3s;
}

.navbar a:hover {
    background-color: #555;
    border-radius: 5px;
}

/* Profile section */
.profile-section {
    margin-top: 80px;
    text-align: center;
    background-color: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 80%;
    max-width: 1200px;
}

.profile-section h1 {
    font-size: 28px;
    color: #333;
    margin-bottom: 10px;
}

.profile-section .profile-info {
    font-size: 18px;
    color: #666;
    margin-bottom: 20px;
}

.profile-section .profile-img {
    border-radius: 50%;
    width: 100px;
    height: 100px;
    object-fit: cover;
    margin-bottom: 15px;
}

/* Container style */
.container {
    background-color: #ffffff;
    padding: 40px;
    border-radius: 12px;
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 1200px;
    width: 100%;
    margin-top: 50px; /* to prevent overlap with navbar */
}

/* Heading styles */
h1 {
    font-size: 28px;
    color: #333;
    margin-bottom: 20px;
    font-weight: bold;
}

/* Button group styles */
.button-group {
    display: flex;
    justify-content: center; /* Center buttons horizontally */
    flex-wrap: wrap; /* Wrap buttons if screen is smaller */
    gap: 20px; /* Space between buttons */
    margin-top: 20px;
}

/* Button styles */
a.button {
    text-decoration: none;
    font-size: 16px;
    font-weight: bold;
    padding: 12px 25px;
    color: white;
    background-color: #007BFF; /* Primary blue */
    border: none;
    border-radius: 6px;
    text-align: center;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

a.button:hover {
    background-color: #0056b3; /* Darker blue for hover */
    transform: scale(1.05);
}

/* Responsive design: Adjust button sizes and container width */
@media (max-width: 768px) {
    .container {
        padding: 30px;
    }
    .button-group {
        flex-direction: column;
        align-items: center; /* Stack buttons vertically */
    }
}

@media (max-width: 480px) {
    h1 {
        font-size: 22px;
    }
    a.button {
        font-size: 14px;
        padding: 10px 20px;
    }
}

</style>
</head>
<body>

<!-- Navbar Section -->
<div class="navbar">
    <a href="#">Home</a>
    <a href="#">Dashboard</a>
    <a href="#">Players</a>
    <a href="#">Teams</a>
    <a href="#">Matches</a>
    <a href="#">Logout</a>
</div>

<!-- Profile Section -->
<div class="profile-section">
    <img src="/images/ipl-logo.jpg" alt="Profile Image" class="profile-img">
    <h1>Welcome, ${name}</h1>
</div>

<!-- Main Content Section -->
<div class="container">
    <h1>Make Your Choice</h1>
    <div class="button-group">
        <a href="register" class="button">Add New Player</a>
        <a href="all" class="button">Get All Players</a>
        <a href="byid" class="button">Get Player By Name</a>
        <a href="team" class="button">Add Team</a>
        <a href="allteams" class="button">Get All Teams</a>
        <a href="teambyname" class="button">Get Team By Name</a>
        <a href="addmatch" class="button">Add Match</a>
        <a href="allmatches" class="button">Get All Matches</a>
        <a href="getmatch" class="button">Get Matches by Date</a>
    </div>
</div>

</body>
</html>
