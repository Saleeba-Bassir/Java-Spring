<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/handle" method="post">
	<p>pick any number from 5 to 25</p>
	<p><input type="number" name="number"></p>
	<p>Enter the Name of any City</p>
	<p><input type="text" name="city"></p>
	<p>Enter the name of any real person</p>
	<p><input type="text" name="name"></p>
	<p>Enter professional endeavor or hobby </p>
	<p><input type="text" name="hobby"></p>
	<p>Enter any type of living thing </p>
	<p><input type="text" name="creature"></p>
	<p>Say something nice to someone </p>
	<textarea name="compliment" rows="4" cols="50"></textarea>
	<p>Send and show a friend </p>
	<p><input type="submit" value="Send"></p>
	</form>
</body>
</html>