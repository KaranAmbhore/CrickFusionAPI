<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tka.entity.Team"%>
<!DOCTYPE html>
<html>
<head>
    <title>Teams</title>
    <link rel="stylesheet" type="text/css" href="/styles/teamdata.css">
</head>
<body>

    <jsp:include page="navbar.jsp"></jsp:include>

    <% List<Team> teams = (List<Team>) request.getAttribute("teams"); %>
    <div class="team-container">
        <% if (teams != null) { %>
            <% for (Team team : teams) { %>
                <div class="team-card">
                    <img src="<%= team.getTeamLogo() %>" alt="<%= team.getName() %> Logo" class="team-logo">
                    <div class="team-info">
                        <h3 class="team-name"><%= team.getName() %></h3>
                        <p><strong>Total Matches:</strong>  </p>
                        <p><strong>Wins:</strong></p>
                        <a href="/api/team/playersinteam"></a>
                    </div>
                </div>
            <% } %>
        <% } %>
    </div>
</body>
</html>
