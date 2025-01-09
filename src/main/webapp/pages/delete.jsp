<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Player</title>
<style type="text/css">

		/* Stylesheet for Delete Player JSP Page */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background-color: #ffffff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 300px;
    text-align: center;
}

form {
    margin: 0;
    display: flex;
    flex-direction: column;
    gap: 10px;
}

label {
    font-size: 14px;
    font-weight: bold;
    color: #333;
    text-align: left;
}

input[type="number"], input[type="submit"] {
    padding: 8px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

input[type="number"] {
    width: 100%;
}

input[type="submit"] {
    background-color: #228B22; /* Dark Red */
    color: white;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s;
}

input[type="submit"]:hover {
    background-color: #006400; /* Even Darker Red */
}

label {
    font-size: 14px;
    font-weight: bold; /* Bold font for label */
    color: #333;
    text-align: left;
}

input[type="submit"], button {
    font-weight: bold; /* Bold font for Delete and Cancel buttons */
}


button {
    padding: 8px 12px;
    font-size: 14px;
    border: none;
    background-color: #3498db;
    color: white;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #2980b9;
}

a {
    text-decoration: none;
    margin-top: 10px;
    display: inline-block;
}
		
</style>


</head>
<body>

	<div class="container">
		<form id="form-1" action="deletehandler" method="post">
		
			<label for="input-1">ID:</label>
			<input id="id" placeholder="Enter ID " type="number" value="${id}" name="id"/>
			<input type="submit" value="Delete" id="submit"/>
			
		</form>
	
	<a href="all"> <button>Cancel</button> </a> 
	
	</div>

</body>
</html>