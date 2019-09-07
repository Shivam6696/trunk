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

.hh:hover {
	color: #FFFFFFF;
	background-color: skyblue;
}

.ff:hover {
	color: #FFFFFFF;
	background-color: skyblue;
}
</style>
</head>
<body>

	</form>
	<form action="http://localhost:6696/logs/loadExcel" method="post"
		enctype="multipart/form-data" style="padding: 50px">
		File : <input type="file" class="ff" name="mf" required="required">
		<input type="submit" class="hh" value="Upload File">

	</form>
</body>
</html>