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
<h2>  Manage Categories   </h2>
<div id="Create Category" method="get">
<form action="manage_category_add">

<input type="text" name="categoryid">
<input type="text" name="categoryname">
<input type="text" name="categorydescription">
<input type="submit" value="Create Category">
</form>
</div>





<h2>Update the Categories</h2>
<div id="Update Category">
<form action="manage_category_update" method="get">
<input type="text" name="categoryid" value="${selectedCategory.categoryid}">
<input type="text" name="categoryname" value="${selectedCategory.categoryname}">
<input type="text" name="categorydescription" value="${selectedCategory.categorydescription}">
<input type="submit" value="Update Category">
</form>
</div>





<h2>Delete /Update the Categories</h2>
<div id="Show Categories">

<table border="2">
<thead>
<tr>
<td> Category ID </td>
<td> Category Name </td>
<td> Category Description </td>
<td colspan="3"> Action </td>
</tr>
</thead>
<c:forEach var="category" items="${categoryList}">

<tr>
<td> ${category.categoryid} </td>
<td> ${category.categoryname} </td>
<td> ${category.categorydescription} </td>
<%--   <td> <a href="manage_category_delete/${category.id}"> Delete | </a>   
	   <a href="manage_category_edit/${category.id}"> Edit  </a>    </td> --%>
	   
<td>
<td> <a href="<c:url value='/manage_category_edit/${category.categoryid}'/>">Edit</a></td>
<td> <a href="<c:url value='/manage_category_delete/${category.categoryid}'/>">Delete</a></td>

</td>
</tr>
</c:forEach>

</table>
</div>



</body>
</html>