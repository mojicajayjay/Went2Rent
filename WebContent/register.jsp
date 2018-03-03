<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Went2Rent - Register</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
		<div class="navbar-header">
			<a href="homepage.jsp" class="navbar-brand">WENT2RENT</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="aboutus.html">About us</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
		</div>
	</nav>
<div class="header">
	<h2>Register</h2>
</div>
<form method="post" action="loginRegister">
	<div class="input-group">
		<label>First Name</label>
		<input type="text" name="fname" value="">
	</div>
	<div class="input-group">
		<label>Last Name</label>
		<input type="text" name="lname" value="">
	</div>
	<div class="input-group">
		<label>Username</label>
		<input type="text" name="uname" value="">
	</div>
	<div class="input-group">
		<label>Email</label>
		<input type="email" name="email" value="">
	</div>
	<div class="input-group">
		<label>Password</label>
		<input type="password" name="pword_1">
	</div>
	<div class="input-group">
		<label>Confirm password</label>
		<input type="password" name="pword_2">
	</div>
	<div class="input-group">
		<button type="submit" class="btn" name="register">Register</button>
	</div>
	<p>
		Already a member? <a href="login.html">Sign in</a>
	</p>
</form>

</body>
</html>