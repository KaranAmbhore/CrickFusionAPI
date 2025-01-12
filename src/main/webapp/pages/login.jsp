<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
    /* General body styling */
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

    /* Center the container */
    .container {
        background-color: #fff;
        padding: 20px 30px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    /* Form styling */
    form {
        display: flex;
        flex-direction: column;
    }

    /* Label styling */
    label {
        font-size: 14px;
        margin-bottom: 5px;
        color: #333;
    }

    /* Input field styling */
    input[type="text"], input[type="password"] {
        font-size: 14px;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ddd;
        border-radius: 4px;
        width: 100%;
        box-sizing: border-box;
    }

    input[type="text"]:focus, input[type="password"]:focus {
        border-color: #007bff;
        outline: none;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.25);
    }

    /* Submit button styling */
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        font-size: 14px;
        font-weight: bold;
        padding: 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    /* Forgot password link styling */
    a {
        text-decoration: none;
        font-size: 14px;
        color: #007bff;
        margin-bottom: 10px;
        transition: color 0.3s;
    }

    a:hover {
        color: #0056b3;
    }

    /* Error and success messages */
    .message {
        font-size: 13px;
        margin-top: 10px;
    }

    .error {
        color: #ff0000;
    }

    .success {
        color: #28a745;
    }
    
    #signup {
        text-decoration: none; /* Remove underline */
        display: inline-block; /* Make it behave like a block element */
        padding: 10px 20px; /* Add padding for the button-like appearance */
        font-size: 14px; /* Font size for the text */
        font-weight: bold; /* Bold text */
        color: white; /* Text color */
        background-color: #007bff; /* Button background color */
        border-radius: 5px; /* Rounded corners */
        transition: background-color 0.3s ease; /* Smooth hover transition */
    }

    /* Hover effect */
    #signup:hover {
        background-color: #0056b3; /* Darker shade on hover */
    }
</style>
</head>
<body>
    <div class="container">
    	<h1>Login Form</h1>
        <form id="form-1" action="loginhandle" method="post">
            <label for="input-1">Username:</label>
            <input id="input-1" placeholder="Enter Username" type="text" name="username" value="${name}" required />

            <label for="input-2">Password:</label>
            <input id="input-2" placeholder="Enter Password" type="password" name="password" required />

            <a href="/api/ipl/user/forgot">Forgot Password?</a>
            <input type="submit" value="Login" id="button-1" /> <br>
			
				<a href="/api/ipl/user/registration" id="signup" style="text-align: center"> Sign Up</a>
            <!-- Error and success messages -->
            <div class="message error">${error}</div>
            <div class="message success">${changed}</div>
            <div class="message success">${success}</div>
        </form>
    </div>
</body>
</html>
