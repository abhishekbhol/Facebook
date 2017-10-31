<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/Facebook/WebContent/asset/js/jquery-2.1.0.js"/>
<script>

</script>
<meta http-equiv="Content-rel" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
	<form action="/Facebook/module02/signup">
	<div class="body_login" id="body_login">

		<div class="body_login_signup">
			<p id="create_account">Sign Up</p>
			<p id="punch_line">It's free and always will be.</p>
			<input type="text" placeholder="First Name" required="true" name="fname" id="fname" class="details" />
			<input type="text" placeholder="Last Name"  required="true" name="lname" id="lname" class="details" /><br> 
			<input type="email" placeholder="Your Email" required="true" name="email" id="email" class="details" /><br> 
			<input type="email" placeholder="Re-enter Email" required="true" name="reemail" id="reemail" class="details" /><br> 
			<input type="password" placeholder="New Password" required="true" name="password" id="pwd" class="details" /><br>

			<p id="birthday" style="font-weight: bold;">Birthday</p>
			<s:select theme="simple" list="monthList" id="month" name="month" required="true" headerKey="0" headerValue="Month">
			</s:select> 
			<s:select theme="simple" list="dayList" id="day" name="day" required="true" headerKey="0" headerValue="Day">
			</s:select>
			 <s:select theme="simple" list="yearList" id="year" name="year" required="true" headerKey="0" headerValue="Year">
				
			</s:select><br>
			<h4>
				<input type="radio" name="gender" value="male" required="true"/>&nbsp;&nbsp;Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input	type="radio" name="gender" value="female" required="true" />&nbsp;&nbsp;Female
			</h4>
			<p style="font-size: x-small;">
				By clicking Sign Up, you agree to our Terms and that you have<br>
				read our Data Use Policy, including our Cookie Use
			</p>
			<button type="submit" class="btn btn-lg btn-success">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sign Up
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button><br>
			<s:if test="%{errorstatus==null}">
			</s:if>
			<s:else>
			<div id="errormessageid" style="height: 50px;width: 400px; margin-top: 5px;font-size: x-small;" class="alert alert-danger">
			<s:property value="errorstatus"/>
			</div>
			</s:else>
		</div>
		<div class="body_login_left">
			<p id="help">
				Connect with friends and the <br>world around you on Facebook.
			</p><br><br><br>
			<p><img src="/Facebook/asset/images/home1.png" align="left"><h4 class="featurette-heading"/>&nbsp;&nbsp;&nbsp;See photos and updates <span class="text-muted">from friends in News Feed.</span></h4></p><br><br>
			<p><img src="/Facebook/asset/images/home2.png" align="left"><h4 class="featurette-heading">&nbsp;&nbsp;&nbsp;Share what's new  <span class="text-muted">in your life on your Timeline.</span></h4></p><br><br>
			<p><img src="/Facebook/asset/images/home3.png" align="left"><h4 class="featurette-heading">&nbsp;&nbsp;&nbsp;Find more  <span class="text-muted">of what you're looking for with Graph Search.</span></h4></p><br><br>
		</div>
	</div>
	</form>
</body>
</html>