<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<link href="/Facebook/asset/css/jquery.cssemoticons.css" media="screen"
	rel="stylesheet" type="text/css" />
<script src="/Facebook/asset/js/jquery.cssemoticons.js"
	type="text/javascript"></script>
<link href="/Facebook/asset/css/wallPosts.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/Facebook/asset/js/newWallPost.js">
</script>

<script type="text/javascript"
	src="/Facebook/asset/js/likeUnlikeComment.js">
</script>

<script type="text/javascript" src="/Facebook/asset/js/likesOthers.js">
</script>
<script>

$(document).ready(function() {
	$("#inviteSelect").click(function(event) {
		debugger;
		var temp = '<form>';
		$.ajax({
					url : "/Facebook/module05/loadFriendstoInvite",
					type : 'POST',
					success : function(data) {
						var i = 1;
						
					
					
						$.each(data.friendlist,function(index,value) {
							              
											if (i % 2 != 0) {
												temp += '<input id="selectFriend" type="checkbox" value="'+value.profile_id+'" style="position:relative;float:left;"/>&nbsp;<img src="'+value.profile_pic+'" height="20px" width="20px" style="position:relative;float:left;"/><h5 style="position:relative;float:left;">'
														+ value.fname
														+ ' '
														+ value.lname
														+ '</h5>';
												i++;
											} else {
												temp += '<input id="selectFriend" type="checkbox" value="'+value.profile_id+'" style="position:relative;float:left;"/>&nbsp;<img src="'+value.profile_pic+'" height="20px" width="20px" style="position:relative;float:left;"/><h5 style="position:relative;float:left;">'
														+ value.fname
														+ ' '
														+ value.lname
														+ '</h5>';
												i++;

											}
							            		  
							            	  
										});

						temp += '<button type="button" class="btn btn-primary" id="inviteSaveBtns" onclick="saveInvited()">Save</button></form>';
						$("#invitemodal-body").html(temp);

					}
				});
	});
	
	
	


	});

	function saveInvited() {
		debugger;
		alert("hi");
		var idString = "";
		var count = 0;
		var eventid=$('#event_id_hidden').val();
		$('#selectFriend:checked').each(function() {
			if (count != 0) {
				idString += "," + $(this).val();

			} else
				idString += $(this).val();

			count++;
			$.ajax({
				url : '/Facebook/module05/invitedFriends?eventId='+eventid+'&invitedFriendIds='+idString , 
				type : 'POST',
				success : function(data) {	
					$("#invitemodal").hide();
				
				}
			
			});
			
		});

	}

</script>

<style type="text/css">
#sidebar {
	margin-top: 29%;
}
</style>
</head>
<body>

	<div id="side_menu">
		<div
			style="height: 60px; width: 300px; margin-left: 0px; margin-top: 15%;">
			<img src='<s:property value="#session.user.getProfilePic()"/>'
				height="50px" width="50px" align="left" />&nbsp;
			<s:url action="loadProfilePage" var="profileLink" namespace="/module02">
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
		<div style="width: 146%; margin-top: -3%;">
			<div id="coverdivid" style="height: 320px; position: relative;">

				<a href="#" style="position: relative; z-index: 1;"> <img
					src="/Facebook/asset/images/profilepics/0.jpg"
					style="height: 320px; width: 100%; position: relative;"></a> <a
					href="/Facebook/module02/reloadprofile"><p
						style="position: absolute; z-index: 100; left: 190px; top: 280px; font-weight: bold; color: white; font-size: 20px;">
						<s:property value="user.getFname()" />
						&nbsp;
						<s:property value="user.getLname()" />
					</p></a> <input type="button" value="Update Info"
					style="background-color: rgb(251, 251, 252); position: absolute; font-size: 12px; font-weight: bold; z-index: 100; left: 85%; bottom: 3%;">



				<div id="changecoverid"
					style="font-size: 12px; font-weight: bold; height: 7%; width: 12%; border: 1px solid; background-color: rgb(251, 251, 252); color:; margin-top: -15%; margin-left: 85%; z-index: 100; position: absolute;">

					<input type="file" name="myFile" class="filestyle"
						data-input="false" id="filestyle-0" tabindex="-1"
						style="position: absolute; left: -9999px;" /> <label
						for="filestyle-0" class="btn"
						style="margin-top: -6%; margin-left: -10%; font-size: 12px; font-weight: bold;"><i
						class="icon-folder-open"></i> Add event Photo</label>


				</div>






			</div>


			<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid"
				style="position: relative; background-color: white;">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"></a>
				</div>


