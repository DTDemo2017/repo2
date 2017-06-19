<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
       <h1>Edit Product</h1>  
       <form:form method="POST" action="/crud_file_to_upload/editsave">    
        <table >    
        <tr>  
        <td>Id : </td>    
         <td><form:input path="productId" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="productName"  /></td>  
         </tr> 
         <tr>    
          <td>Category : </td>   
          <td><form:input path="productCategory"  /></td>  
         </tr>       
         <tr>    
          <td>Price  : </td>    
          <td><form:input path="productPrice" /></td>  
         </tr>   
          
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>  