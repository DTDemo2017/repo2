<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Add Product</h1>  
       <form:form method="post" action="${pageContext.request.contextPath}/saveProduct" enctype="multipart/form-data">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="productName"  /></td>  
         </tr>    
         <tr>    
          <td>Price :</td>    
          <td><form:input path="productPrice" /></td>  
         </tr>   
         <tr>
									<td><form:hidden path="productImage"/></td>
								</tr>
								<tr>
									<td>Choose Image</td>
									<td><input type="file" name="file"/></td>
								</tr>
								
								<tr>    
          <td>Category :</td>    
          <td><form:input path="productCategory.categoryId" /></td>  
         </tr>  
         
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
