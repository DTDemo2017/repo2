<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<h2>  Manage Suppliers   </h2>
<div id="Create Supplier" method="get">
<form action="manage_supplier_add">

<input type="text" name="supplierid">
<input type="text" name="suppliername">
<input type="text" name="supplieraddress">
<input type="submit" value="Create Supplier">
</form>
</div>





<h2>Update the Suppliers</h2>
<div id="Update Supplier">
<form action="manage_supplier_update" method="get">
<input type="text" name="supplierid" value="${selectedSupplier.supplierid}">
<input type="text" name="suppliername" value="${selectedSupplier.suppliername}">
<input type="text" name="supplieraddress" value="${selectedSupplier.supplieraddress}">
<input type="submit" value="Update Supplier">
</form>
</div>





<h2>Delete /Update the Suppliers</h2>
<div id="Show Suppliers">

<table border="2">
<thead>
<tr>
<td>Supplier ID</td>
<td>Supplier Name</td>
<td>Supplier Address</td>
<td colspan="3">Action</td>
</tr>
</thead>
<c:forEach var="supplier" items="${supplierList}">

<tr>
<td>${supplier.supplierid}</td>
<td>${supplier.suppliername}</td>
<td>${supplier.supplieraddress}</td>
<%--   <td> <a href="manage_supplier_delete/${supplier.supplierid}"> Delete | </a>   
	   <a href="manage_supplier_edit/${supplier.supplierid}"> Edit  </a>    </td> --%>
	   

	   
<td>
<td> <a href="<c:url value='/manage_supplier_edit/${supplier.supplierid}'/>">Edit</a></td>
<td> <a href="<c:url value='/manage_supplier_delete/${supplier.supplierid}'/>">Delete</a></td>
</td>


</tr>
</c:forEach>

</table>
</div>



</body>
</html>