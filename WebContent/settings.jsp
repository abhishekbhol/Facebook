<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="/Facebook/asset/css/settings.css" rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
	
</script>
<script>
function nameshow() {
		
			$(".editname").toggle();
			$(".editname1").toggle();
			$(".editnameform").toggle();
			 document.getElementById("firstname").value="";
			 document.getElementById("lastname").value="";
			 $('#error').text("");	
			
	}
	
function usernameshow() {
	
	$(".editusername").toggle();
	$(".editusername1").toggle();
	$(".editusernameform").toggle();
	document.getElementById("username").value="";	
	$('#test').text("");	
}
function emailshow() {
	
	$(".editemail").toggle();
	$(".editemail1").toggle();
	$(".editemailform").toggle();
	document.getElementById("sec_email").value="";
	 $('#errormail').text("");
	
}
function passwordshow() {
	
	$(".editpassword").toggle();
	$(".editpassword1").toggle();
	$(".editpasswordform").toggle();
	document.getElementById("current").value="";
	document.getElementById("new").value="";
	document.getElementById("renew").value="";
	$('#passerror').text(" ");
	
}
function languageshow() {
	
	$(".editlanguage").toggle();
	$(".editlanguage1").toggle();
	$(".editlanguageform").toggle();
	
}

function updatename() {
	//alert(document.getElementById("firstname").value);
	if(document.getElementById("firstname").value=="" )
		{
		$('#error').text("Fields cannot be left empty!!");
	return ;
		}
	$.ajax({
		type:'POST', 
		url:'/Facebook/module04/nameupdate.action?first_name='+document.getElementById("firstname").value+"&last_name="+document.getElementById("lastname").value,
		success: function(data){
			var temp = 
						data.first_name+' '+data.last_name;
						
						 $('.editname').text(temp);
						//$(".editname").append(temp);
						
		}
	});
	
		nameshow();
	}


function updateusername() {
    //   String name=document.getElementById("username").value;
       
    if(document.getElementById("username").value=="" )
		{
		$('#test').text("Fields cannot be left empty!!");
	return ;
		}
    
    
	$.ajax({
		type:'POST', 
		url:'/Facebook/module04/usernameupdate.action?uname='+document.getElementById("username").value,
		success: function(data){
							//alert(data.error);
										
						 if(data.error==""){
							 
							 $('.editusername').text(data.uname);
							 
								usernameshow();
							 
						 }else
						 
						 {
							 $('#test').text(data.error);
							
						 }
							
		}
	});
	
	}

function updateemail() {
	//alert("sfd");
	
	if(document.getElementById("sec_email").value=="" )
	{
	$('#errormail').text("Fields cannot be left empty!!");
return ;
	}
	
	
	
	$.ajax({
		type:'POST', 
		url:'/Facebook/module04/emailupdate.action?sec_email='+document.getElementById("sec_email").value,
		success: function(data){
				
			$('#secEmail').text(data.sec_email);
		
			$('#remove').text("Remove");
		}
	});
	
		emailshow();
	}


function removeemail() {
	//alert($('#secEmail').text());
	$.ajax({
		type:'POST', 
		url:'/Facebook/module04/emailremove.action',
		success: function(data){
							$('#secEmail').text(" ");
					
							$('#remove').text(" ");	
		}
	});
	
		emailshow();
	}
	
	
function updatepass() {
	
	if(document.getElementById("new").value=="" ||document.getElementById("renew").value=="")
	{
	$('#passerror').text("Fields cannot be left empty!!");
return ;
	}
	
	
	if(document.getElementById("new").value==document.getElementById("renew").value){
		
		$.ajax({
			type:'POST', 
			url:'/Facebook/module04/updatepass.action?password='+document.getElementById("current").value+"&new_password="+document.getElementById("new").value,
			success: function(data){
								
				if(!(document.getElementById("new").value==data.password))
					
					 $('#passerror').text("Enter Correct Password!!");		
					
				 else
					 passwordshow();
					 
	
			}
		});
		
				
		}				
	 else{
		 
		 $('#passerror').text("Password did not match!!");
		
	 }
		
	}
	
	
function updatelang() {
	
	var e = document.getElementById("language");
	var lang = e.options[e.selectedIndex].text;

	$.ajax({
		type:'POST', 
		url:'/Facebook/module04/updatelang.action?language='+lang,
		success: function(data){
							$('.editlanguage').text(data.language);
					
								
		}
	});
	
		languageshow();
	}

</script>

