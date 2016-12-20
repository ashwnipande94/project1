
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page isELIgnored="false" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>             
.blue-button{  
    background: #25A6E1;  
    filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);  
    padding:3px 5px;  
    color:#fff;  
    font-family:'Helvetica Neue',sans-serif;  
    font-size:12px;  
    border-radius:2px;  
    -moz-border-radius:2px;  
    -webkit-border-radius:4px;  
    border:1px solid #1A87B9  
}       
table {  
  font-family: "Helvetica Neue", Helvetica, sans-serif;  
   width: 50%;  
}  
 td,th{  
                border: 1px solid gray;  
                width: 25%;  
                text-align: left;  
                padding: 5px;  
            }  
</style>



</head>
<body>
<h2>Product</h2>

 <div ng-app="app" ng-controller="myCtrl">
<div class="alert alert-info">
<input type="text" placeholder="Search the product" ng-model="searchProduct">
</div>
<br>
<form:form method="POST" modelAttribute="product" action="addProduct" enctype="multipart/form-data">
   <table>
    
   <tr>
        <td> <form:label  path="productId">Product Id</form:label></td>
        <td> <form:input  path="productId"/></td>
    </tr>
   
   
    <tr>
       <td><form:label path="productName">Product Name</form:label></td>
        <td><form:input path="productName" /></td>
        <td><form:errors path="productName"></form:errors></td>
        
    </tr>
    
      
    <tr>
    	 <td><form:label path="productDescription">Product Description</form:label></td>
        <td><form:input path="productDescription" /></td>
        <td><form:errors path="productDescription"></form:errors></td>
    </tr>
    
      
    <tr>
        <td><form:label path="productQuantity">Product Quantity</form:label></td>
        <td><form:input path="productQuantity" /></td>
    </tr>
    
      
    <tr>
        <td><form:label path="productDiscount">Product Discount</form:label></td>
        <td><form:input path="productDiscount" /></td>
    </tr>
    
     <tr>
          <td><form:input path="productPrice" /></td>
    </tr>
   
    <tr>
      <td> <form:label path="productImage">Product Image</form:label></td>
     <td> <form:input path="productImage" type="file" name="file"></form:input></td>
    
    </tr>
</table>  
<br>

Category <form:select path="category.categoryName" items ="${categoryList}" itemValue="categoryName" itemLabel="categoryName"></form:select>
Subcategory <form:select path="subcategory.subcategoryName" items ="${subcategoryList}" itemValue="subcategoryName" itemLabel="subcategoryName"></form:select>
Brand <form:select path="brand.brandName" items ="${brandList}" itemValue="brandName" itemLabel="brandName"></form:select>
Supplier <form:select path="supplier.SupplierName" items ="${supplierList}" itemValue="SupplierName" itemLabel="SupplierName"></form:select><br>


<br>
 <tr>
    <td colspan="2">
            <input type="submit" value="addProduct"/>
        </td>
    </tr>
    

</form:form>
<br>

<h3>Product List</h3>  

    <table >    
    <tr>  
        <th>Product Id</th>  
        <th>Product Name</th>  
        <th>Product Description</th>  
        <th>Product Quantity</th>  
        <th>Product Discount</th>  
        <th>Product Price</th> 
        <th>Edit</th>  
        <th>Delete</th>  
        
         
    </tr>  
    
        <tr ng-repeat="plist in jsonData|orderBy:sortType:sortReverse|filter:searchBrand"> 
         
            <td>{{plist.productId}}</td>  
            <td>{{plist.productName}}</td>  
            <td>{{plist.productDescription}}</td>
            <td>{{plist.productQuantity}}</td>
            <td>{{plist.productDiscount}}</td>
            <td>{{plist.productPrice}}</td>
    
            <td><a href="editProduct-{{plist.productId}}">Edit</a></td>  
            <td><a href="deleteProduct-{{plist.productId}}">Delete</a></td> 
</tr>  
 
 
    </table> 
 <script type="text/javascript" src="resources/angular.min.js"></script>
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myCtrl",function ($scope){
    	$scope.jsonData=${productList};
    });
    </script>

</body>
