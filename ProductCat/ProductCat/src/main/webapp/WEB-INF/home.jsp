<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<p><a href="/products/new">New Product</a></p>
<p><a href="/category/new">New Category </a></p>
<div class="d-flex flexrow">
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Product</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
   <c:forEach var="pro" items="${product}">
   <tr>

   <td><a href="/products/new/${pro.id}"><c:out value="${pro.name}"/> </a></td>

    </tr>
    </c:forEach>
  </tbody>
</table>
<table class="table table-bordered" >
  <thead>
    <tr>
      <th scope="col">Category</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
  <c:forEach var="cat" items="${category}">
   <tr>
 
  <td><a href="/category/new/${cat.id}"><c:out value="${cat.name}"/> </a> </td>


    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</body>
</html>