<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand">WENT2RENT</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="aboutus.html">About us</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="profile.jsp">${message}</a></li>
		</ul>
		</div>
	</nav>

	<div class="container">
	<div class="jumbotron">
		<h1>Hi ${message}!</h1>
		<h3>Welcome to Went2Rent!</h3>
		<p>Choose the right vehicle for you in an affordable price!</p>
	</div>

	<p>*Products here</p>
	</div>
</body>
</html>