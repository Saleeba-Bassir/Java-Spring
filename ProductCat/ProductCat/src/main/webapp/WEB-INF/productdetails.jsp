<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <c:forEach var="cat" items="${pro1.categories}">
   <li><c:out value="${cat.name}"/></li>
</c:forEach>
         
<form:form action="/products/new/${pro1.id}" method="post">
    <p>
        
        <select name="category">
         <c:forEach var="nnn" items="${category}">
   <option value="${nnn.id}"><c:out value="${nnn.name}"/></option>
</c:forEach>

        </select>
    </p>
        <input type="submit" value="Add"/>
</form:form> 
</body>
</html>