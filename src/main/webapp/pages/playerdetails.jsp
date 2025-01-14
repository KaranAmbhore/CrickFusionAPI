<%@page import="com.tka.entity.User"%>
<%@page import="com.tka.entity.PlayerDetails"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Player Information</title>
    <link rel="stylesheet" type="text/css" href="/styles/playerdetails.css">
    
 
</head>
<body>

					<% User user = (User)session.getAttribute("existinguser"); %>
		
	
		<jsp:include page="navbar.jsp"></jsp:include>

		<div class="search-player" style="margin-top: 100px;" >
			<form id="form-1" action="playerdetailsbyname" method="post">
				<input id="input-1" placeholder="Enter Player Name" type="text" name="name"  />
				<input type="submit" value="Search Player" id="button-1"/> <br> <br>
			<p style="color: red">${availablenot}</p>
			
			</form>
			
		</div>

    <% ArrayList<PlayerDetails> players = (ArrayList<PlayerDetails>) request.getAttribute("players"); %>
    <div class="container">
        <% if (players != null) { %>
            <% for (PlayerDetails player : players) { %>
                <div class="player-card">
                    <img src="<%= player.getPlayerImage() %>" alt="<%= player.getPlayerName() %>">
                    <div class="player-name"><%= player.getPlayerName() %></div>
                    <div class="player-details">
                        <span class="stat-title">Age:</span> <%= player.getAge() %> <br>
                        <span class="stat-title">Role:</span> <%= player.getPlayerRole() %> <br>
                        <span class="stat-title">Team:</span> <%= player.getTeam().getName() %> <br>
                        <span class="stat-title">Runs:</span> <%= player.getTotalRuns() %> <br>
                        <span class="stat-title">Strike Rate:</span> <%= player.getStrikeRate() %> <br>
                        <span class="stat-title">Centuries:</span> <%= player.getTotalCenturies() %> <br>
                        <span class="stat-title">Wickets:</span> <%= player.getWickets() %> <br>
                        <span class="stat-title">Economy:</span> <%= player.getEconomy() %>
                    </div>
                    
                    	<% 	if(user != null){ %>
                         	<% if(user.getAutority().equalsIgnoreCase("admin")){ %>
                    
                      <div class="actions">
                        <!-- Update Button -->
                        <form action="getupdateplayerid" method="post" style="display: inline;">
                            <input type="hidden" name="id" value="<%= player.getPlayerId() %>">
                            <button type="submit" class="btn-update">Update</button>
                        </form>
                        <!-- Delete Button -->
                        <form action="deleteplayerhandler" method="post" style="display: inline;">
                            <input type="hidden" name="id" value="<%= player.getPlayerId() %>">
                            <button type="submit" class="btn-delete">Delete</button>
                        </form>
                    </div>
                  <% } 
                    	}
                  %>
                </div>
              
            <% } %>
        <% } %>
          <p>${error}</p>
                <p>${success}</p>
    </div>
</body>
</html>
