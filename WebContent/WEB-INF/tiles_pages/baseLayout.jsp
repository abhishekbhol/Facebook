<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/Facebook/asset/js/jquery-2.1.0.js"></script>
<script src="/Facebook/asset/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link href="/Facebook/asset/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap-theme.min.css"
	rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap.css" rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap.min.css" rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap-theme.css.map"
	rel="stylesheet" />
<link href="/Facebook/asset/css/bootstrap.css.map" rel="stylesheet" />

<style type="text/css">
body{
	background-color: #E9EAED;
}
#container {
	position: relative;
	float: left;
	width: 100%;
	margin-top: 2%;
	margin-left: 5%;
}

#body {
	float: left;
	width: 60%;
	height: 100%;
}

#sidebar {
	margin-top: 1%;
	float: left;
	width: 22%;
	height: 200px;
	min-height: 20px;
	padding: 8px 0px 0px 0px;
	margin-bottom: 20px;
	background-color: white;
	border: 1px solid #e3e3e3;
	border-radius: 2px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .05);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .05)
}

#footer {
	margin-left: 5%;
}
</style>

</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="container">

		<div id="body">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="sidebar">
			<tiles:insertAttribute name="menu" />
		</div>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>