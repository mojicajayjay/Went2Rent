<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Pahiram Kotse</title>
	<link rel="stylesheet" type="text/css" href="style.css">
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
		<ul class="nav navbar-nav navbar-right">
		<c:choose>
			<c:when test = "${empty sessionScope.sessionuser}" >
				<li><a href="register.jsp">Sign up</a></li>
				<li><a href="login.jsp">Login</a></li>
			</c:when>
			<c:otherwise>
				<li><c:out value = '${sessionScope.sessionuser.username}'/></li>
				<li><a href="logout">Logout</a></li>
			</c:otherwise>
		</c:choose>
		</ul>
		</div>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<h2>Pahiram Kotse</h2>
			<p>is a site where you can rent a vehicle for a set amount of time. There are a lot of vehicles to choose from. blablablabal</p>
		</div>
	</div>
</body>
</html>