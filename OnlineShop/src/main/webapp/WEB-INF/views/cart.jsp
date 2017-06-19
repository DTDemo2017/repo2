<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<head>
<title>Cart</title>
  <meta charset="utf-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="resources/css/a.css"> 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  
  .zui-table {
    border: solid 1px #DDEEEE;
    border-collapse: collapse;
    border-spacing: 0;
    font: normal 13px Arial, sans-serif;
    width:70%;
}
.zui-table thead th {
    background-color: #DDEFEF;
    border: solid 1px #DDEEEE;
    color: #336B6B;
    padding: 10px;
    text-align: left;
    text-shadow: 1px 1px 1px #fff;
}
.zui-table tbody td {
    border: solid 1px #DDEEEE;
    color: #333;
    padding: 10px;
    text-shadow: 1px 1px 1px #fff;
}
.zui-table-rounded {
    border: none;
}
.zui-table-rounded thead th {
    background-color: #CFAD70;
    border: none;
    text-shadow: 1px 1px 1px #ccc;
    color: #333;
}
.zui-table-rounded thead th:first-child {
    border-radius: 10px 0 0 0;
}
.zui-table-rounded thead th:last-child {
    border-radius: 0 10px 0 0;
}
.zui-table-rounded tbody td {
    border: none;
    border-top: solid 1px #957030;
    background-color: #EED592;
}
.zui-table-rounded tbody tr:last-child td:first-child {
    border-radius: 0 0 0 10px;
}
.zui-table-rounded tbody tr:last-child td:last-child {
    border-radius: 0 0 10px 0;
}
</style>
</head>
<title>Insert title here</title>
</head>
<body style="background-color:pink;">
<%@ include file="header.jsp" %>


<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div> 
<table class="zui-table zui-table-rounded" border="100%" color="yellow">   
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
   
  
   <td><img src="${pageContext.request.contextPath}/${content.product.productImage }" height="70" width="70"></td>
   <td><a href="${pageContext.request.contextPath }/deleteItems/${content.cartItemId }">Delete</a></td>  
   </tr>
   
   </c:forEach> 
   
  
   </table> 
   
   Amount : ${tot}
   <a href="${pageContext.request.contextPath}/addBill"><input type="submit" value="Proceed to Check Out "></a>
    
   <hr color="blue">
   
   
   
   
   </div>
</body>
</html>