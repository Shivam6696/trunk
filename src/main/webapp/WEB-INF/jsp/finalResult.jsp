<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Your Result</h1>


	<h1>
		<i>Student RollNumber</i>
	</h1>
	<table border=1>
		<tr>
			<th style="padding: 10px">Rollnumber</th>
		</tr>
		<tr>
			<td>${sd.rollnumber}</td>
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
				<td>${ss.name}</td>
				<td>${ss.fatherName}</td>
				<td>${ss.address}</td>
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

			</tr>
			<tr>
				<td>${ss.subject}</td>
				<td>${ss.maxmarks}</td>
				<td>${ss.obtainedmarks}</td>
			</tr>
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
			
				<th>${ss.percentage}</th>
		</table>


	</div>
	</form>
</body>
</html>