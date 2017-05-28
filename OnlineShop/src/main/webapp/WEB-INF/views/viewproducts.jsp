<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
   <body>
   <%@ include file="header.jsp" %>   
     
   <a href="productsform">Add New Products</a>
   <h1>Products List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Price</th><th>Category</th><th>Image</th><th colspan="2">Action</th></tr>  
   <c:forEach var="product" items="${list}">   
   <tr>  
   <td>${product.productId}</td>  
   <td>${product.productName}</td>  
   <td>${product.productPrice}</td>
   <td>${product.productCategory.categoryName}</td>
     
  <td><img src="${pageContext.request.contextPath}/${product.productImage}" height="50" width="50"></td>
   <td><a href="editproducts/${product.productId}">Edit</a></td>  
   <td><a href="deleteproducts/${product.productId}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   </body>
   </html>
   