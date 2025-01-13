<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Make Your Choice</title>
<style type="text/css">
/* General styles */
/* General styles */
/* General styles */
/* General styles */
body {
    font-family: 'Roboto', sans-serif;
    background: linear-gradient(135deg, #74b9ff, #0984e3);
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    color: #2d3436;
    min-height: 100vh;
    overflow-x: hidden;
}

/* Navbar styles */
.navbar {
    width: 100%;
    background: linear-gradient(135deg, #0984e3, #74b9ff);
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1000;
    padding: 10px 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.navbar ul {
    list-style: none;
    display: flex;
    margin: 0;
    padding: 0;
    gap: 20px;
}

.navbar ul li {
    margin: 0;
}

.navbar ul li a {
    text-decoration: none;
    color: white;
    font-size: 16px;
    font-weight: bold;
    transition: color 0.3s ease;
}

.navbar ul li a:hover {
    color: #dfe6e9;
}

.navbar .profile-section {
    font-size: 16px;
    font-weight: bold;
    color: white;
}

.navbar .profile-section a {
    text-decoration: none;
    color: white;
    transition: color 0.3s ease;
}

.navbar .profile-section a:hover {
    color: #dfe6e9;
}

/* Profile icon in navbar */
.navbar .profile {
    display: flex;
    align-items: center;
    gap: 10px;
}

.navbar .profile img {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    border: 2px solid white;
    object-fit: cover;
    transition: transform 0.3s ease;
}

.navbar .profile img:hover {
    transform: scale(1.1);
}

/* Profile section */
.profile-section {
    margin-top: 120px;
    text-align: center;
    background: rgba(255, 255, 255, 0.9);
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
    width: 80%;
    max-width: 1200px;
    transition: transform 0.3s ease;
}

.profile-section:hover {
    transform: scale(1.02);
}

.profile-section h1 {
    font-size: 32px;
    color: #2c3e50;
    margin-bottom: 10px;
}

.profile-section .profile-info {
    font-size: 18px;
    color: #7f8c8d;
    margin-bottom: 20px;
}

.profile-section .profile-img {
    border-radius: 50%;
    width: 120px;
    height: 120px;
    object-fit: cover;
    margin-bottom: 15px;
    border: 4px solid #74b9ff;
}

/* Container style */
.container {
    background: rgba(255, 255, 255, 0.9);
    padding: 40px;
    border-radius: 16px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
    text-align: center;
    max-width: 1200px;
    width: 100%;
    margin-top: 20px;
}

/* Heading styles */
h1 {
    font-size: 30px;
    color: #2c3e50;
    margin-bottom: 20px;
    font-weight: bold;
    letter-spacing: 1px;
}

/* Button group styles */
.button-group {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    gap: 15px;
    margin-top: 20px;
}

/* Button styles */
a.button {
    text-decoration: none;
    font-size: 16px;
    font-weight: bold;
    padding: 15px 30px;
    color: white;
    background: linear-gradient(135deg, #6c5ce7, #0984e3);
    border: none;
    border-radius: 8px;
    text-align: center;
    transition: all 0.3s ease;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
}

a.button:hover {
    background: linear-gradient(135deg, #74b9ff, #6c5ce7);
    transform: translateY(-3px);
    box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3);
}

/* Responsive design: Adjust button sizes and container width */
@media (max-width: 768px) {
    .container {
        padding: 30px;
    }
    .button-group {
        flex-direction: column;
        align-items: center;
    }
    a.button {
        padding: 12px 25px;
        font-size: 14px;
    }
}

@media (max-width: 480px) {
    h1 {
        font-size: 24px;
    }
    a.button {
        font-size: 12px;
        padding: 10px 20px;
    }
}

</style>
</head>
<body>

		<jsp:include page="navbar.jsp"></jsp:include>

<div class="profile-section">
    <img src="/images/ipl-logo.jpg" alt="Profile Image" class="profile-img">
    <h1>Welcome, ${name}</h1>
</div>

<div class="container">
    <h1>Make Your Choice</h1>
    <div class="button-group">
        <a href="/api/players/register" class="button">Add New Player</a>
        <a href="/api/players/all" class="button">Get All Players</a>
        <a href="/api/players/byid" class="button">Get Player By Name</a>
        <a href="/api/teams/team" class="button">Add Team</a>
        <a href="/api/teams/allteams" class="button">Get All Teams</a>
        <a href="/api/teams/teambyname" class="button">Get Team By Name</a>
        <a href="/api/matches/addmatch" class="button">Add Match</a>
        <a href="/api/matches/allmatches" class="button">Get All Matches</a>
        <a href="/api/matches/getmatch" class="button">Get Match by Date or Venue</a>
    </div>
</div>

</body>
</html>
