<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 
        <h1>Edit Users</h1>  
       <form:form method="POST" action="${pageContext.request.contextPath}/editsave" enctype="multipart/form-data">
        
        <table >    
        <tr>  
        <td><img src="${pageContext.request.contextPath}/${photo}" height="50" width="50"></td>    
         <td><form:hidden  path="productId"  /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="productName" /></td>  
         </tr>    
         <tr>    
          <td>Price  :</td>    
          <td><form:input path="productPrice" /></td>  
         </tr>   
         <tr>    
          <td>Category  :</td>    
          <td><form:select items="${categoryList}"  itemLabel="categoryName" itemValue="categoryId" path="productCategory.categoryId" /></td>  
         </tr> 
          
           <tr>
									<td><form:hidden path="productImage"/></td>
								</tr>
								
         
         <tr>    
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    