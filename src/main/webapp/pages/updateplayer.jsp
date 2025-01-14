<%@ page import="com.tka.entity.PlayerDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Player Details</title>
    <link rel="stylesheet" type="text/css" href="/styles/playerupdate.css">
</head>
<body>

			<jsp:include page="navbar.jsp"></jsp:include>
    <% 
        PlayerDetails player = (PlayerDetails) request.getAttribute("player"); 
    %>
    <div class="update-container">
        <h1>Update Player Details</h1>
        <form action="updateplayerhandler" method="post">
            <!-- Hidden field to send player ID -->
            <input type="hidden" name="playerId" value="<%= player.getPlayerId() %>">

            <!-- Player Image -->
            <label for="playerImage">Player Image URL:</label>
            <input type="text" id="playerImage" name="playerImage" value="<%= player.getPlayerImage() %>" required>

            <!-- Player Name -->
            <label for="playerName">Player Name:</label>
            <input type="text" id="playerName" name="playerName" value="<%= player.getPlayerName() %>" required>

            <!-- Player Age -->
            <label for="age">Age:</label>
            <input type="number" id="age" name="age" value="<%= player.getAge() %>" required>

            <!-- Player Role -->
            <label for="playerRole">Role:</label>
            <input type="text" id="playerRole" name="playerRole" value="<%= player.getPlayerRole() %>" required>

            <!-- Team -->
            <label for="teamName">Team Name:</label>
            <input type="text" id="teamName" name=team.id value="<%= player.getTeam().getId() %>" required>

            <!-- Runs -->
            <label for="totalRuns">Total Runs:</label>
            <input type="number" id="totalRuns" name="totalRuns" value="<%= player.getTotalRuns() %>" required>

            <!-- Strike Rate -->
            <label for="strikeRate">Strike Rate:</label>
            <input type="number" step="0.01" id="strikeRate" name="strikeRate" value="<%= player.getStrikeRate() %>" required>

            <!-- Centuries -->
            <label for="totalCenturies">Centuries:</label>
            <input type="number" id="totalCenturies" name="totalCenturies" value="<%= player.getTotalCenturies() %>" required>

            <!-- Wickets -->
            <label for="wickets">Wickets:</label>
            <input type="number" id="wickets" name="wickets" value="<%= player.getWickets() %>" required>

            <!-- Economy -->
            <label for="economy">Economy:</label>
            <input type="number" step="0.01" id="economy" name="economy" value="<%= player.getEconomy() %>" required>

		<% String error =(String ) request.getAttribute("error"); %>
				<p><%if(error != null){ out.println(error);} %></p>
            <button type="submit" class="btn-update">Save Changes</button>
        </form>
    </div>
</body>
</html>
