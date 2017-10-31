<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
 <style>
 #friendrequest_notifications,#messages_notifications,#notifications{
 	width: 420px;
 	min-height: 100px;
 	max-height: 400px;
 	overflow-y:auto;
 	 
 }
 .notification_items{
 	min-height: 35px;
 	padding-left: 2%;
 	padding-bottom: 2%;
 	padding-top: 2%;
 }
 .notification_items:hover{
 	cursor: pointer;
 	background-color: #E9EAED;
 }
#notifications_count{
 	padding: 3px 2px;
 	font-size: 11px;
 	margin-left: -10px;
 }
 #friendrequest_count{
  	padding: 3px 2px;
 	font-size: 11px;
 	margin-left: -10px;
 }
 #messages_count{
  	padding: 3px 2px;
 	font-size: 11px;
 	margin-left: -10px;
 }
 #searchlistid{
 	padding: .5%;
 }
 #searchlistid:HOVER{
 	cursor: pointer;
 	background-color: #E9EAED;
 }
 </style>
<script>
$(document).ready(function(){
	$.ajax({
		url: '/Facebook/module06/loadNotifications',
		type: 'POST',
		success: function(data){
			$.each(data.notificationsList, function(index,value){
				var temp = '<a href="/Facebook/module06/loadSingleNotification?notificationType='+value.notificationType+'&uniqueId='+value.uniqueId+'"><li class="notification_items">'+'<img src="'+value.picture+'" height="50px" width="50px">&nbsp;&nbsp;'+value.notificationText+'</li></a>';
				temp += '<div style="height: 1px; width: 96%; background-color: #e3e3e3;"></div>';
				$("#notifications").append(temp);
				$("#notifications_count").html(index+1);
				$("#notification_icon").attr('src','/Facebook/asset/images/noti_icon_2.png');

			});
			$.each(data.friendRequestsList, function(index, value){
				var temp = '<a><li class="notification_items">'+'<img src="'+value.picture+'" height="50px" width="50px" align="left">&nbsp;&nbsp;'+value.notificationText+
							'<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div id="friend_buttons" style="float:right;margin-right:3%;">'+
							'<input type="hidden" value="'+value.uniqueId+'" id="unique_id"><button type="button" class="btn btn-xs btn-primary" id="accept_button">Accept</button>'+
							'&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-xs btn-default" id="reject_button">Reject</button></div></li></a>';
				temp += '<div style="height: 1px; width: 96%; background-color: #e3e3e3;"></div>';
				$("#friendrequest_notifications").append(temp);
			});
			if(data.friendRequestCount > 0){
				$("#friendrequest_count").html(data.friendRequestCount);
				$("#friendrequest_icon").attr('src','/Facebook/asset/images/friend_req_2.png');

			}
			$.each(data.messageNotificationList, function(index, value){
				var temp = '<a href="/Facebook/module01/messageclick"><li class="notification_items">'+'<img src="'+value.picture+'" height="50px" width="50px" align="left">&nbsp;&nbsp;'+value.notificationText+'</li></a>';
				temp += '<div style="height: 1px; width: 96%; background-color: #e3e3e3;"></div>';
				$("#messages_notifications").append(temp);

			});
			if(data.messagesCount > 0){
				$("#messages_count").html(data.messagesCount);
				$("#message_icon").attr('src','/Facebook/asset/images/msg_noti_icon.png');

			}
		}
	});
	$("#notification_icon").click(function(event){
		$("#notification_icon").attr('src','/Facebook/asset/images/noti_icon.png');
		$("#notifications_count").hide();
		$.ajax({
			type:'POST',
			url:'/Facebook/module06/updateNotificationClicked',
			success : function(data){
				
			}
		});
	});
	
	$("#friendrequest_icon").click(function(e){
		$("#friendrequest_icon").attr('src','/Facebook/asset/images/fr_icon.png');
		$("#friendrequest_count").hide();
		$.ajax({
			type:'POST',
			url:'/Facebook/module06/updateFriendClickedTimestamp',
			success: function(data){
				
			}
		});
	});
	$("#message_icon").click(function(e){
		$("#message_icon").attr('src','/Facebook/asset/images/msg_ico.png');
		$("#messages_count").hide();
		$.ajax({
			type:'POST',
			url:'/Facebook/module06/updateMessageClickedTimestamp',
			success: function(data){
				
			}
		});
	});
	
	$("#friendrequest_notifications").on("click","#accept_button",function(e){
		var parent = $(this).parents("#friend_buttons");
		var uniqueId = parent.find("#unique_id");
		e.stopPropagation();
		$.ajax({
			type:'POST',
			url:'/Facebook/module06/acceptFriendRequest?uniqueId='+$(uniqueId).val(),
			success : function(data){
				$(parent).html("friend request accepted");
			}
		});
	});
	
	$("#friendrequest_notifications").on("click","#reject_button",function(e){
		var parent = $(this).parents("#friend_buttons");
		var uniqueId = parent.find("#unique_id");
		e.stopPropagation();
		$.ajax({
			type:'POST',
			url:'/Facebook/module06/rejectFriendRequest?uniqueId='+$(uniqueId).val(),
			success : function(data){
				$(parent).html("friend request rejected");
			}
		});
	});
// jquery for search friends.

	$("#searchId").keyup(function(){
		var nameToSearch=$("#searchId").val();
		$.ajax({
			
			url: '/Facebook/module02/searchAction?name='+nameToSearch,
			type:'POST',
			success: function(data){
				$("#search").empty();
				$.each(data.searchResult,function(index,value){
					var temp='<a href="/Facebook/module02/loadProfilePage?profileId='+value.profile_id+'&isFriend='+value.isFriend+'"><li id="searchlistid">'+'<img src='+value.friendprofilepic+' height="50px" width="50px" style="margin-left:1%;"> &nbsp;&nbsp;'+value.fname+' &nbsp;'+value.lname+'</li> </a>';
					
					$("#search").append(temp);
				});
				$("#searchForm").addClass("open");
			}
		});
	});
	
	$("#container").click(function(){
		$("#search").hide();
	});
	$("#searchId").click(function(){
		$("#search").show();
	});
});
</script>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">

			<a class="navbar-brand" href="/Facebook/module02/loadWall" style="padding-top: 24px;"><img
				src="/Facebook/asset/images/fb_logo.png" /></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
			
				<li><a href="/Facebook/module02/gotoprofilepage" style="float:right; color: #9AA9C8; font-weight: bold;"><div style="height: 30px;width: 30px;float: left; border: 1px solid; border-color: rgb(71, 99, 158);"><img src="<s:property value="#session.user.getProfilePic()"  />" style="height: 30px;width: 30px; "></div>&nbsp;&nbsp;<div style=" color:white; height: 20px;width: 30px; float: right; font-size: 12px;"><s:property value="#session.user.getFname()"  /></div></a></li>
				<li><a href="/Facebook/module02/loadWall" style="color: white; font-size:12px; font-weight: bold;">Home</a></li>
			

				<li class="dropdown">
						<a href="#" style="padding-right: 0px;"class="dropdown-toggle" data-toggle="dropdown"> 
						<img src="/Facebook/asset/images/fr_icon.png" id="friendrequest_icon" height="25px"width="30px" style="padding-right: 0px;" />
											<sup><span class="badge alert-danger" id="friendrequest_count"></span></sup>
						
						</a>
					<ul class="dropdown-menu" id="friendrequest_notifications">
					</ul>
				</li>


				<li class="dropdown">
						<a href="module01/messageclick"style="padding-left: 5px; padding-top: 35%;"class="dropdown-toggle" data-toggle="dropdown"> 
						<img src="/Facebook/asset/images/msg_ico.png" id="message_icon" height="25px" width="27px" />
							<sup><span class="badge alert-danger" id="messages_count"></span></sup>
						</a>
					<ul class="dropdown-menu" id="messages_notifications">
					</ul>
				</li>


				<li class="dropdown">
					<a href="#" style="padding-left: 0px;" class="dropdown-toggle" data-toggle="dropdown"> 
						<img src="/Facebook/asset/images/noti_icon.png" id="notification_icon" height="25px" width="26px" />
							<sup><span class="badge alert-danger" id="notifications_count"></span></sup>
					</a>
					<ul class="dropdown-menu" id="notifications">
					</ul>
				</li>
					
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					 <img src="/Facebook/asset/images/wheel_icon.png" height="20px"width="20px">
					 
					</a>
					<ul class="dropdown-menu">
						<li><a href="/Facebook/module04/settings">Settings</a></li>
						<li><a href="/Facebook/module02/logout">Logout</a></li>
					</ul>
				</li>
			</ul>

			<form class="navbar-form navbar-left dropdown" id="searchForm">
				<input type="text" id="searchId" name="name" class="form-control"
					placeholder="Search for people.....">
					
					<!--  For search bar -->
						<ul class="dropdown-menu" id="search" style="width:540px; margin-left:-5%; max-height:400px; overflow-y:auto; ">
							
						</ul>
						
			</form>
		</div>
	</div>
</div>