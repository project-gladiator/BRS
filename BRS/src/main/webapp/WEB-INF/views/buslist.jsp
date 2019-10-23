<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Bus List</h1>
	 
	<form action="buslist" method="post">
	Source:<input type="text" name="source"><br><br>
	Destination:<input type="text" name="destination"><br><br>
	<input type="submit" name="Submit">
	</form> 
	
</body>
</html>