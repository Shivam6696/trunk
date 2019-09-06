<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1 {
	color: black;
}

th {
	background-color: #778899;
}

body {
	background-color: #E0FFFF;
}

.edit:hover {
	color: #FFFFFF;
	background-color: #778899;
}
.delete:hover {
	color: #FFFFFF;
	background-color: #778899;
}
</style>
</head>
<body>

	<h1 style="text-decoration: underline;">Your Result</h1>
	<h1>
		<i>Student RollNumber</i>
	</h1>
	<table border=1>
		<tr>
			<th style="padding: 10px">Rollnumber</th>
		</tr>

		<tr>
			<td>${aa.rollnumber}</td>
		</tr>
	</table>
	<div>
		<h1>
			<i>Students Details</i>
		</h1>
		<table border=1>
			<tr>
				<th style="padding: 10px">Name</th>
				<th>fatherName</th>
				<th>Address</th>
			</tr>
			<tr>
				<td>${aa.name}</td>
				<td>${aa.fatherName}</td>
				<td>${aa.address}</td>
			</tr>
		</table>
	</div>
	<div>
		<h1>
			<i>Students Subject</i>
		</h1>
		<table border=1>
			<tr>
				<th style="padding: 10px">Subject</th>
				<th>MaxsMarks</th>
				<th>ObtainedMarks</th>
				<th>Delet data</th>
				<th>Edit data</th>
			</tr>
			<c:forEach items="${list}" var="ss">
				<tr>
					<td>${ss.subject}</td>
					<td>${ss.maxmarks}</td>
					<td>${ss.obtainedmarks}</td>
					<td>
						<form action="http://localhost:6696/logs/recordDelete"
							method="post">
							<input type="hidden" name="subjectName" value="${ss.subject}">
							  <input type="hidden" name="rollnumber" value="${ss.rollnumber}">
							<button type="submit" id="edit_button1" class="delete">Delete</button>

						</form>
					</td>
					<td>
						<form action="http://localhost:6696/logs/edit" method="post">
							<input type="hidden" name="rollnumber" value="${ss.rollnumber }" />
							<input type="hidden" name="subjectName" value="${ss.subject }" />
							<button type="submit" id="edit_button1" class="edit">Edit</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<h1>
			<i>Student Result</i>
		</h1>
		<table border=1>
			<tr>
				<th>Percentage</th>
			</tr>
			<tr>
				<th>${aa.percentage}</th>
		</table>
	</div>

</body>
</html>