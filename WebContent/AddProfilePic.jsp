<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/Facebook/asset/js/jquery-2.1.0.js">
</script>

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
<style type="text/css">
	#body{
		width: 100%;
	}
	#sidebar{
		width: 0%;
		height: 100%;
	}
</style>
<title>Add Profile Pic</title>
</head>
<body>
	<div class="header"
		style="width: 55%; height: 50px; margin-left: 22%; margin-top: 7%; background-color: rgb(231, 233, 239);">
		<!--    <ul class="nav nav-pills pull-left" style="position: relative;float: left;" >
          <li class="active" style="margin-left: 10px;" >Step 1<br>Fill out info</li>
          
          <li class="active" style="margin-left: 30px;">Step 2<br> Choose interests</li>
          <li class="active" style="margin-left: 30px;">Step 3 <br> Add profile pic</li>
        </ul>
       -->
		<div style="margin-left: 10px; float: left; color: white;">
			<b>&nbsp;&nbsp;&nbsp;&nbsp;Step 1</b><br>&nbsp;&nbsp;Fill out
			info
		</div>
		
		<div style="margin-left: 30px; float: left; background-color: white; height: 50px; width: 1px;"></div>
		<div style="margin-left: 30px; float: left;">
			<b>Step 2</b><br>Add profile pic
		</div>
		
		<div style="margin-left: 30px; float: left; background-color: white; height: 50px; width: 1px;"></div>
	</div>



	<div class="jumbotron"
		style="width: 55%; height: 305px; margin-top: 1%; margin-left: 22%">
		
		<div style="font-size: 15px; font-weight: bold;">Set your
			profile picture</div>
		<br>

		<form id="uploadform" action="/Facebook/module02/addprofilepic" method="post" enctype="multipart/form-data">
		<div  class="fileinput fileinput-new" data-provides="fileinput" align="center"	style="height: 70%; width: 30%; margin-left: 17%; float: left;" >

			 <div id="preview" class="fileinput-preview thumbnail"  data-trigger="fileinput" style="width: 200px; height: 150px;">
			 	<img id="thumb" src="\Facebook\asset\images\newuser.png" 
				style="width: 100%; height: 100%;">
			 </div>
			
		</div>
		
		
		
		<div style="height: 70%; width: 30%; margin-left: 17%; float: right;">
			<div
			       	style="font-size: 15px; font-weight: bold; height: 5%; color: rgb(68, 96, 156); margin-top: 17%;">
				    <br> 
				
					<input type="file" name="myFile" required="true" class="filestyle" data-input="false" id="filestyle-0" tabindex="-1" style="position: absolute; left: -9999px;" />
					<div class="bootstrap-filestyle" style="display: inline;" tabindex="0">
						<label for="filestyle-0" class="btn" ><i class="icon-folder-open"></i> Upload a Photo
						
						</label>
					</div>
			
			</div>
			<div style="margin-top: 0%; font-size: 12px">&nbsp;&nbsp;&nbsp;From your computer</div>
		</div>

		<s:property value="errorstatus" />
		<br>
		<div style="margin-top: 180px;">
			<a href="/Facebook/module02/backtostep1" style="color: rgb(68, 96, 156); position: fixed;">Back</a>
		
			<a href="skipstep2" style="color: rgb(68, 96, 156); margin-left: 75%;" >skip</a> &nbsp;
			&nbsp;
			<button type="submit" class="btn btn-primary btn-xs">Save & Continue</button>
		</div>


		<br> <br>
		<div align="left">Profile pictures and cover photos are public.
			You can control the audience for other photos you upload to Facebook.</div>
	</form>
	</div>
	
</body>
</html>