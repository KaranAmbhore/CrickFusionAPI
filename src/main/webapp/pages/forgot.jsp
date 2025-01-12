<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password Page</title>
<style>
    /* General body styling */
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9fc;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Center the container */
    .container {
        background-color: #ffffff;
        padding: 25px 30px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    /* Form styling */
    form {
        margin-bottom: 15px;
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
    input[type="email"], input[type="number"] {
        font-size: 14px;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ddd;
        border-radius: 4px;
        width: 100%;
        box-sizing: border-box;
    }

    input[type="email"]:focus, input[type="number"]:focus {
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

    /* Disabled button styling */
    input[type="submit"][disabled] {
        background-color: #ccc;
        cursor: not-allowed;
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

    .info {
        color: #17a2b8;
    }
</style>
</head>
<body>

		<% boolean showOTPForm = request.getAttribute("showotpform") != null && (boolean) request.getAttribute("showotpform"); %>
	

    <div class="container">
    
    		<h1>Confirm Your Identity</h1>
        <form action="forgot-handler" method="post">
            <label for="input-1">Email:</label>
            <input id="input-1" placeholder="Enter Email Id" type="email" name="email" value="${email}" required />
            <input type="submit" value="Send OTP" id="button-1" />
        </form>

        <form id="form-1" action="otp-handler" method="post">
            <label for="input-2">OTP:</label>
            <input id="input-2" placeholder="Enter OTP" type="number" name="otp" 
                   <% if (!showOTPForm) { %> readonly="readonly" <% } %> />
            <input type="submit" value="Submit" id="button-2" 
                   <% if (!showOTPForm) { %> disabled="disabled" <% } %> />
        </form>

        <!-- Messages -->
        <div class="message error">${error}</div>
        <div class="message success">${success}</div>
        <div class="message info">${invalidotp}</div>
    </div>
</body>
</html>
