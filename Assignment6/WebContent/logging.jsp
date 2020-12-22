<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logging</title>
<link rel="stylesheet" href="style.css" />
</head>
<body id="page-top">

	<!-- Import necessary classes -->
	<%@page import="java.util.Map"%>
	<%@page import="java.util.UUID"%>
	<%@page import="com.algonquin.loggy.beans.Log"%>
	<%@page import="java.util.Map"%>


	<!-- Get data passed from servlet -->
	<%
		Map<UUID, Log> logs = (Map<UUID, Log>) request.getAttribute("logs");
	String id = (String) request.getAttribute("id");
	String title = (String) request.getAttribute("title");
	String content = (String) request.getAttribute("content");
	%>

	<!-- Form Section-->

	<div class="center">
		<header>
			<h1>Log ahead</h1>
			<form action="logs" method="post">
				<input type="hidden" name="id" value="<%=id%>" />
				<!-- Figure out how to actually pass the correct values...  -->
				<label for="fname">Title:</label><br> <input type="text"
					id="title" name="title" value="<%=title%>" /><br> <label
					for="lname">Content:</label><br> <input type="text"
					id="content" name="content" value="<%=content%>" /><br>
				<br> <input type="submit" value="Submit" /> <input
					type="button" value="Cancel" onclick="window.location='logs'" />
			</form>
		</header>
	</div>

	<!-- Content Section-->
	<!-- Loggy Items-->
	<div class="center">
		<table class="table">
			<thead>
				<tr>
					<th scope="col" class="col-2">#</th>
					<th scope="col" class="col-2">Title</th>
					<th scope="col">Content</th>
					<th scope="col" class="col-2">Actions</th>
				</tr>
			</thead>
			<tbody>

				<!-- Iterate through all logItems and print out table rows -->
				<%
					for (Map.Entry<UUID, Log> logItem : logs.entrySet()) {
					id = logItem.getValue().getId().toString();
					title = logItem.getValue().getTitle();
					content = logItem.getValue().getContent();
				%>

				<tr>
					<th scope="row"><%=id.substring(0, 8)%></th>
					<td><%=title%></td>
					<td><%=content%></td>
					<td><a href="logs?id=<%=id%>">Edit</a> <a
						href="logs?id=<%=id%>&action=delete">Delete</a></td>
				</tr>

				<%
					}
				%>


			</tbody>
		</table>
	</div>

</body>
</html>