<%@page import="com.tka.entity.Player"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Players</title>

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

#table-1 th, #table-1 td {
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

/* Delete button styling */
#delete {
	display: block;
	width: 150px;
	margin: 20px auto;
	padding: 10px 20px;
	font-size: 16px;
	font-weight: bold;
	color: white;
	background-color: #d9534f;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	transition: all 0.3s ease;
}

#delete:hover {
	background-color: #c9302c;
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
	transform: translateY(-2px);
}

#delete:active {
	background-color: #a94442;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	transform: translateY(1px);
}

</style>
</head>
<body>

	<%
	ArrayList<Player> players = (ArrayList<Player>) request.getAttribute("players");
	%>



	<div class="container">

		<form action="deletehandler" method="post">

			<table id="table-1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Team Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (players != null) {
					%>
					<%
					for (int i = 0; i < players.size(); i++) {
					%>
					<tr>

						<td><input type="radio" id="select"
							value="<%= players.get(i).getId() %>" name="id"></td>
						<td><%=players.get(i).getId()%></td>
						<td><%=players.get(i).getName()%></td>
						<td><%=players.get(i).getAge()%></td>
						<td><%=players.get(i).getTeam().getName()%></td>

					</tr>
					<%
					}

					}
					%>


				</tbody>
			</table>

			<input type="submit" value="Delete" id="delete" name="delete" />
		</form>


	</div>
<!-- 
	<a href="deletehadler"><button>Delete</button></a> -->


</body>
</html>