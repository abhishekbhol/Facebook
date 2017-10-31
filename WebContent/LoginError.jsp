<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>

<link href="/Facebook/asset/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap.css" rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap.min.css" rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap-theme.css.map"
	rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap.css.map" rel="stylesheet" />
<link href="/Facebook/asset/css/login_home.css" rel="stylesheet" />
</head>
<body>
<div style="min-height: 100px;"></div>
	<div style="height:400px;width:50%; border: 1px solid; border-color: rgb(204, 204, 204);  margin-left: 25%; ">
		<div style="font-weight: bold; font-size: 16px;margin-left: 2%;margin-top: 2%; ">
		Facebook Login
		</div>
		<hr style="width:96%;">
		<div id="errormessageid" style="height: 100px;width:90%; margin-top:3%; margin-left:5%; border: 1px solid;" class="alert alert-danger">
		<p style="font-weight: bold; color: black;">Please re-enter your Email or Password</p>
		<p style="font-style:normal; font-size: 12px; color:black; ;">The password you entered is incorrect. Please try again (make sure your caps lock is off).<br>
			Forgot your password? Request a new one.	</p>
		</div>
		
		
		<form action="/Facebook/module02/userLogin">
		<div>
		<p style="font-weight: bold; font-size: 11px; float: left; margin-left:27%; ">Username : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
		<input type="text" name="userName" style="height:20px; " required="true">
		</div>
		
		<div style="margin-top: 3%; ">
		<p style="font-weight: bold; font-size: 11px; float: left; margin-left: 27%;">Password :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
		<div><input type="password" name="password" style="height:20px; " required="true"></div>
		</div>	
		
		<div style="margin-top:3%; margin-left: 35%;">
		<input type="submit" value="Log In" style="background-color: rgb(97, 122, 172); font-weight: bold; color: white; font-size: 12px;"> or 
		<a href="/Facebook/module02/redirectLogin" style="font-size: 12px;"> Sign up for Facebook</a>
		</div><br>
		<a href="/Facebook/module02/forgotPassword" style="font-size:12px;margin-left: 40%;  ">Forgot Your Password?</a>
		</form>
	</div>
</body>
</html>