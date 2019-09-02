<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Father_Name</th>
			<th>Address</th>
		</tr>

		<c:forEach var="std" items="${listStudent}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${std.id}</td>
				<td>${std.Name}</td>
				<td>${std.Father_Name}</td>
				<td>${std.Address}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>