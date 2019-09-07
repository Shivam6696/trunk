<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body 
{
background-color:#ffb3d1;
}

.btnsubmit6:hover {
	color: #FFFFFFF;
	background-color:skyblue;
}

</style>
</head>
<body>
	Your data is successfully stored in database.
	<h1><a>THANK YOU !!</a></h1>
	
	<form action="http://localhost:6696/logs/home" method="post">
		<h7 style="text-decoration: underline;">back to the home page to
			add new more details</h7>
		<button class="btnsubmit6" type="submit">Home</button>
	</form>
</body>
</html>