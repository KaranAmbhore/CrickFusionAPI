<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Player Information</title>

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
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    height: 100vh; /* Full viewport height */
    display: flex;
    justify-content: center; /* Horizontally center */
    align-items: center; /* Vertically center */
}

/* Container styles */
.container {
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    padding: 30px;
    max-width: 500px;
    width: 100%;
    text-align: center;
    box-sizing: border-box;
}

/* Form title */
.container h1 {
    font-size: 24px;
    margin-bottom: 20px;
    color: #333;
}

/* Labels */
label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #555;
    text-align: left;
}

/* Input fields */
input[type="text"],
input[type="number"],
input[type="email"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 14px;
    box-sizing: border-box;
}

/* Input focus effect */
input:focus {
    outline: none;
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

/* Submit button */
input[type="submit"] {
    width: 100%;
    padding: 12px;
    background-color: #007bff;
    border: none;
    border-radius: 5px;
    color: #ffffff;
    font-size: 16px;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

/* Submit button hover effect */
input[type="submit"]:hover {
    background-color: #0056b3;
}

/* Error and Message styles */
.error,
.message {
    margin-top: 15px;
    font-size: 14px;
    font-weight: bold;
}

/* Error message */
.error {
    color: #d9534f;
}

/* Success message */
.message {
    color: #5cb85c;
}
	

</style>
</head>
<body>
		<div class="container">
			<form id="form-1" action="updateplayer" method="post">
			
				<h1>Edit Player Details</h1>
				
				
				<label for="input-1">Player ID:</label>
				<input id="id" placeholder="Enter Id" type="number" name="id" value="${player.id}" required/>
			
				<label for="input-1">Player Name:</label>
				<input id="name" placeholder="Enter Name" type="text" name="name" value="${player.name}" required/>
				
				<label for="input-1">Player Age:</label>
				<input id="age" placeholder="Enter Age" type="number" name="age" value="${player.age}" required/>
				
				<label for="input-1">Team Id:</label>
				<input id="teamid" placeholder="Enter Team Id" type="number" name="team.id" value="${player.team.id}" required/>
			<!-- 	
				<label for="input-1">Team Name:</label>
				<input id="teamname" placeholder="Enter Team Name" type="text" name="team.name"/> -->
				
				<input type="submit" value="Save Changes" id="submit"/>
				
				${error} 
				${message}
			</form>
		
		 </div>
		
	

</body>
</html>