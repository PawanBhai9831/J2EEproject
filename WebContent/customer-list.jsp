<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
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
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">Customer</a> 
        </li>
        
        
      </ul>
      
    </div>
  </div>
</nav>

</header>
<br>


<div class="container">
          <h2>List of User</h2>
          <hr>
          <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
          <br>
          <table class="table">
              <thead>
                  
                  <tr>
                  
                    <td scope="col">Id</td>
                    <td scope="col">Name</td>
                    <td scope="col">Email</td>
                    <td scope="col">Mobile</td>
                    <td scope="col">Action</td>
                  
                  </tr>
                 
              </thead>
              
              <tbody>
                 <!-- for(datatype variable : collection) -->
                 <!-- { -->
                      <c:forEach var="u" items="${listCustomer}">
                      <tr>
                          <td>
                              <c:out value="${u.id}"></c:out>
                          
                          </td>
                          <td>
                              <c:out value="${u.name}"></c:out>
                          
                          </td>
                          <td>
                              <c:out value="${u.email}"></c:out>
                          
                          </td>
                          <td>
                              <c:out value="${u.mobile}"></c:out>
                          
                          </td>
                          
                         
                        
                         <td>
                        
                            <a href="edit?id=<c:out value="${u.id}"></c:out>">Edit</a>
                            &nbsp; &nbsp; &nbsp; &nbsp;
                            
                            <!-- Query String -->
                            
                            <a href="delete?id=<c:out value="${u.id}"></c:out>">Delete</a>
                        
                         </td> 
                      
                 </tr>
                      
                      
                 </c:forEach>
                <!-- } -->
              
              </tbody>                    
          
          </table>
</div>

</body>
</html>