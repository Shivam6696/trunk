<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1><i>Student Details</i></h1>
   <table border=1>
     <tr>
      <th  style="padding: 10px">rollNumber</th>
      <th>name</th>
      </tr>
      
      <tr>
       <td>${st.rollnumber}</td>
      <td>${st.name}</td>
      <tr>
      </table>
      
      <table>
      <tr>
      <th>subject</th>
      <th>obtainedMarks</th>
      <th>maxMarks</th>
      </tr>
      
      <tr>
      <td>${st.subject}</td>
      <td>${st.obtainedMarks}</td>
      <td>${st.maxMarks}</td>
       </tr>
       </table>
       
       <table>
       <tr>
       <th>percentage</th>
       </tr>
       </table>
</body>
</html>