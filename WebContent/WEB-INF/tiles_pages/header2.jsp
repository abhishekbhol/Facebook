<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="header2">
	<div id="fb_logo">
		<img alt="Facebook" width="175px" height="45px"
			src="/Facebook/asset/images/logo.png">
	</div>


	<div id="login_details">
		<p id="caption">Email or
			Phone&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Password</p>
		<form action="module02/userLogin">
		<input type="text" name="userName" size="19" id="uname" required="required"/>
		 <input	type="password" name="password" size="19" id="password" required="required"/> 
		<input type="submit" value="Log In" id="login_button" /><br>
		<div id="logged_in">
			<input type="checkbox" id="remember_me" name="logged_in" value="true">Keep
			me logged in
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/Facebook/module02/forgotPassword" style="color: rgb(152, 161, 187);">Forgot your password?</a>
		</div>	</form>

	</div>

</div>
