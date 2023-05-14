<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${book.title}</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="d-flex w-100 justify-content-between my-3">
  <h1> ${book.title}</h1>
  <a href="/books" class="btn btn-danger">Back to shelves</a>
</div>
<div class="">
  <h3> ${book.postedBy.username} read ${book.title} by ${book.author}</h3>
  <h4>here are ${book.postedBy.username} Thoughts</h4>
</div>
<div class="d-flex w-100 justify-content-between my-3">
  <p>${book.thoughts}</p>
</div>

<c:if test = "${loggedUserId == book.postedBy.id}">
  <div class="d-flex w-100 justify-content-end gap-3 my-3">
    <a href="/books/${book.id}/edit" class="btn btn-dark">Edit</a>
    <a href="/books/${book.id}/delete" class="btn btn-danger">Delete</a>
  </div>
</c:if>




</body>
</html>