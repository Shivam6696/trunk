<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
  background-color:	#FFE4E1;
}
a
{
color : #4169E1;
}
.btnsubmit1:hover {
	color:#FFFFF;
	background-color:#00CED1;
}
</style>
</head>
<body>
<form action="http://localhost:6696/logs/details" method="post">
    Roll Number: <input type="number" name="rollnumber">
       <button class="btnsubmit1" type="submit">Submit</button>
    </form>
    <tr>
    <th>
 Welcome !! <a href="http://localhost:6696/logs/addsubject">Click here</a> to add a new subject .
</body>
</html>