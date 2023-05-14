<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach etc. -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- Formatting (dates) -->
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!-- form:form -->
            <%@ taglib prefix="form"
                uri="http://www.springframework.org/tags/form"%>
                <!-- for rendering errors on PUT routes -->
                <%@ page isErrorPage="true" %>
                    <!DOCTYPE html>
                    <html>
                        <head>
                            <meta charset="UTF-8">
                            <title>Login | Register</title>
                            <link rel="stylesheet"
                                href="/webjars/bootstrap/css/bootstrap.min.css">
                            <script
                                src="/webjars/bootstrap/js/bootstrap.min.js"></script>
                        </head>
                        <body class="bg-dark text-light">
                            <div class="container w-100">
                                <h1 class="h1 text-center my-3">Welcome!</h1>
                                <p class="text-center mb-3">Join our growing community</p>
                                <div class="row  d-flex justify-content-evenly">
                                <div class="col-4">
                                    <h3 class="text-center h3 my-3">Register</h3>
                                    <form:form action="/register" method="post" modelAttribute="newUser" class="">
                                        <div class="d-grid mb-3">
                                            <form:label path="username" class="form-label">User Name</form:label>
                                            <form:input path="username" class="form-control"/>
                                        </div>
                                        <div class="d-grid mb-3 ">
                                            <form:label path="email" class="form-label">Email</form:label>
                                            <form:input path="email" class="form-control"/>
                                        </div>
                                        <div class="d-grid mb-3">
                                            <form:label path="password" class="form-label">Password</form:label>
                                            <form:input path="password" class="form-control" type="password" />
                                        </div>
                                        <div class="d-grid mb-3">
                                            <form:label path="confirmPassword" class="form-label">Confirm PW</form:label>
                                            <form:input type="password" path="confirmPassword" class="form-control"/>
                                        </div>
                                        <div class="d-grid mb-3">
                                            <input type="submit" value="Submit" class="btn btn-primary"/>
                                        </div>
                                        <div  class="d-grid">
                                            <form:errors path="username" class="alert alert-danger"/>
                                            <form:errors path="email" class="alert alert-danger"/>
                                            <form:errors path="password" class="alert alert-danger"/>
                                            <form:errors path="confirmPassword" class="alert alert-danger"/>
                                        </div>
                                    </form:form>
                                </div>
                                <div class="col-4">
                                    <h3 class="text-center h3 my-3">Log in</h3>
                                    <form:form action="/login" method="post" modelAttribute="newLogin" class="">
                                        <div class="d-grid mb-3 ">
                                            <form:label path="email" class="form-label">Email</form:label>
                                            <form:input path="email" class="form-control"/>
                                        </div>
                                        <div class="d-grid mb-3">
                                            <form:label path="password" class="form-label">Password</form:label>
                                            <form:input path="password" class="form-control" type="password" />
                                        </div>
                                        <div class="d-grid mb-3 ">
                                            <input type="submit" value="Submit" class="btn btn-primary"/>
                                        </div>
                                        <div  class="d-grid">
                                            <form:errors path="email" class="alert alert-danger"/>
                                            <form:errors path="password" class="alert alert-danger"/>
                                        </div>
                                    </form:form>
                                </div>
                                </div>
                            </div>
                        </body>
                    </html>