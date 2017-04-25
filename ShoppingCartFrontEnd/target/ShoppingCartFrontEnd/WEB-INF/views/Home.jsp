<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- <link rel="stylesheet" href="resources/css/bootstrap.css"> -->
  <link rel="stylesheet" href=""src/main/webapp/WEB-INF/resources/css/bootstrap.css"">
  <!-- <script src="resources/js/bootstrap.js"></script> -->
  <script src="src/main/webapp/WEB-INF/resources/js/bootstrap.js"></script>
  
</head>
<body>
<center>
<h2>Welcome to Shopping Cart</h2>
</center>


<a href="LoginPage"><span class="glyphicon glyphicon-user"></span></a>
<hr color="blue"> 

<a href="RegistrationPage">Register</a>
<hr color="blue">

<jsp:include page="Menu.jsp"></jsp:include>

${message}
<hr color="blue">





<br>
<c:if test="${isUserClickedLogin== 'true'}">
<jsp:include page="Login.jsp"></jsp:include>
</c:if>


<c:if test="${isUserClickedRegister== 'true'}">
<jsp:include page="Registration.jsp"></jsp:include>
</c:if>

</body>
</html>