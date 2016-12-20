<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<div ng-app="app" ng-controller="myCtrl">
<div class="alert alert-info">
<input type="text" placeholder="Search the subcategory" ng-model="searchSubcategory">
</div>

<div align="center">
<form:form modelAttribute="subcategory" action="addSubcategory">


<form:label  path="subcategoryId">Subcategory Id</form:label>
<form:input path="subcategoryId"/>

<form:label  path="subcategoryName">Subcategory Name</form:label>
<form:input path="subcategoryName"/>

<form:label  path="subcategoryDescription">Subcategory Description </form:label>
<form:input path="subcategoryDescription"/>

<form:select path="category.categoryName" items ="${categoryList}" itemValue="categoryName" itemLabel="categoryName">

</form:select>
<input type="submit" value="Submit"/>

</form:form>
</div>
  
  
  <br>
<h3>Subcategory List</h3>  

       
    <tr>  
        <th>Subcategory Id</th>  
        <th>Subcategory Name</th>  
        <th>Subcategory Description</th>
        <th>Edit</th>  
        <th>Delete</th>  
        
         
    </tr>  
    
        <tr ng-repeat="slist in jsonData|orderBy:sortType:sortReverse|filter:searchBrand"]>  
        
            <td>{{slist.subcategoryId}}</td>  
            <td>{{slist.subcategoryName}}</td>  
             <td>{{slist.subcategoryDescription}}</td> 
            <td><a href="editSubcategory-{{slist.subcategoryId}}">Edit</a></td>  
            <td><a href="deleteSubcategory-{{slist.subcategoryId}}">Delete</a></td> 
</tr>  
 
 
    </table> 
    <script type="text/javascript" src="resources/angular.min.js"></script>
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myCtrl",function ($scope){
    	
    	$scope.jsonData=${subcategoryList};
    });
    </script>
  
</body>
</html>