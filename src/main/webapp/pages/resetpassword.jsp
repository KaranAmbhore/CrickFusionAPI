<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
<style>
    /* General Body Styling */
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

    input[type="text"]:focus {
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

    /* Error messages */
    .error {
        color: #ff0000;
        font-size: 13px;
        margin-top: -10px;
        margin-bottom: 10px;
    }
</style>
</head>
<body>

	<div class="container">
	
		<h1>Reset Password</h1>
		<form id="form-1" action="reset-pass" method="post">
			<label for="input-1">New Password:</label>
			<input id="input-1" placeholder="Enter New Password" type="text" name="newpass" />

			<label for="input-2">Confirm:</label>
			<input id="input-2" placeholder="Confirm New password" type="password" name="confirm" />

			<input type="submit" value="Change Password" id="button-1" /><br>

			<!-- Display error messages -->
			<div class="error">${notsame}</div>
			<div class="error">${wrong}</div>
		</form>
	</div>

</body>
</html>
