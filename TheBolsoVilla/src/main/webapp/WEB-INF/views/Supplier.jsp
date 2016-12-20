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
<h2>Supplier</h2>

<div ng-app="app" ng-controller="myCtrl">
<div class="alert alert-info">
<input type="text" placeholder="Search the supplier" ng-model="searchSupplier">
</div>

<form:form method="POST" modelAttribute="supplier" action="addSupplier">
   <table>
    <tr>
        <td><form:label  path="SupplierId">Supplier Id</form:label></td>
        <td><form:input  path="SupplierId"/></td>
    </tr>
   
   
    <tr>
        <td><form:label path="SupplierName">Supplier Name</form:label></td>
        <td><form:input path="SupplierName" /></td>
    </tr>
    <tr>
        <td><form:label path="SupplierContact"> Supplier Contact</form:label></td>
        <td><form:input path="SupplierContact" /></td>
    </tr>
     <tr>
        <td><form:label path="SupplierAddress"> Supplier Address</form:label></td>
        <td><form:input path="SupplierAddress" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="addSupplier"/>
        </td>
    </tr>
</table>  
</form:form>

<br>
<h3>Supplier List</h3>  

    
    <tr>  
        <th>Supplier Id</th>  
        <th>Supplier Name</th>  
        <th>Supplier Contact</th>
         <th>Supplier Address</th>  
        <th>Edit</th>  
        <th>Delete</th>  
        
         
    </tr>  
   
    <tr ng-repeat="slist in jsonData|orderBy:sortType:sortReverse|filter:searchBrand">
    
            <td>{{slist.SupplierId}}</td>  
            <td>{{slist.SupplierName}}</td>  
            <td>{{slist.SupplierContact}}</td>  
            <td>{{slist.SupplierAddress}}</td>  
            <td><a href="editSupplier-{{slist.SupplierId}}">Edit</a></td>  
            <td><a href="deleteSupplier-{{slist.SupplierId}}">Delete</a></td> 
        </tr>  
           
       </table> 
<script type="text/javascript" src="resources/angular.min.js"></script>
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myCtrl",function ($scope){
    	
    	$scope.jsonData=${supplierList};
    });
    </script>

</body>
</html>