<div>
				<div
					style=" width: 50%; float:left; margin-left:-80px;margin-top:3px;">
					<u style="font-size:16px;color: rgb(80, 110, 250); font-weight: bold;  "><s:property value="eventTitle" /></u>

					<br> 
					
					<a href="/Facebook/module02/loadProfilePage?profileId=<s:property value="eventOwnerId"  />"
						style="color: rgb(82, 110, 166); padding-top:10px; "><s:property
							value="eventOwnerName" /></a> is Hosting
				</div>
				<s:if test="%{ eventOwnerId == #session.user.getProfile_id()}">
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1"
					style="width: 20%; float: right; margin-top:-5px;">

					<ul class="nav navbar-nav navbar-left">

						<li style="font-weight: bold;"></li>

							<li id ="inviteSelect" style="font-weight: bold;" 
							style="color: rgb(82, 110, 166);" data-toggle="modal"
							data-target="#invitemodal" aria-hidden="true">Invite</li>
							
						<li class="dropdown" style="font-weight: bold;"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"
							style="color: rgb(82, 110, 166);">More <b class="caret"></b></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Edit</a></li>
								
								<li id="cancelEventBtn" data-toggle="modal"
							data-target="#canceleventmodal" aria-hidden="true">Cancel</li>
								<li class="divider"></li>
							</ul></li>
					</ul>
				</div>
				</s:if>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid --> </nav>
		</div>
		<div
			style="height: 50px; width =: 50px; background-color: white; border-bottom: 1px solid #E9EAED;">
			<img src="" />
			<s:property value="eventDateHdr" />
			at
			<s:property value="eventTime" />
		</div>

		<div
			style="height: 50px; width =: 50px; background-color: white; margin-bottom: 2%;">
			<img src="" />
			<s:property value="event_where" />
		</div>
		
		<div
			style="height: 50px; width =: 50px; background-color: white; margin-bottom: 2%;">
			<img src="" />
			<!-- friends invited -->
			<a href="#" data-toggle="modal"
							data-target="#invited_friends" aria-hidden="true">Invited(<s:property value="invitedList.size()"/>)</a>
			<div class="modal fade" id="invited_friends" tabindex="-1" role="dialog"
			aria-labelledby="inviteModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #6d84b4;">
						<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						<h4 class="modal-title">Invited Friends</h4>
					</div>
					<div class="modal-body">
							<ul>

							<s:iterator value="invitedList">
								<li><a href='/Facebook/module02/loadProfilePage?profileId=<s:property value="profile_id"/>'><img src='<s:property value="profilePic"/>' align="left" height="50px" width="50px"><s:property value="fname"/>&nbsp;<s:property value="lname"/></a></li><li></li>
							</s:iterator>
							<br>
							</ul>



					</div>

				</div>


			</div>
		</div>
	
			
		</div>
	
	
			<div
			style="height: 50px; width =: 50px; background-color: white; margin-bottom: 2%;">
			<img src="" />
			<!-- friends invited -->
			<a href="#" data-toggle="modal"
							data-target="#going_friends" aria-hidden="true">Going(<s:property value="goingList.size()"/>)</a>
			<div class="modal fade" id="going_friends" tabindex="-1" role="dialog"
			aria-labelledby="goingModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #6d84b4;">
						<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						<h4 class="modal-title">Going Friends</h4>
					</div>
					<div class="modal-body">
							<ul>

							<s:iterator value="goingList">
								<li><a href='/Facebook/module02/loadProfilePage?profileId=<s:property value="profile_id"/>'><img src='<s:property value="profilePic"/>' align="left" height="50px" width="50px"><s:property value="fname"/>&nbsp;<s:property value="lname"/></a></li>
							</s:iterator>
							<br>
							</ul>



					</div>

				</div>


			</div>
		</div>
		</div>
		
				<div
			style="height: 50px; width =: 50px; background-color: white; margin-bottom: 2%;">
			<img src="" />
			<!-- friends invited -->
			<a href="#" data-toggle="modal"
							data-target="#maybe_friends" aria-hidden="true">May Be(<s:property value="maybeList.size()"/>)</a>
			<div class="modal fade" id="maybe_friends" tabindex="-1" role="dialog"
			aria-labelledby="inviteModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #6d84b4;">
						<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						<h4 class="modal-title">May Be Going Friends</h4>
					</div>
					<div class="modal-body">
							<ul>

							<s:iterator value="maybeList">
								<li><a href='/Facebook/module02/loadProfilePage?profileId=<s:property value="profile_id"/>'><img src='<s:property value="profilePic"/>' align="left" height="50px" width="50px"><s:property value="fname"/>&nbsp;<s:property value="lname"/></a></li>
							</s:iterator>
							<br>
							</ul>



					</div>

				</div>


			</div>
		</div>
	
			
		</div>
	
		


		<!-- wall posts of event -->
		<div class="single_wallpost">
			<img alt="error" style="margin-left: 2%;"
				src="/Facebook/asset/images/update_status.png" align="left"
				width="16px" height="16px">
			<p style="font-weight: bold; font-size: 13px;">&nbsp;Post</p>
			<center>
				<div
					style="height: 1px; width: 96%; background-color: #e3e3e3; margin-bottom: 5px; margin-top: 5px;"></div>
			</center>

			<input type="text" id="newWallPostText" size="84"
				placeholder="Whats on your mind?" required="true"
				style="border: 0px; height: 40px; margin-left: 2%; outline: none; overflow: visible;" /><br>
			<input type="hidden" value='<s:property value="eventId"/>'
				id="event_id_hidden">
			<input type="hidden" id="post_to_id" value='<s:property value="#session.user.getProfile_id()"/>'/>
				
			<div
				style="padding-left: 86%; padding-top: 6px; padding-bottom: 6px; background-color: #F6F7F8; border-top: 1px solid #e3e3e3;">
				<button type="button" id="newButton" class="btn btn-xs btn-primary"
					style="background-color: #5973A8; padding-left: 20px; padding-right: 20px;">Post</button>
			</div>
		</div>
		<div id="wallposts_collection">
			<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">People Who Like
								This</h4>
						</div>
						<div id="loader_likes"
							style="background-color: #E9EAED; width: 100%; border: 1px solid #e3e3e3;">
							<center>
								<img src="/Facebook/asset/images/loader.gif" height="30px">
							</center>
						</div>
						<div class="modal-body" id="likes_list_others"></div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<s:iterator value="wallPostsList">
				<div class="single_wallpost">
					<div id="wallpost_body">
						<s:url action="loadProfilePage" namespace="/module02"
							var="profileLink">
							<s:param name="profileId">
								<s:property value="postFrom" />
							</s:param>
						</s:url>
						<s:a href="%{profileLink}" id="full_name">
							<img height="40px" width="40px" align="left"
								src='<s:property value="postFromPicture"/>' />
						</s:a>
						&nbsp;&nbsp;
						<s:url action="loadProfilePage" namespace="/module02"
							var="profileLink">
							<s:param name="profileId">
								<s:property value="postFrom" />
							</s:param>
						</s:url>
						<s:a href="%{profileLink}" id="full_name">
							<s:property value="postFromName" />
						</s:a>
						<br> <br> <br> <font size="2.7"><div
								class="text1">
								<s:property value="wallPostText" />
							</div></font> <br>
						<div class="likes_container">
							<div class="like_comment_button" style="padding-bottom: 1%;">
								<input type="hidden" value='<s:property value="wallPostId"/>'
									id="like_wp_id" />
								<s:if test="%{isLiked == 0}">
									<div class="clickable" id="like_link" style="float: left;">Like</div>
								</s:if>
								<s:if test="%{isLiked == 1}">
									<div class="clickable" id="unlike_link" style="float: left;">Unlike</div>
								</s:if>
								<div id="intermediate" style="float: left;">&nbsp;*&nbsp;</div>
								<div class="clickable" id="comment_link" style="float: left;">Comment</div>
							</div>

							<div id="likes"
								style="position: absolute; float: left; font-size: 12px; padding-top: 4%;">
								&nbsp;&nbsp;<img alt="Like"
									src="/Facebook/asset/images/like_icon.png" height="13"
									width="15" id="like_image">
								<s:if test="%{likesList.size()!=0}">
									<s:iterator value="likesList" status="currentIndex">
										<s:if test="#currentIndex.index <= 0">
											<s:if test="%{isLiked == 1}">
											You
										</s:if>
											<s:if test="%{isLiked == 0}">
												<s:url action="/Facebook/module02/loadProfilePage"
													var="profileLink">
													<s:param name="profileId">
														<s:property value="profileId" />
													</s:param>
												</s:url>
											,<s:a href="%{profileLink}" style="color:#6D84B4; ">
													<s:property value="fullName" />
												</s:a>

											</s:if>
										</s:if>
										<!-- 
									<s:if test="#currentIndex.index > 2">
										and &nbsp;<a class="likes_others" href="#likes_list_others"><s:property value="likesList.size()-2"/>&nbsp; others</a>
											
									</s:if> -->
									</s:iterator>
								</s:if>
								<s:if test="likesList.size() > 1">
										and &nbsp;<a class="likes_others" href="#likes_list_others"
										data-toggle="modal" data-target="#myModal"><s:property
											value="likesList.size()-1" />&nbsp; others</a>

								</s:if>
								<s:if test="%{likesList.size() == 0}">
								&nbsp;
							</s:if>

								like this
							</div>
						</div>
					</div>
					<br>


					<div class="comments_div">
						<br>
						<center>
							<div
								style="height: 1px; width: 96%; background-color: #e3e3e3; margin-bottom: 5px; margin-top: 5px;"></div>
						</center>
						<div id="comments_collection">

							<s:iterator value="commentsList">


								<div id="comment">
									<img src="<s:property value="profilePicture"/>" width="32px"
										height="32px" align="left" />
									<s:url action="/Facebook/module02/loadProfilePage"
										var="profileLink">
										<s:param name="profileId">
											<s:property value="profileId" />
										</s:param>
									</s:url>
									<s:a href="%{profileLink}" id="full_name_comment">&nbsp;&nbsp;<s:property
											value="fullName" />
									</s:a>
									&nbsp;<font size="2.5"><s:property value="commentText" /></font>
									<br>
								</div>
							</s:iterator>
						</div>

						<div class="comment_form">
							<img src='<s:property value="#session.user.getProfilePic()"/>'
								width="32px" height="32px" align="left" />&nbsp;&nbsp; <input
								type="hidden" value='<s:property value="wallPostId"/>'
								id="comment_wp_id" /> <input style="height: 27px;" type="text"
								id="comment_wp_text" name="commentText"
								placeholder="Write a comment.." size="79" />
						</div>
					</div>
				</div>

			</s:iterator>
		</div>

	</div>
	
	<div class="modal fade" id="invitemodal" tabindex="-1" role="dialog"
			aria-labelledby="inviteModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #6d84b4;">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="inviteModalLabel">Invite Friends</h4>
					</div>
					<div id="invitemodal-body" class="modal-body">


						<!-- friends list with checkbox -->




					</div>

				</div>


			</div>
		</div>
	

<!-- Cancel event modal pop up for confirmation of event cancellation -->


<div class="modal fade" id="canceleventmodal" tabindex="-1" role="dialog"
			aria-labelledby="cancelModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #6d84b4;">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="cancelModalLabel">Cancel Event?</h4>
					</div>
					<div id="cancelmodal-body" class="modal-body">

					 Are you sure you want to cancel this event?
					 
					 <form action="/Facebook/module05/cancelEventAction">
					 <input type="hidden" name="eventId" value='<s:property value="eventId"/>'
			        	id="event_id_hidden">
					<button type="submit" class="btn btn-primary">Yes</button>
					</form>
					
					<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
					

					</div>
					
				
					

				</div>


			</div>
		</div>

	
	

</body>
</html>