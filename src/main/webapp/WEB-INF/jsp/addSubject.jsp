<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<i>Add New Subject</i>
	</h1>
	<form action="http://localhost:6696/logs/thankyou" method="post"> 
	<tr>
	<th>
	Roll Number:<input type="text" name="studentrollnumber">
	</th>
	<th>
	Name       :<input type="text" name="studentname">
	</th>
	<th>
	Add Subject: <input type="text" name="subjectName">
	</th>
	<th>
   ObtaindMarks: <input type ="number" name="obtaindmarks">
   </th>
   <th>
   Maxmarks    :<input type = "number" name="maxmarks">
   </th>
   <th>
  
		<input type="submit"> </form>
</th>
</tr>
</body>
</html>