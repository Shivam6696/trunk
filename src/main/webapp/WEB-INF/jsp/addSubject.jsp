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
	<form action="http://localhost:6696/logs/newsubject" method="post"> 
	Roll Number:<input type="text" name="studentrollnumber">
	Name       :<input type="text" name="studentname">
	Add Subject: <input type="text" name="subjectName">
   ObtaindMarks: <input type ="number" name="obtaindmarks">
   Maxmarks    :<input type = "number" name="maxmarks">
   percentage  :<input type = "number" name= "percentage">
		<input type="submit"> </form>


</body>
</html>