<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
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

<div class="container">
<table class="table table-bordered table-condensed">
<tr><th>ProductId </th><th>Name </th><th>Price </th><th>Image </th><th>Category</th></tr>
<tr><td>${product.productId}</td><td>${product.productName}</td><td>${product.productPrice}</td><td><img src="${pageContext.request.contextPath}/${product.productImage}" height="50" width="50"></td><td>${product.productCategory.categoryName}</td></tr>
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


</div>
</body>
</html>