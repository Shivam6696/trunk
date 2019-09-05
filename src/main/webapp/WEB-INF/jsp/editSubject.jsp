<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:6696/logs/edit" method="post"> 
 Subject     : <input type="text" value="${subject.subject }" name="subjectName">
 Maxmarks    :<input type = "number" value="${subject.maxmarks }" name="maxmarks">
 ObtaindMarks: <input type ="number" value="${subject.obtainedmarks }" name="obtaindmarks">
 
  <button type="submit">Submit</button>
  </form>
</body>
</html>