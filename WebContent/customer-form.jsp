<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CDN > Content Delivery Network -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<header style="color:white" >

      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
     <div class="container-fluid">
    <a class="navbar-brand" href="#">Customer Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          
           <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">Customers</a>
        </li>
        
       
      </ul>
      
    </div>
  </div>
</nav>

</header>
<br>

<c:if test="${customer == null}">
     <form action= "insert" method="post">

</c:if>

<c:if test="${customer != null}">
     <form action= "update" method="post">

</c:if>

<div class="container" style="width: 500px">

   <caption>
         <h2>
             <c:if test="${customer != null}">
              Edit User
              </c:if>
              
              <c:if test="${customer == null}">
              Add New User
              </c:if>            
         </h2>
  
   </caption>
   
   
   
   
      
   <div class="input-group flex-nowrap" hidden>
  
     <input type="number" class="form-control" value="<c:out value='${customer.id}'/>" name="tbId" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
  </div>
  </br>
   
   <div class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping" style="width: 130px">Name </span>
  <input type="text" class="form-control" value="<c:out value='${customer.name}'/>"  name="tbName" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
</div>
   <br>
   
   <div class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping" style="width: 130px">Email </span>
  <input type="email" class="form-control" value="<c:out value='${customer.email}'/>" name="tbEmail" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
</div>
   <br>
   <div class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping" style="width: 130px">Mobile </span>
  <input type="tel" class="form-control" value="<c:out value='${customer.mobile}'/>" name="tbMobile" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
</div>
<br>

<input type="submit" class="btn btn-secondary" value="Save"/>

   
   

</div>

</body>
</html>