<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bus Details</h1>
	
	<div>
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
		<tr>
			<td>${requestScope.emp.bus_id}</td>
			<td>${requestScope.emp.bus_type}</td>
			<td>${requestScope.emp.bus_name }</td>
			<td>${requestScope.emp.capacity}</td>
			<td>${requestScope.emp.source}</td>
			<td>${requestScope.emp.destination}</td>
			<td>${requestScope.emp.fare}</td>
		</tr>
	</table>
	</div>
	
	<div>
	<form action="bookticket?id=${requestscope.emp.bus_id} " method="post">
	<input type="text" name="name" placeholder="Enter name">
	<input type="email" name="email" placeholder="Enter Email Id">
	<input type="number" name="noOfSeats" required="required" value="1" min="1">
	<input type="submit"> 
	</form>
	</div>
</body>
</html>