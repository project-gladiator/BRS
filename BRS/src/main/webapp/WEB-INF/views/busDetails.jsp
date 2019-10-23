<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>asedfghj</h1>
		<h1>Employee List</h1>
	<table border="1">
		<tr>
			<th>Bus_ID</th>
			<th>Bus_Type</th>
			<th>Bus_Name</th>
			<th>Capacity</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Fare</th>
		</tr>
		<!-- For loop -->
		<c:forEach items="${requestScope.list }"  var="emp">
			<tr>
				<td>${emp.bus_id }</td>
				<td>${emp.bus_type }</td>
				<td>${emp.bus_name }</td>
				<td>${emp.capacity }</td>
				<td>${emp.source }</td>
				<td>${emp.destination }</td> 
				<td>${emp.fare }</td>
				<td><a href="book?id=${emp.bus_id}">BOOK</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>