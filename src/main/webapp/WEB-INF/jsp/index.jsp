<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div{
     margin-top: 100px;
     align-content: center;
     overflow: auto;
}
h1{
   color: 	#FFA500;
}
th
{
 background-color: 	#778899;
}
</style>
</head>
<body>
 <%-- 
<h1><i>Student Details</i></h1>
   <table border=1>
     <tr>
      <th  style="padding: 10px">Rollnumber</th>
      <th>Name</th>
      <th>fatherName</th>
      <th>Address</th>
      </tr>
       
      <tr>
      <td>${sd.rollnumber}</td>
      <td>${sd.name}</td>
      <td>${sd.fatherName}</td>
      <td>${sd.address}</td>
      </tr>
      </table>
      
     <div>
      <h1><i>Students Marks</i></h1>
      <table border=1>
      <tr>
      <th  style="padding: 10px">RollNumber</th>
      <th>Math</th>
      <th>English</th>
      <th>hindi</th>
      <th>Science</th>
      <th>MaxsMarks</th>
      <th>ObtainedMarks</th>
      <th>Percentage</th>
      </tr>
       
      <tr>
      <td>${sm.rollnumber}</td>
      <td>${sm.maths}</td>
      <td>${sm.english}</td>
      <td>${sm.hindi}</td>
      <td>${sm.science}</td>
       <td>${sm.maxmarks }</td>
      <td>${sm.obtainedmarks}</td>
      <td>${sm.percentage}</td>
      </tr>
      </table>
      </div>--%>
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