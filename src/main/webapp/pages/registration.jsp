<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
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
    align-items: center;    /* Vertically center */
    overflow: hidden;       /* Prevents scrolling */
}

/* Container styles */
.container {
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    padding: 30px;
    max-width: 400px;
    width: 100%;
    box-sizing: border-box;
    text-align: center;
}

/* Form labels */
label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #555;
    text-align: left; /* Align labels to the left */
}

/* Input fields */
input[type="text"],
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

/* Input fields focus effect */
input:focus {
    outline: none;
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}


/* Submit button */
input[type="submit"],
#signin {
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
    text-decoration: none;
    display: inline-block; /* Makes the link behave like a button */
    text-align: center; /* Ensures proper alignment of text inside */
}

/* Submit button hover effect */
input[type="submit"]:hover,
#signin:hover {
    background-color: #0056b3;
}
</style>

</head>
<body>

		<jsp:include page="navbar.jsp"></jsp:include>

		
    <div class="container">
        <form id="form-1" action="handleregister" method="post">
        
            <h1>Registration Form</h1>
            <label for="input-1">UserName:</label>
            <input id="username" placeholder="Enter Username" type="text" name="username" required/>
            
            <label for="input-1">Email:</label>
            <input id="email" placeholder="Enter Email" type="email" name="email" required/>
            
            <label for="input-1">Password:</label>
            <input id="password" placeholder="Enter password" type="password" name="password" required/>
            
			<input id="input-1" placeholder="Text" type="hidden" value="user" name="autority" />
            
            <input type="submit" value="Register" id="submit"/><br> <br>
            
            <a href="/api/ipl/user/" id="signin">Sign In</a>
            ${emptyfield}
        </form>
    
     </div>

</body>
</html>
