<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Bootstrap Case</title>
        <meta charset="utf-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Flipkart Website</a>
    </div>
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      
      <c:forEach var="category" items="${categoryList}">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.categoryname} <span class="caret"></span></a>
        <ul class="${productList}">
          <li><a href="#">${product.productname}</a></li>
          <li><a href="#">${product.productname}</a></li>
          <li><a href="#">${product.productname}</a></li>
        </ul>
      </li>
      </c:forEach>
     
      <!-- <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Books<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Competitive Math by R.S.Aggarwal</a></li>
          <li><a href="#">Competitive Reasoning by R.S.Aggarwal</a></li>
          <li><a href="#">Competitive English by S.P.Bakshi</a></li>
        </ul>
      </li>
      
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Kids<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Kids Clothing</a></li>
          <li><a href="#">Kids Foot wear</a></li>
          <li><a href="#">Kids Toys</a></li>
        </ul>
      </li> -->
      
    </ul>
  </div>
</nav>
</body>
</html>
  

  