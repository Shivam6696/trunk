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
background-color:#9999ff;

}

.btnExample:hover {
  color: #FFF;
  background: #900;
}

</style>
</head>
<body>
<form action="http://localhost:6696/logs/update" method="post"> 
 Subject     : <input type="text" value="${marks.subject }" name="subjectName">
 Maxmarks    :<input type = "number" value="${marks.maxmarks }" name="maxmarks">
 ObtaindMarks: <input type ="number" value="${marks.obtainedmarks }" name="obtainedmarks">
 				<input type="hidden" name="subject" value="${marks.subject }" />
 				<input type="hidden" name="rollnumber" value="${marks.rollnumber }" />
  <button class="btnExample" type="submit">Update</button>
  </form>
</body>
</html>