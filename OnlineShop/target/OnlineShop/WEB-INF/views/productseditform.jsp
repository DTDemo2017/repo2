<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
photo :  ${photo}
        <h1>Edit Products</h1>  
       <form:form method="POST" action="/OnlineShop/editsave" enctype="multipart/form-data">
        
        <table >    
        <tr>  
        <td></td>    
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
         aaa
          <td><img src="${pageContext.request.contextPath}/${photo}" height="50" width="50"></td>
           <tr>
									<td><form:hidden path="productImage"/></td>
								</tr>
								<tr>
									<td>Choose Image</td>
									<td><input type="file" name="file"/></td>
								</tr>
         
         <tr>    
           
         <tr>
         
         <tr>    
          <td>ProductCategory : </td>   
          <td><form:input path="productCategory"  /></td>  
         </tr> 
            
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    