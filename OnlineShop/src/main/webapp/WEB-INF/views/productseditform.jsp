<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<center><table class="zui-table zui-table-rounded" border="100%" color="yellow">
        <h1>Edit Products</h1>  
       <form:form method="POST" action="${pageContext.request.contextPath}/editsave" enctype="multipart/form-data">
        
        <table class="zui-table zui-table-rounded" border="100%" color="yellow">    
        
        <tr>  
        <td><form:hidden  path="productId" /></td>  
        </tr>   
         
         <tr>    
          <td>ProductName : </td>   
          <td><form:input path="productName"  /></td>  
         </tr>    
         
         <tr>    
          <td>ProductPrice  :</td>    
          <td><form:input path="productPrice" /></td>  
         </tr>   
         
          
           <tr>
           <td><img src="${pageContext.request.contextPath}/${photo}" height="50" width="50"></td>  
									<td><form:hidden path="productImage"/></td>
								</tr>
								
								<tr>
									<td>Choose Image</td>
									<td><input type="file" name="file"/></td>
								</tr>
         
         <tr>    
           
         <tr>
         
         <tr>    
          <td>Category  :</td>    
          <td><form:select items="${categoryList}"  itemLabel="categoryName" itemValue="categoryId" path="productCategory.categoryId" /></td>  
         </tr> 
            
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
       </table> </center>
</body> 