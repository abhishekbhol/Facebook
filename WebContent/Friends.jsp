<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/Facebook/asset/js/jquery-2.1.0.js">
</script>
<script type="text/javascript">
var temp="<h4>";
$(document).ready(function(){
	
	$("#searchfriend").onchange(function(){
	
		$.ajax(function(){
			
		});
	});
	
});


</script>
<link href="/Facebook/asset/css/login_home.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
	
	<div id="friendheader" style="height:90px;width:100%; background-color:rgb(246, 247, 248); border:1px solid; border-color: rgb(211, 214, 219); " >
	<img src="/Facebook/asset/images/fr_icon.png"  style="height:25px;width:3.5%; margin-left:1%; margin-top: 1%; float: left; " />
	 <a href="/Facebook/module02/displayfriends"><div style="float:left; margin-top: 1%; margin-left: 1%; font-weight: bold; font-size: 20px; color: rgb(55, 64, 78);">Friends</div></a>
	
<!-- 	<div class="btn-group" style="float: right; margin-right: 2%;margin-top: 1.5%;" > 
	<button type="button" class="btn btn-default" style=" font-size: 12px; font-weight: bold;">Friend Requests<div></div></button>
	 <button type="button" class="btn btn-default" style=" font-size: 12px; font-weight: bold;">+ Find Friends</button>
	</div>
 -->	

	<div style="width:25%; height: 40px; margin-top:7%;margin-left:-13%; float: left; font-weight: bold; color: rgb(55, 64, 78);">All Friends &nbsp;<s:property value="numberoffriends" /> </div>
	
	
	<!-- <div >
	<input type="text" id="searchfriend" name="searchfriend" style="float:left; margin-top:-5.5%; margin-left: 67%; height: 22px; width:28%; font-size: 12px;" placeholder = "Search Your Friends" >
	<a href="searchfriend"><div style="height: 22px;width: 22px; border: 1px solid; float: right; border-color: rgb(173, 179, 188); margin-top:-45px; margin-right:18px;"><img src="/Facebook/asset/images/search.jpg" /></div></a>
	</div> -->
 	</div>
	
	
	
	
	
	
	
	
	
	
	<div id="friendsdisplay" style=" width:100%; border: 1px solid; border-color: rgb(211, 214, 219); overflow: hidden;">
	<%! int i=1; %>
	<s:iterator value="allfriends">
	
		<%
		if(i%2==0)
		{
			i++;
		%>
		<div
			style="height: 110px; width: 47%; border: 1px solid; border-color: rgb(211, 214, 219); margin-top: 2%; margin-left: 2%; float: left;">
			<div style="height: 110px; width: 100px; float: left;">
				<a href='/Facebook/module02/loadProfilePage?profileId=<s:property value="profile_id" />'><img src="<s:property value="friendprofilepic" />"
					style="height: 108px; width: 100px;" /></a>
			</div>
			<div style="margin-top: 10%;">
			
				<s:url action="/Facebook/module02/loadProfilePage" var="friendurl">
					<s:param name="profileId"><s:property value="profile_id" /></s:param>
				</s:url>
				<s:a href="%{friendurl}"
					style="color: rgb(59, 89, 152); font-size: 12px; font-weight: bold; margin-left: 5%;"><s:property value="fname" /> <s:property value="lname" /></s:a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="btn-group">
					<button disabled="disabled" type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown"
						style="height: 27px; font-size: 12px; font-weight: bold">
						Friend 
					</button>
					<!-- <ul class="dropdown-menu" role="menu">
						<li><a href="#">Report/Block....</a></li>
						<li><a href="#">Unfriend</a></li>
					</ul> -->
				</div>
				
			</div>
		</div>

	<%
	}
		
		else{	
			i++;
	%>


		<div
			style="float: right; height: 110px; width: 47%; border: 1px solid; border-color: rgb(211, 214, 219); margin-top: 2%; margin-right: 2%">
			<div style="height: 110px; width: 100px;">
				<a href="#"><img src="<s:property value="friendprofilepic" />"
					style="height: 108px; width: 100px;" /></a>
			</div>

			<div align="right" style="margin-top: -19%; margin-right:8%; ">
				<s:url action="/Facebook/module02/loadProfilePage" var="friendurl">
					<s:param name="profileId"><s:property value="profile_id" /></s:param>
				</s:url>
				<s:a href="%{friendurl}"
					style="color: rgb(59, 89, 152); font-size: 12px; font-weight: bold;"> <s:property value="fname" /> <s:property value="lname" /> </s:a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;
				<div class="btn-group" align="left">
					<button disabled="disabled" type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown"
						style="height: 27px; font-size: 12px; font-weight: bold">
						Friend 
					</button>
	<!-- 				<ul class="dropdown-menu" role="menu">

						<li><a href="#">Report/Block....</a></li>
						<li><a href="#">Unfriend</a></li>
					</ul> -->
				</div>

			</div>
		</div>

	<%
	}
		%>
	</s:iterator>

	</div>	
</body>
</html>