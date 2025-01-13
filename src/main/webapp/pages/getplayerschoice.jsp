<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Player Details</title>

<style type="text/css">
	/* General Reset */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f5f5f5;
    color: #333;
}

/* Container Styling */
.container {
    width: 50%;
    margin: 100px auto;
    text-align: center;
    background: white;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.container h1 {
    font-size: 26px;
    margin-bottom: 20px;
    color: ;
}

/* Button Styling */
.button {
    display: inline-block;
    text-decoration: none;
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    margin: 10px;
    border-radius: 5px;
    font-size: 16px;
    transition: background-color 0.3s ease;
}

.button:hover {
    background-color: #45a049;
}

/* Responsive Design */
@media (max-width: 768px) {
    .container {
        width: 80%;
    }

    .button {
        padding: 8px 15px;
        font-size: 14px;
    }
}

* Button group styles */
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

	
</style>
</head>
<body>

		<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
		<h1>Make Your Choice</h1>

			<a href="/api/players/register" class="button">Add New Player</a> 
			<a href="/api/players/all" class="button">Get All Players</a> 
			<a href="/api/players/byid" class="button">Get Player By Name</a>

	</div>

</body>
</html>