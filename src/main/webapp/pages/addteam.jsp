<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Team</title>
<style type="text/css">
	/* General Styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* Container Styles */
.container {
    background-color: #fff;
    padding: 20px 40px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    width: 100%;
}

/* Form Heading */
h1 {
    text-align: center;
    color: #333;
    font-size: 24px;
    margin-bottom: 20px;
}

/* Label Styles */
label {
    display: block;
    margin-bottom: 8px;
    color: #555;
    font-weight: bold;
}

/* Input Fields */
input[type="text"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
}

/* Submit Button */
input[type="submit"] {
    background-color: #28a745;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    width: 100%;
    font-weight: bold;
}

input[type="submit"]:hover {
    background-color: #218838;
}

/* Error and Message Styling */
#error, #message {
    text-align: center;
    font-size: 14px;
    color: red;
    margin-top: 10px;
}

/* Success Message */
#message {
    color: green;
}
	
</style>

</head>
<body>

	
		<div class="container">
			<form id="form-1" action="addteam" method="post">
			
				<h1>Add New Team</h1>
				<label for="input-1">Team Name:</label>
				<input id="name" placeholder="Enter Name" type="text" name="name" value="${name}" required/>

				<label for="input-1">Team Logo:</label>
				<input id="name" placeholder="Enter Team Logo" type="text" name="teamLogo"  required/>
				
				<input type="submit" value="Add Team" id="submit"/>
				
				${error} 
				${message}
			</form>
		
		 </div>
	

</body>
</html>