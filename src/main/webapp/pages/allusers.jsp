<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.tka.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
<style>
    /* General Styles */
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #6a11cb, #2575fc);
        color: #fff;
        text-align: center;
        margin: 0;
        padding: 20px;
    }

    h1 {
        margin-bottom: 20px;
        font-size: 2em;
    }

    /* Table Styles */
    .user-table {
        width: 80%;
        margin: 0 auto;
        margin-top: 50px;
        border-collapse: collapse;
        background: #fff;
        color: #333;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
    }

    .user-table th, .user-table td {
        padding: 12px 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    .user-table th {
        background: #007bff;
        color: white;
        font-weight: bold;
    }

    .user-table tr:hover {
        background: #f1f1f1;
    }

    .user-table tbody tr:nth-child(even) {
        background: #f9f9f9;
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .user-table {
            width: 100%;
        }
    }
</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body>

	<jsp:include page="navbar.jsp"></jsp:include>

 <h1>All Users</h1>
	 <% List<User> users = (List<User>) request.getAttribute("users"); %>

 
 <table class="user-table">
	 <thead>
		 <tr>
			 <th>Username</th>
			 <th>Email</th>
			 <th>Authority</th>
			 <th>Action</th>
		 </tr>
	 </thead>
	 <tbody>
	 <% if( users != null){ %>
	 <% for(int i = 0; i < users.size(); i++){ %>
		 <tr>
			 <td><%= users.get(i).getUsername() %></td>
			 <td><%= users.get(i).getEmail() %></td>
			 <td><%= users.get(i).getAutority() %></td>
			 
			<%--  <td>
				 <form id="form-1" action="make-admin" method="post">
					 <input type="hidden" value=<%= users.get(i).getId() %> id="button-2" name="userId"/>
					 <input type="submit" value="Admin" onclick="display()" id="button-1"/>
				 </form>
			 </td> --%>
			 <td> 
			 <button class="btn btn-outline-success" onclick="display(<%= users.get(i).getId() %>)">Admin</button>
			 </td>
		 </tr>
		 <% } } %>
	 </tbody>
 </table>
 
</body>

<script type="text/javascript">
	
		function display(userId){
	
	let result = confirm("Are you sure want to make admin..");
	if(result){
		window.location.href = "http://localhost:8085/api/ipl/user/make-admin/"+userId;
		}else{
		window.location.reload();
			}
			}
</script>

</html>