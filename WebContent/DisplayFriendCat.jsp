<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/Facebook/asset/css/wallPosts.css" rel="stylesheet" type="text/css"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

debugger;
var ajaxvar="nisha";
	$(document).ready(function(){
		$("#loadAjax").click(function(event){
			var temp = '<form action="update-cat-list" id="myForm"><input type="text" name="catName" id="txtbox"/><input type="hidden" id="hidden" type="text" name="cat" value=""><br><br>';
				$.ajax({
				url : "/Facebook/module05/loadFriendstoInvite",
				type: 'POST',
				success: function(data){
					var i=1;	
					$.each(data.friendlist, function(index, value){
						if(i%2!=0)						
						{temp += '<input type="checkbox" value="'+value.profile_id+'" name="selected" style="position:relative;float:left;"/>&nbsp;<img src="'+value.profile_pic+'" height="20px" width="20px" style="position:relative;float:left;"/><h5 style="position:relative;float:left;">'+value.fname+' '+value.lname+'</h5>';
						 i++;
						}
						else
						{   temp += '<input type="checkbox" value="'+value.profile_id+'" name="selected" style="position:relative;float:left;"/>&nbsp;<img src="'+value.profile_pic+'" height="20px" width="20px" style="position:relative;float:left;"/><h5 style="position:relative;float:left;">'+value.fname+' '+value.lname+'</h5></td>';
							i++;
						 				
							
						}
						});
					
					temp +='<button type="submit" class="btn btn-primary" id="inviteSaveBtns" onclick="check()" disabled="disabled">Save</button></form>';
					$("#makelist").html(temp);
					
				}
			});
		});
	});
	

	
</script>

 <script>
 //On click of manage list, if list empty...it would not save
 //Cannot create list of same name
 $(document).ready(function(){
 $("#makelist").on("keyup","#txtbox", function(e){
	var flag=false;
	var content = $(this).val();
	var parent = $(this).parents("#makelist");
	var button = parent.find("#inviteSaveBtns");
	//var hidden = parent.find("#hidden"); 
 	var select="${catList}";//List returned from action...[a, b, c]
 	//hidden.value=select;
	if(content.length != 0){
 		flag=true;
 		var str=select.slice(1,select.length-1);
 		str=str.toString().split(", ");
 		//alert(str);
 		for(var i=0;i<str.length;i++){
 			if(content==str[i]){
 				//alert(str[i]);
 				flag=false;
 				}
 		}
 	}else{
 		flag=false;
 	}
 	
 	if(flag){
 		$(button).removeAttr('disabled');
 	}else{
 		 $(button).attr('disabled', 'disabled');

 	}
 	
 });
 });
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends Category</title>
</head>
<body>	
<div id="side_menu">
		<div
			style="height: 60px; width: 300px; margin-left: 0px; margin-top: 15%;">
			<img src='<s:property value="#session.user.getProfilePic()"/>'
				height="50px" width="50px" align="left" />&nbsp;
			<s:url action="/Facebook/module02/gotoprofilepage" var="profileLink">
				<s:param name="profileId">
					<s:property value="#session.user.getProfile_id()" />
				</s:param>
			</s:url>
			<s:a href="%{profileLink}"
				style="color: black; font-size: 12px; font-weight: bold;">
				<s:property value="#session.user.getFname()" />&nbsp;<s:property
					value="#session.user.getLname()" />
			</s:a>
			<br>&nbsp;&nbsp; <a href="#" style="font-size: 12px;">Edit
				Profile</a>
		</div>

		<h6 style="font-weight: bold; color: gray;">FAVORITES</h6>
		<p id="menu_items">
			<a href="/Facebook/module02/loadWall"><img
				src="/Facebook/asset/images/newsfeed.png" height="15px">&nbsp;&nbsp;News
				Feed</a><br>
		</p>


		<p id="menu_items">
			<a href="/Facebook/module01/messageclick"><img
				src="/Facebook/asset/images/messages.png" height="17px">&nbsp;&nbsp;Messages</a><br>
		</p>


		<p id="menu_items">
			<a href="/Facebook/module05/eventaction" id="menu_items"><img
				src="/Facebook/asset/images/events.png" height="15px">&nbsp;&nbsp;Events</a><br>
		</p>


		<p id="menu_items">
			<a href="#" id="menu_items"><img
				src="/Facebook/asset/images/photos.png" height="15px">&nbsp;&nbsp;Photos</a><br>
		</p>
		<a href="/Facebook/module07/display_frnd_cat_list"><h6
				style="font-weight: bold; color: gray;">FRIENDS</h6></a>
	</div>
      <div id="news_feeds_div">
      <div style="background-color: white;padding: 3%;">
      <!-- populate the friends category list -->
     <s:iterator value="catList" id="cat"><p><a href="/Facebook/module07/loadCategoryWall?category=<s:property/>"  ><img src="/Facebook/asset/images/newsfeed.png" height="15px">&nbsp;&nbsp;
     	<s:property/></a><br></p> 
      </s:iterator>  
      <button class="btn btn-primary btn-lg" id="loadAjax" data-toggle="modal" data-target="#myModal">
  <span class="glyphicon glyphicon-plus"></span> Manage List
</button>
</div>
      </div>




<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Create List</h4>
      </div>
      <div class="modal-body" id="makelist">
    
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>



</body>
</html>