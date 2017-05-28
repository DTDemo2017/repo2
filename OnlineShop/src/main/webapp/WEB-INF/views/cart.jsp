<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<%@ include file="header.jsp" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
<table class="table table-bordered table-condensed"   style="width:70%;">  
<tr><th>Product Name</th><th>Product Id</th><th>Quantity</th><th>Product's Category Name</th><th>Product Price</th><th>CartItem Id</th><th>Product Image</th><th>Action</th></tr>  
<c:set  var="tot" value="${0}" scope="session"/>
   <c:forEach var="content" items="${cartContent}">   
     
   <tr>
   <td  width="20%">${content.product.productName}</td>  
   <td>${content.product.productId}</td>
   <td>${content.quantity}</td>
   <td> ${content.product.productCategory.categoryName} </td>
   <td>${content.subTotal}</td>
   <td>${content.cartItemId}</td>
   
   
    <c:set var="tot" value="${tot+ content.subTotal }" scope="session"/>
   
  
   <td><img src="${pageContext.request.contextPath}/${content.product.productImage }" height="50" width="50"></td>
   <td><a href="${pageContext.request.contextPath }/deleteItems/${content.cartItemId }">Delete</a></td>  
   </tr>
   
   </c:forEach> 
   
  
   </table> 
   
   Amount : ${tot}
   <a href="${pageContext.request.contextPath}/addBill"><input type="submit" value="Proceed to Check Out "></a>
    
   
   
   
   
   
   </div>
</body>
</html>