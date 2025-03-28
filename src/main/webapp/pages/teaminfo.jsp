<%@page import="java.net.URLEncoder"%>
<%@page import="com.tka.entity.PlayerDetails"%>
<%@page import="com.tka.entity.Player"%>
<%@page import="java.util.List"%>
<%@page import="com.tka.entity.Team"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
Team team = (Team) request.getAttribute("team");
List<PlayerDetails> players = (List<PlayerDetails>) request.getAttribute("players");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%=team.getName()%> - Team Details</title>
<style>
body {
	
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	color: #333;
}

.container {

	 max-width : 800px;
	margin: 30px auto;
	margin-top:50px; 
	padding: 20px;
	background: #fff;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	max-width: 800px;
}

.team-header {
	text-align: center;
	margin-bottom: 20px;
}

.team-header h1 {
	font-size: 2.5em;
	margin: 0;
	color: #2c3e50;
}

.team-header img {
	max-width: 100px;
	margin: 10px 0;
	border-radius: 50%;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

.team-header p {
	font-size: 1.2em;
	margin: 5px 0;
}

.players-list {
	margin-top: 30px;
}

.players-list h2 {
	font-size: 2em;
	margin-bottom: 20px;
	color: #34495e;
	border-bottom: 2px solid #e74c3c;
	display: inline-block;
	padding-bottom: 5px;
}

.players-list ul {
	list-style: none;
	padding: 0;
}

.players-list li {
	font-size: 1.2em;
	padding: 10px;
	margin-bottom: 10px;
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 5px;
	transition: background-color 0.2s ease-in-out;
}

.players-list li:hover {
	background-color: #f0f8ff;
}
</style>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
		<!-- Team Header Section -->
		<div class="team-header">
			<img src="<%=team.getTeamLogo()%>" alt="<%=team.getName()%> Logo">
			<h1><%=team.getName()%></h1>
			<p>
				<strong>Total Matches:</strong>
			</p>
			<p>
				<strong>Wins:</strong>
			</p>
		</div>

		<!-- Players List Section -->
		<div class="players-list">
			<h2>Players</h2>
			<ul>
				<%
				if (players != null && !players.isEmpty()) {
				%>
				<%
				for (PlayerDetails player : players) {
				%>
				<li> <a href="/api/players/playerdetailsbyname?name=<%= URLEncoder.encode(player.getPlayerName().trim(), "UTF-8") %>"><strong><%=player.getPlayerName()%></strong> </a> <br>
				Role:  <%=player.getPlayerRole()%> <br>
				Matches Played: <%=player.getTotalCenturies()%>
				</li>
				<%
				}
				%>
				<%
				} else {
				%>
				<li>No players found for this team.</li>
				<%
				}
				%>
			</ul>
		</div>
	</div>
</body>
</html>
