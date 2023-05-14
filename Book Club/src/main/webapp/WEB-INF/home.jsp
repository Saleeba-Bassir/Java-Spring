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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container-fluid p-4">
    <div class="d-flex w-100 justify-content-between my-3">
        <h1>Welcom, ${loggedUser}</h1>
        <a href="/logout" class="btn btn-danger">Log Out</a>
    </div>
    <div class="d-flex w-100 justify-content-between my-3">
        <h4>Books from everyone shelves:</h4>
        <a href="/addBook" class="btn btn-dark">Add to my shelve</a>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author name</th>
                <th>Posted By</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${allBooks}">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="./books/${book.id}">${book.title}</a></td>
                    <td>${book.author}</td>
                    <td>${book.postedBy.username}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>


</body>
</html>