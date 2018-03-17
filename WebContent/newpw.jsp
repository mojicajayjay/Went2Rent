<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Register</title>
	<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
		<div class="navbar-header">
			<a href="index.jsp" class="navbar-brand">PahiramKotse</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="about.jsp">About us</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
		</div>
	</nav>
<div class="header">
	<h2>Register</h2>
</div>
<form method="post" action="reset">
	<c:choose>
		<c:when test = "${not empty sessionScope.sessionname}">
			<input type="hidden" name = "username" value = <c:out value = '${sessionScope.sessionname.username}'/>>
		</c:when>
		<c:otherwise>
			<li> No user in database! </li>
		</c:otherwise>
	</c:choose>
	<div class="input-group">
		<label>Password</label>
		<input type="password" name="pword_1">
	</div>
	<div class="input-group">
		<label>Confirm password</label>
		<input type="password" name="pword_2">
	</div>
	<div class="input-group">
		<button type="submit" class="btn" name="register">Reset Password</button>
	</div>
</form>
</body>
</html>