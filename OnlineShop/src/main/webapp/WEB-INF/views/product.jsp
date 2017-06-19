<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html lang="en">
<head>
<head>
  <title>Bootstrap Case</title>
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

<div class="container">
<table class="zui-table zui-table-rounded" border="100%" color="yellow">
<tr><th>ProductId </th><th>Name </th><th>Price </th><th>Image </th><th>Category</th></tr>
<tr><td>${product.productId}</td><td>${product.productName}</td><td>${product.productPrice}</td><td><img src="${pageContext.request.contextPath}/${product.productImage}" height="100" width="100"></td><td>${product.productCategory.categoryName}</td></tr>
<tr><th colspan="2"><a href="${pageContext.request.contextPath}/cart/add/${product.productId}" class="btn btn-info" role="button">Add To Cart</a></th></tr>
<tr><th colspan="2"><a href="${pageContext.request.contextPath}/cart/show" class="btn btn-info" role="button">Show Cart </a></th></tr>
       </table>
<!-- <tr><th>ProductId </th><td>${product.productId}</td></tr>
<tr><th>Name </th><td>${product.productName}</td></tr>
<tr><th>Price </th><td>${product.productPrice}</td></tr>
<tr><th>Image </th><td><img src="${pageContext.request.contextPath}/${product.productImage}" height="50" width="50"></td></tr>
<tr><th>Category</th><td>${product.productCategory.categoryName}</td></tr>
<tr><th colspan="2"><a href="${pageContext.request.contextPath}/cart/add/${product.productId}" class="btn btn-info" role="button">Add To Cart</a></th></tr>
<tr><th colspan="2"><a href="${pageContext.request.contextPath}/cart/show" class="btn btn-info" role="button">Show Cart </a></th></tr>
       </table> -->
<hr color="blue">




</div>
</body>
</html>