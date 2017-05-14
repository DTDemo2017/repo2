<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>View All The Products</h2>
<table>
<c:forEach var="product" items="${productList }">
<tr>
<td>
<img alt="${product.productname}" src="resources/img/${product.productid}.JPG">
</td>
<td>
<a href="mycart/add/${product.productid}">Add To Cart</a>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>