</head>
<body>


	<div id="container1">
		<div id="left">
			<div id="title">
				<h5>Settings</h5>
			</div>
			<div id="setting_menu">
				<p id="menu_items">
					<a href="/Facebook/module04/settings"><img
						src="/Facebook/asset/images/newsfeed.png" height="15px">&nbsp;&nbsp;General</a><br>
				</p>


				<p id="menu_items">
					<a href="/Facebook/module04/privacySettings"><img
						src="/Facebook/asset/images/messages.png" height="17px">&nbsp;&nbsp;Privacy</a><br>
				</p>


			</div>

		</div>

		<div id="middle">



			<div id="newMsgHeading">
				<h4>
					<b>General Account Settings</b>
				</h4>
			</div>



			<table class="table">

				<tbody>
					<tr class="table-hover">
						<td width="20%" class="boldText">Name</td>
						<td width="70%"><span class="editname"><s:property
									value="s.getFirst_name()" />&nbsp; <s:property
									value="s.getLast_name()" /></span>
							<div class="editnameform" style="display: none;">


								First: <input type="text" name="first_name" id="firstname"
									value="<s:property value="s.getFirst_name()"/>" /><br> <br>
								Last: <input type="text" name="last_name" id="lastname"
									value="<s:property value="s.getLast_name()"/>" />

							<br>	<span id="error" style="color: red;"></span>
								
								<div style="padding-top: 10px;">
									<button type="button" class="btn btn-xs btn-primary"
										onclick="updatename()">Save changes</button>
									<button type="button" class="btn btn-xs btn-default"
										onclick="nameshow()">Close</button>

								</div>

							</div></td>
						<td width="10%"><a href="#" class="editname1"
							onclick="nameshow()">Edit</a></td>
					</tr>



					<tr class="table-hover">
						<td class="boldText">Username</td>
						<td id="getname"><span class="editusername">http://facebook.com/<s:property
									value="s.getUname()" /></span>

							<div class="editusernameform" style="display: none;">

								Your public username is the same as your address for: <br>
								Timeline: facebook.com/<b><s:property value="s.getUname()" /></b><br>
								Email:<b> <s:property value="s.getUname()" /></b>@facebook.com<br>
								<br> Username: <input type="text" id="username"
									name="uname" /><br> <br> <span id="test"
									style="color: red;"></span>

								<div style="padding-top: 10px;">
									<button type="button" class="btn btn-xs btn-primary"
										onclick="updateusername()">Save changes</button>
									<button type="button" class="btn btn-xs btn-default"
										onclick="usernameshow()">Close</button>

								</div>

							</div></td>
						<td><a href="#" class="editusername1"
							onclick="usernameshow()">Edit</a></td>
					</tr>


					<tr class="table-hover">
						<td class="boldText">Email</td>
						<td><span class="editemail"><s:property
									value="s.getEmail()" /></span>

							<div class="editemailform" style="display: none;">

								<b>Primary Email: </b> &nbsp;&nbsp;&nbsp;<input type="radio"
									checked="checked" />
								<s:property value="s.getEmail()" />
								<br> <b>Secondary Email: </b>
						
								
									<span id="secEmail"><s:property value="s.getSec_email()" /></span>
									 &nbsp;<a	href="#" id="remove" onclick="removeemail()">Remove</a>
								
								<hr>
								New Email: <input type="text" id="sec_email" />
   										<br>	<span id="errormail" style="color: red;"></span>
								<hr>
								Facebook email:&nbsp;
								<s:property value="s.getUname()" />
								@facebook.com


								<div style="padding-top: 10px;">
									<button type="submit" class="btn btn-xs btn-primary"
										onclick="updateemail()">Save changes</button>
									<button type="button" class="btn btn-xs btn-default"
										onclick="emailshow()">Close</button>

								</div>

							</div></td>
						<td><a href="#" class="editemail1" onclick="emailshow()">Edit</a></td>
					</tr>



					<tr class="table-hover">
						<td class="boldText">Password</td>
						<td><span class="editpassword">Update Password</span>
							<div class="editpasswordform" style="display: none;">

								Current: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="password" id="current" /><br> <br>
								New:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="password" id="new" /><br> <br> Retype
								new: <input type="password" id="renew" /><br> <br>

								<div id="passerror" style="color: red;"></div>
								<div style="padding-top: 10px;">
									<button type="submit" class="btn btn-xs btn-primary"
										onclick="updatepass()">Save changes</button>
									<button type="button" class="btn btn-xs btn-default"
										onclick="passwordshow()">Close</button>

								</div>

							</div></td>

						<td><a href="#" class="editpassword1"
							onclick="passwordshow()">Edit</a></td>
					</tr>


					<tr class="table-hover">
						<td class="boldText">Language</td>
						<td><span class="editlanguage">English(UK)</span>
							<div class="editlanguageform" style="display: none;">
								Choose Primary: <select id="language">
									<option>English(UK)</option>
									<option>English(US)</option>
									<option>Deutsch</option>
									<option>Italiano</option>
									<option>Romana</option>
									<option>Nepali</option>
								</select>


								<div style="padding-top: 10px;">
									<button type="submit" class="btn btn-xs btn-primary"
										onclick="updatelang()">Save changes</button>
									<button type="button" class="btn btn-xs btn-default"
										onclick="languageshow()">Close</button>

								</div>

							</div></td>
						<td><a href="#" class="editlanguage1"
							onclick="languageshow()">Edit</a></td>
					</tr>

				</tbody>
			</table>


		</div>

	</div>




</body>
</html>