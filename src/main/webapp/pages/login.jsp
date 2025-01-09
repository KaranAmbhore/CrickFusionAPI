<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
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

.container {
    background-color: #fff;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    width: 300px;
}

label {
    font-size: 14px;
    font-weight: bold;
    color: #333;
    margin-bottom: 5px;
    display: block;
}

input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 8px 12px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
    box-sizing: border-box;
}

input[type="text"],
input[type="password"]:focus {
    border-color: #007bff;
    outline: none;
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

input[type="submit"] {
    background-color: #007bff;
    color: #fff;
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    font-size: 14px;
    font-weight: bold;
    cursor: pointer;
    transition: background-color 0.3s ease;
    width: 100%;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}

#form-1 {
    display: flex;
    flex-direction: column;
}

#button-1 {
    margin-top: 10px;
}
	

</style>

</head>
<body>
	<div class = "container">
	
		<form id="form-1" action="loginhandle" method="post">
		
		
		<label for="input-1">UserName:</label>
		<input id="input-1" placeholder="Enter Username" type="text" name="username"/><br>
		
		<label for="input-2">Password:</label>
		<input id="input-2" placeholder="Enter Password" type="password" name="password"/><br>
		
		<input type="submit" value="Login" id="button-1"/>
		<%-- <% out.println(request.getAttribute("error")); %> --%>
		${error}

		</form>
	</div>

</body>
</html>