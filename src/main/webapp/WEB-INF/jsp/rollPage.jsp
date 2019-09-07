<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: lightblue;
}

h1 {
	color: black;
}

.btnsubmit:hover {
	color: #FFFFFF;
	background: blue;
}

.btnsubmit:hover {
	color: #FFFFFFF;
	background-color: skyblue;
}
.btnsubmit3:hover 
{
color: #FFFFFFF;
	background-color: skyblue;
}
.btnsubmit4:hover 
{
color: #FFFFFFF;
	background-color: skyblue;
}

</style>
</head>
<body>
	<h1>Welcome you are Successfully!! enter</h1>
	<form action="http://localhost:6696/logs/studentdata" method="post">

		Roll Number: <input type="number" name="rollnumber">
		<button class="btnsubmit" type="submit">Submit</button>

		<h1>see more details plz submit</h1>
	</form>

	<form action="http://localhost:6696/logs/homepage" method="post">
		<h1 style="text-decoration: underline;">back to the home page to
			add new more details</h1>
		<button class="btnsubmit3" type="submit">Home</button>
	</form>
	<form action="http://localhost:6696/logs/uploadfile" method="post">
	<button class="btnsubmit4" type="submit">Insert Excel</button>
	</form>
	
</body>
</html>