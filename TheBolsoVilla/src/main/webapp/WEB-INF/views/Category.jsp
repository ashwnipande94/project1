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
<h2>Category</h2>

<div ng-app="app" ng-controller="myCtrl">
<div class="alert alert-info">
<input type="text" placeholder="Search the category" ng-model="searchCategory">
</div>


<form:form method="POST" modelAttribute="category" action="addCategory" enctype="multipart/form-data">
   <table>
    <tr>
        <td><form:label  path="categoryId">Category Id</form:label></td>
        <td><form:input  path="categoryId"/></td>
    </tr>
   
   
    <tr>
        <td><form:label path="categoryName">Category Name</form:label></td>
        <td><form:input path="categoryName" /></td>
        <td><form:errors path="categoryName"></form:errors></td>
    </tr>
    <tr>
        <td><form:label path="categoryDescription">Category Description</form:label></td>
        <td><form:input path="categoryDescription" /></td>
        <td><form:errors path="categoryDescription"></form:errors></td>
    </tr>
    
    
    
    <tr>
        <td colspan="2">
            <input type="submit" value="addCategory"/>
        </td>
    </tr>
</table>  
</form:form>

<br>
<h3>Category List</h3>  
<table>
    <tr>  
        <th>Category Id</th>  
        <th>Category Name</th>  
        <th>Category Description</th>  
        <th>Edit</th>  
        <th>Delete</th>  
        
         
    </tr>  
     
        <tr ng-repeat="clist in jsonData|orderBy:sortType:sortReverse|filter:searchBrand">  
            <td>{{clist.categoryId}}</td>  
            <td>{{clist.categoryName}}</td>  
            <td>{{clist.categoryDescription}}</td>  
            <td><a href="editCategory-{{clist.categoryId}}">Edit</a></td>  
            <td><a href="deleteCategory-{{clist.categoryId}}">Delete</a></td> 
</tr>  

 
    </table> 
    <script type="text/javascript" src="resources/angular.min.js"></script>
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myCtrl",function ($scope){
    	$scope.sortType      = 'categoryName';
    	$scope.sortReverse   = false;
    	$scope.searchCategory  ='';
   $scope.jsonData=${categoryList};
    });

  </script>


</body>
</html>