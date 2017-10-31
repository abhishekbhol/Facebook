<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fill Out Info</title>
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
<style type="text/css">
	#body{
		width: 100%;
	}
	#sidebar{
		width: 0%;
		height: 100%;
	}
</style>
</head>
<body>

<div class="header" style="width:55%;height:50px; margin-left:22%;margin-top:7% ;background-color:rgb(231,233,239);" >
     
       <div style="margin-left: 10px; float: left;"><b>&nbsp;&nbsp;&nbsp;&nbsp;Step 1</b><br>&nbsp;&nbsp;Fill out info</div>
       <div style="margin-left: 30px; float: left; background-color:white;height: 50px; width: 1px;"></div>
       <div style="margin-left: 30px;  float: left; color:white; " ><b>Step 2</b><br>Add profile pic</div>
       <div style="margin-left: 30px; float: left; background-color:white;height: 50px; width: 1px;"></div>
       
      </div>
      
      
      
 <div class="jumbotron" style="width:55%;height:305px;margin-top:1%;margin-left:22%  ">
     <!--     <h1>Jumbotron heading</h1>
        <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">Sign up today</a></p>
        -->
        <div style="font-size:15px;font-weight: bold; " >Fill out your profile info</div>
        <div style="font-size:12px; padding-bottom:3px ">This information will help you find your friends on Facebook.</div>
    
        <form action=/Facebook/module02/filloutinfo class="form-horizontal" role="form">
      
      <div class="form-group" style=" margin-bottom:2px " >  
       <label  class="col-sm-2 control-label" style="font-size:12px ;margin-top: 5px;"> High School</label>          <div class="col-sm-10"><input type="text" class="form-control" name="highschool" style="width: 50%;font-size:12px; " placeholder="High School Name"></div>
      </div>
      
      <div class="form-group" style=" margin-bottom:2px ">
       <label  class="col-sm-2 control-label" style="font-size: 12px;margin-top: 5px;"> College</label>    <div class="col-sm-10">  <input type="text" class="form-control" name="college" style="width: 50%;font-size:12px; " placeholder="College or University Name"></div>
       </div>
        
      <div class="form-group" style=" margin-bottom:2px ">
        <label  class="col-sm-2 control-label" style="font-size: 12px;margin-top: 5px;">Employer</label>         <div class="col-sm-10">  <input type="text" class="form-control" name="companyname" style="width: 50%;font-size:12px; " placeholder="Company Name"></div>
		</div>
		
		<div class="form-group" style=" margin-bottom:2px ">   
       <label  class="col-sm-2 control-label" style="font-size: 12px;margin-top: 5px;"> Current City</label>     <div class="col-sm-10"> <input type="text" class="form-control" name="currentcity" style="width: 50%;font-size:12px; " placeholder="Current City"></div>
      </div>
      
      <div class="form-group" style=" margin-bottom:2px ">
       <label  class="col-sm-2 control-label" style="font-size: 12px;margin-top: 5px;"> Hometown </label>         <div class="col-sm-10"> <input type="text" class="form-control" name="hometown" style="width: 50%;font-size:12px; " placeholder="Hometown"></div>
      </div>
      
      <div></div><br>
      	<div style="margin-left: 75%;"> 
 			<a href="Facebook/module02/skipstep1" style="color:rgb(68,96,156);">skip</a> &nbsp; &nbsp;<button type="submit"  class="btn btn-primary btn-xs">Save & Continue</button>
 		</div>
        </form>
       
       <br><br> 
     <div align="left">Your schools and employer are currently public to help you connect with classmates and coworkers. You can<br> manage the privacy of your schools and employers by editing your About section.</div>        
      </div>     
  
</body>
</html>