<%@page import="com.tka.entity.Player"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Player By Name</title>

<style type="text/css">
	/* General page styling */
body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f9f9f9;
    color: #333;
}

/* Container styling */
.container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
}

/* Form styling */
#form-1 {
    display: flex;
    flex-direction: column;
    gap: 15px;
    margin-bottom: 20px;
}

#form-1 label {
    font-weight: bold;
}

#form-1 input[type="text"] {
    padding: 8px 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
}

#form-1 input[type="submit"] {
    padding: 10px 15px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 14px;
}

#form-1 input[type="submit"]:hover {
    background-color: #45a049;
}

/* Table styling */
#table-1 {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    background-color: #fff;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

#table-1 th,
#table-1 td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: center;
}

#table-1 th {
    background-color: #4CAF50;
    color: white;
    text-transform: uppercase;
    font-size: 14px;
}

#table-1 tr:nth-child(even) {
    background-color: #f2f2f2;
}

#table-1 tr:hover {
    background-color: #f1f1f1;
    cursor: pointer;
}
	
</style>
</head>
<body>

	<div class="container">
		<form id="form-1" action="playerbyname" method="post">
			<label for="name">Enter Name:</label>
			<input id="name" placeholder="Enter Player Name" type="text" name="name" />
			<input type="submit" value="Search Player" id="submit"/>
		
		</form>
	
	<% ArrayList<Player> players = ( ArrayList<Player>)  request.getAttribute("players"); %>
	<%-- <% out.println(players); %> --%>
		<table id="table-1">
			<thead>
				<tr>
					<th>Player ID</th>
					<th>Player Name</th>
					<th>Age </th>
					<th>Team Name</th>
				</tr>
			</thead>
	 	<tbody>
	 		<% if(players != null){ %>
			<% for(int i = 0; i < players.size(); i++){	%>
			
				<tr>
					<td> <% out.println(players.get(i).getId()); %></td>
					<td> <% out.println(players.get(i).getName()); %></td>
					<td> <% out.println(players.get(i).getAge()); %></td>
					<td> <% out.println(players.get(i).getTeam().getName()); %></td>
				<% }
	 		}
			%>
				</tr>
			</tbody> 
		</table>
			${error}
	</div>

</body>
</html>