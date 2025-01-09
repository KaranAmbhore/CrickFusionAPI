<%@page import="java.util.ArrayList"%>
<%@page import="com.tka.service.PlayerService"%>
<%@page import="com.tka.entity.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
<style type="text/css">

		/* General page styling */
body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f9f9f9;
    color: #333;
}

/* Table styling */
#table-1 {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
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
    letter-spacing: 1px;
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

	<h1>Login successful..Proceed further.</h1>
	
	<%/*  out.println(request.getAttribute("players")); */
	
	ArrayList<Player> players =  (ArrayList<Player>) request.getAttribute("players");
	
	for(Player player : players){
		out.println(player.getName());
		out.println(player.getAge());
		out.println(player.getTeam().getName());
	}
	
	%>
	<table id="table-1" style="border: 1px solid black;">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Team Name</th>
			</tr>
		</thead>
		<tbody>
				<% for(int i = 0; i < players.size();i++){  %>
			<tr>
					
				<td> <%  out.println(players.get(i).getName()); %></td>
				<td> <%  out.println(players.get(i).getAge()); %></td>
				<td> <%  out.println(players.get(i).getTeam().getName()); %></td>
				<%-- <td> <% out.println(player.getAge()); %> </td>
				<td> <% out.println(player.getTeam().getName()); %>  </td> --%>
				
			<%  } %>
			</tr>
		</tbody>
	</table>
	
	
</body>
</html>