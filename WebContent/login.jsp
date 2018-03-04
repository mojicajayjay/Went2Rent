<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Login to Pahiram Kotse</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand">PahiramKotse</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="aboutus.html">About us</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
		</div>
	</nav>
<div class="header">
		<h2>Login</h2>
	</div>
	<form action="Login">
		<div class="input-group">
			<label>Username</label>
			<input type="text" name="uname">
		</div>
		<div class="input-group">
			<label>Password</label>
			<input type="password" name="pword">
		</div>
		<div class="input-group">
			<button type="submit" class="btn" name="login_btn" value = "login">Login</button>
		</div>
		
		<p>
			Not yet a member? <a href="register.html">Sign up</a>
		</p>
	</form>
</body>
</html>