<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Went2Rent - Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div class="header">
		<h2>Login</h2>
		<h5>${message}</h5>
		<h5>${successMessage}</h5>
	</div>
	<form action="loginRegister" method="post">
		<div class="input-group">
			<label>Username</label>
			<input type="text" name="uname" >
		</div>
		<div class="input-group">
			<label>Password</label>
			<input type="password" name="pword_1">
		</div>
		<div class="input-group">
			<button type="submit" class="btn" name="login_btn" value="login">Login</button>
		</div>
		
		<p>
			Not yet a member? <a href="register.jsp">Sign up</a>
		</p>
	</form>
</body>
</html>