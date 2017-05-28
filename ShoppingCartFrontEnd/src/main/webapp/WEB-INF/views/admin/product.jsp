
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Product Page</title>

</head>
<body>
	<h1>Add a Product</h1>

	<c:url var="addAction" value="/manage_product_add?${_csrf.parameterName}=${_csrf.token}"></c:url>

	<form:form action="${addAction}" commandName="product"
		enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td><form:label path="productid">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty product.productid}">
						<td><form:input path="productid" value="" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="productid" pattern=".{5,20}" required="true"
								title="id should contains 5 to 20 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<form:input path="productid" hidden="true" />
				
				
				<td><form:label path="productname">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="productname" required="true" /></td>
			</tr>

            <tr>
				<td>Description</td>
				<td><form:input path="productdescription" required="true" /></td>
			</tr>
			<tr>
				<td> Price </td>
				<td><form:input path="productprice" required="true" /></td>
			</tr>

			<tr>
				<td>Category</td>
				<td><form:select path="category.categoryname" items="${categoryList}"
						itemValue="categoryname" itemLabel="categoryname" /></td>
			</tr>

			<tr>
				<td>Supplier</td>
				<td><form:select path="supplier.suppliername" items="${supplierList}"
						itemValue="suppliername" itemLabel="suppliername" /></td>
			</tr>
			
			<tr>
				<td align="left"><form:label path="image">
						<spring:message text=" Image" />
					</form:label></td>
				<td align="left"><form:input type="file" name="image" path="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty product.productname}">
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.productname}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
		</table>
		
		<input type="hidden" 
             name="${_csrf.parameterName}" 
             value="${_csrf.token}" />
	</form:form>
	<br>



	<h3>Product List</h3>
	<c:if test="${!empty productList}">
		<table class="tg">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Description</th>
				<th width="80">Price</th>
				<th width="80">Product Category</th>
				<th width="80">Product Supplier</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.productid}</td>
					<td>${product.productname}</td>
					<td>${product.productdescription}</td>
					<td>${product.productprice}</td>
					<td>${product.category.categoryname}</td>
					<td>${product.supplier.suppliername}</td>
					<td><a href="<c:url value='manage_product/edit/${product.productid}' />">Edit</a></td>
					<td><a href="<c:url value='manage_product/remove/${product.productid}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>