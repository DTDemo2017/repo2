<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
<c:set var="imageFolder" value="resources/img/" />
	<table>
		<tr>
			<th align="left" width="80">Cart ID</th>
			<th align="left" width="120">Product Name</th>
			<th align="left" width="200">Date Added</th>
			<th align="left" width="80">Price</th>
			<th colspan="2" align="center" width="60">Action</th>

		</tr>
		<c:forEach items="${cartList}" var="cart">
			<tr>
				<td align="left">${mycart.mycartid}</td>
				<td align="left">${mycart.productname}</td>
				<td align="left">${mycart.dateadded}</td>
				<td align="left">${mycart.price}</td>
				<td align="left"><a
					href="<c:url value='/myCart/delete/${mycart.mycartid}'  />">Delete</a></td>
					
					<img alt="${selectedProduct.productname}"
				src="${imageFolder}${selectedProduct.productid}.jpg">
			</tr>
		</c:forEach>

	</table>

	<h2>Total cost : ${totalAmount}</h2>
	<br>
	<a href="cart_checkout">Checkout </a>
	<br>
	<br>


</body>
</html>