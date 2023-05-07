<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<h2>Burger Tracker</h2>
	<table class="table container mx-auto mt-5 w-50">
		<thead>
			<tr>
				<th scope="col">Burger Name</th>
				<th scope="col">Resturant Name </th>
				<th scope="col">Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "burg" items="${burg}">
				<tr>
					<td> ${burg.burger_name}</td>
					<td> ${burg.restaurant_name}  </td>
					<td>${burg.rating}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

<h2>Add a Burger :</h2>
<form:form action="/burger" method="post" modelAttribute="burger">
  <p>
    <form:label path="burger_name">Burger name:</form:label>
    <form:errors path="burger_name"/>
    <form:input path="burger_name"/>
  </p>
  <p>
    <form:label path="restaurant_name">Restaurant name:</form:label>
    <form:errors path="restaurant_name"/>
    <form:input path="restaurant_name"/>
  </p>
  <p>
    <form:label path="rating">Rating:</form:label>
    <form:errors path="rating"/>
    <form:input path="rating" type="number" min="1" max="5"/>
  </p>
  <p>
    <form:label path="notes">Notes:</form:label>
    <form:errors path="notes"/>
    <form:textarea path="notes"/>
  </p>
  <input type="submit" value="Submit"/>
</form:form>

</body>
</html>