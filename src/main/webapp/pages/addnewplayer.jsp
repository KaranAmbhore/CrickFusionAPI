<%@ page import="com.tka.entity.PlayerDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Player Details</title>
    <link rel="stylesheet" type="text/css" href="/styles/playerupdate.css">
</head>
<body>

			<jsp:include page="navbar.jsp"></jsp:include>
			
			
    <div class="update-container" style="margin-top: 80px;">
        <h1>Add New Player Details</h1>
        <form action="addnewplayerhandler" method="post">
            <!-- Hidden field to send player ID -->
            <input type="hidden" name="playerId" >

            <!-- Player Image -->
            <label for="playerImage">Player Image URL:</label>
            <input type="text" id="playerImage" name="playerImage"  required>

            <!-- Player Name -->
            <label for="playerName">Player Name:</label>
            <input type="text" id="playerName" name="playerName" required>

            <!-- Player Age -->
            <label for="age">Age:</label>
            <input type="number" id="age" name="age"  required>

            <!-- Player Role -->
            <label for="playerRole">Role:</label>
            <input type="text" id="playerRole" name="playerRole" required>

            <!-- Team -->
            <label for="teamName">Team Name:</label>
            <input type="text" id="teamName" name=team.id  required>

            <!-- Runs -->
            <label for="totalRuns">Total Runs:</label>
            <input type="number" id="totalRuns" name="totalRuns"  required>

            <!-- Strike Rate -->
            <label for="strikeRate">Strike Rate:</label>
            <input type="number" step="0.01" id="strikeRate" name="strikeRate" required>

            <!-- Centuries -->
            <label for="totalCenturies">Centuries:</label>
            <input type="number" id="totalCenturies" name="totalCenturies"  required>

            <!-- Wickets -->
            <label for="wickets">Wickets:</label>
            <input type="number" id="wickets" name="wickets" required>

            <!-- Economy -->
            <label for="economy">Economy:</label>
            <input type="number" step="0.01" id="economy" name="economy" required>

	
            <button type="submit" class="btn-update">Save Changes</button><br>
            	<% String error =(String ) request.getAttribute("error"); %>
				<p><%if(error != null){ out.println(error);} %></p>
            <p>${success}</p>
        </form>
    </div>
</body>
</html>
