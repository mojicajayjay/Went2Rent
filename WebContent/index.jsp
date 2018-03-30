<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<a href="cata" class="navbar-brand">PahiramKotse</a>
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
				<c:choose>
					<c:when test = "${not empty sessionScope.admin}">
						<li><a href="admin.jsp">Admin mode</a></li>
					</c:when>
					<c:otherwise>
						
					</c:otherwise>
				</c:choose>
				<li><a href="logout">Logout</a></li>
			</c:otherwise>
		</c:choose>
		</ul>
		</div>
	</nav>

	<div class="container">
	<div class="jumbotron">
		<h1>PahiramKotse</h1>
		<p>Choose the right vehicle for you in an affordable price!</p>
	</div>
		<div class="minitron" id="catalogue">
			<c:forEach items="${sessionScope.products}" var="product">
				<c:out value="${product.car_name}"/>
				<c:out value="${product.car_platenumber}"/>
				<c:out value="${product.car_color}"/>
				<img src="<c:out value="${product.path}"/>"/>
			</c:forEach>
		</div>
	</div>
</body>
</html>