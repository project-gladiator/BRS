<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Page</title>

<script>
	//i=0; j=0; k=0;l=0;m=0;n=0;
	
		function insert()
		{
			x=document.getElementById("passN").value;
			a=document.getElementById("demo");
			
			for(z=0;z<x;z++)
			{
			b=document.createElement("input");
			b.setAttribute("type","text");
			b.setAttribute("id","i"+(z));
			b.setAttribute("name","passName"+(z));
			b.setAttribute("placeholder","Enter your Name");
			
			c=document.createElement("input");
			c.setAttribute("type","number");
			c.setAttribute("id","j"+(z));
			c.setAttribute("name","age"+(z));
			c.setAttribute("placeholder","Enter your Age");

			d=document.createElement("input");
			d.setAttribute("type","text");
			d.setAttribute("id","k"+(z));
			d.setAttribute("name","gender"+(z));
			d.setAttribute("placeholder","Enter your Gender");
			
			a.appendChild(b);
			a.appendChild(c);
			a.appendChild(d);
			}
		}
		
</script>

</head>
<body>
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
			<td>${busInfo.bus_id}</td>
			<td>${busInfo.bus_type}</td>
			<td>${busInfo.bus_name }</td>
			<td>${busInfo.capacity}</td>
			<td>${busInfo.source}</td>
			<td>${busInfo.destination}</td>
			<td>${busInfo.fare}</td>
		</tr>
	</table>

	<form action="bookingProcess" modelAttribute="book" method="post">
		<table>
			<tr>
				<td>Enter email : </td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Enter no of passengers : </td>
				<td><input type="number" name="noOfPassengers" id="passN" /></td>
				<td><input type="button" value="Add" onclick="insert()"/><br/></td>
			</tr>
			
			<!-- FOR LOOP -->
			
			
		<tr>	<td colspan="3"><div id="demo"></div><br/></td></tr>
			
			<tr>
				<td>Enter Cost : </td>
				<td><input type="number" value="${busInfo.fare}" name="cost" readonly/></td>
			</tr>
			<tr>
				<td>Enter Journey Date : </td>
				<td><input type="text" name="journeyDate" /></td>
			</tr>
			<tr>
				<td>Enter Bus No : </td>
				<td><input type="number" value="${busInfo.bus_id}" name="busno" readonly /></td>
			</tr>
			<tr>
				<td>Enter Booking Date : </td>
				<td><input type="text" name="bookingDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Book" /></td>
			</tr>
		</table>
	</form>

</body>
</html>