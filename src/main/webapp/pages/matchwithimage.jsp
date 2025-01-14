<!DOCTYPE html>
<%@page import="com.tka.entity.User"%>
<%@page import="com.tka.entity.Matches"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Match Schedule</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 1200px;
	margin: 20px auto;
	padding: 10px;
	display: flex;
	justify-content: space-evenly;
	flex-wrap: wrap;
	gap: 20px;
}

.match-card {
	margin-top: 40px;
/* 	margin-right:30px; */
    background : #fff;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	padding: 20px;
	text-align: center;
	background: #fff;
}

.match-card .date {
	font-weight: bold;
	color: #007bff;
	margin-bottom: 10px;
}

.teams {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 15px 0;
}

.team {
	text-align: center;
	width: 45%;
}

.team img {
	width: 60px;
	height: 60px;
	margin-bottom: 10px;
}

.team-name {
	font-size: 14px;
	font-weight: bold;
}

.vs {
	font-size: 16px;
	font-weight: bold;
	align-self: center;
}

.match-info {
	font-size: 16px;
	margin: 10px 0;
}

.actions {
	margin-top: 15px;
}

.btn-update, .btn-delete {
	padding: 8px 12px;
	margin: 5px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	display: inline-block;
}

.btn-update {
	background-color: #28a745;
	color: white;
}

.btn-delete {
	background-color: #dc3545;
	color: white;
}

.btn-update:hover {
	background-color: #218838;
}

.btn-delete:hover {
	background-color: #c82333;
}
</style>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<% User user = ( User)session.getAttribute("existinguser"); %>
	<%
	ArrayList<Matches> matches = (ArrayList<Matches>) request.getAttribute("matches");
	%>
	<div class="container">
		<%
		if (matches != null) {
		%>
		<%
		for (int i = 0; i < matches.size(); i++) {
		%>
		<div class="match-card">
			<div class="date">
				<%=matches.get(i).getMatchDate()%>
			</div>
			<div class="teams">
				<div class="team">
					<img src="<%=matches.get(i).getTeam1().getTeamLogo()%>"
						alt="<%=matches.get(i).getTeam1().getName()%>">
					<div class="team-name"><%=matches.get(i).getTeam1().getName()%></div>
				</div>
				<div class="vs">vs</div>
				<div class="team">
					<img src="<%=matches.get(i).getTeam2().getTeamLogo()%>"
						alt="<%=matches.get(i).getTeam2().getName()%>">
					<div class="team-name"><%=matches.get(i).getTeam2().getName()%></div>
				</div>
			</div>
			<div class="match-info">
				Location:
				<%=matches.get(i).getLocation()%>
			</div>
				<% 	if(user != null){ %>
			<% if(user.getAutority().equalsIgnoreCase("admin")){ %>
			<div class="actions">
				<!-- Update Button -->
				<form action="matchupdateid" method="post" style="display: inline;">
					<input type="hidden" name="id"
						value="<%=matches.get(i).getId()%>">
					<button type="submit" class="btn-update">Update</button>
				</form>
				<!-- Delete Button -->
				<form action="deletematchhandler" method="post"
					style="display: inline;">
					<input type="hidden" name="id"
						value="<%=matches.get(i).getId()%>">
					<button type="submit" class="btn-delete">Delete</button>
				</form>
			</div>
			<% 
			}
				}
			%>
		</div>
		<%
		}
		%>
		<%
		}
		%>
	</div>    
	
</body>
</html>
