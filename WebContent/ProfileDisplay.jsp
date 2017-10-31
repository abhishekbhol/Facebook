<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Profile Display </title>

<link rel="stylesheet" type="text/css" href="/Facebook/asset/css/ProfileDisplay.css">
</head>


<body>

<div id="container" style="  width:1200px;">
<div id="about">

<img src="/Facebook/asset/images/person_image.png" style="padding-left: 30px;padding-top: 30px; width:30px; height:30px; float:left" /> 
<h2 class ="lable"><a href="C:/Users/Divya M/git/fb/Facebook/WebContent/Profile.html">About</a></h2>
<input type="button" value="Edit" class="button"/> 
</div>

<div id="work_education">

<form action="edit_workeduction">

<h3  class ="lable" > <label style="font-weight:bold">Work and Education</label></h3>
<input type="button"  class="button" value="Edit"/>

<s:iterator value="listofeducationdetails">
<h4  class="data" ><s:property value="workeducation_title"/>  </h4>
<h6  class="data" > <s:property value="description"/> </h6>

</s:iterator>


</form>


</div>

<div id="placeslived">

<h3 class ="lable"> Places Lived</h3>
 <input type="button" class="button"  value="Edit"/>

<h4 class="data">Jaipur</h4>

<h4 class="data">Bangalore</h4>

</div>

<div id="relationship">

<h3 class ="lable"> Relationship</h3>
 <input type="button" value="Edit"  class="button" >

<img src="/Facebook/asset/images/placeholder-relationship.png" style="margin-left:0px;margin-top: 100px; float:left; width:40px ;height:60px;" /> 

<h4 class="data">Single</h4>


</div>

<div id="basicinfo">

<h3 class ="lable">Basic Information</h3>
<input type="button"  class="button" value="Edit"/>

<h4 class="data">Birth Date</h4>

<h4 class="data">Language</h4>
</div>

<div id="aboutme">

<h3 class ="lable">About You</h3>
 <input type="button" value="Edit" class="button"/>
<h4 class="data">I believe in  HardWork and Blessings.</h4>

</div>

<div id="favquote">
<h3 class ="lable">Favourite Quotations</h3>
<input type="button" value="Edit" class="button"/>
<h4 class="data">If you can dream it, You can do it.</h4>



</div>

<div id="contactinfo">

<h3 class ="lable">Contact Information</h3>
 <input type="button"  class="button" value="Edit"/>

<h4 class="data">Email</h4>

<h4 class="data">PhoneNumber</h4>
</div>

</div>

</body>
</html> 

