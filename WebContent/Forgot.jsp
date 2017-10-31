<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password?</title>
</head>
<body>
<div style="min-height: 100px;"></div>
<div style="border: 1px solid; color:rgb(204,204,204); height:285px; width:35%; margin-left: 32%;"  > 
	<div style="margin-left: 3%;margin-top:3%; color: black; font-weight:bold ; height:15px; width:35%;">
	Find Your Account
	</div>
	<hr style= "color: black; margin-left:5%; margin-right:5%; ">
	<form action="/Facebook/module02/sendEmail">
	
	<p align="center" style="font-size:x-small; color: black;">Email, Phone, Username or Full Name</p>	
	   
	 <div align="center" style="color: black; font-size:12px; ">Email: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" style="color: rgb(204,204,204); width:50%;" ></div><br>
	 
	 <div align="center" style="color: black; font-size:12px; ">Username: &nbsp;<input type="text" name="userName" style="color: rgb(204,204,204); width:50%;" ></div>
	 
	 <div align="center" style="color: black; font-size:12px; margin-top:4%;  "><s:property value="status" /></div>
	
	<div style="margin-bottom:0%; margin-top:18%; background-color: rgb(242, 242, 242); height:36px; width:90% ; border-top: 1px solid; float: left; ">
	<div style="float: left; margin-top: 1.5%; margin-left: 80%;"> <input type="submit" value="Send Email"  style="width:95%; height:20px; color: white; font-size:x-small; font-weight:bold; background-color: rgb(98, 122, 172); margin-left:5%;"/></div>
	</div>
	</form>	
	
	<form action="/Facebook/module02/redirectLogin">
	<div style="margin-bottom:0%; margin-top:18%; background-color: rgb(242, 242, 242); height:36px; width:10% ; border-top: 1px solid; float: right;">
	<div style="float: right; margin-right:6%; margin-top: 1.5%;"><input type="submit" value="Cancel"  style="width:95%; height:20px; color:black; ; font-size:x-small; font-weight:bold; background-color: rgb(232,232,232); margin-top: 6px;"/> </div>
	</div>
	</form>

</div>

</body>
</html>