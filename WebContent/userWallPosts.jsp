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
<script type="text/javascript" src="/Facebook/asset/js/statusUpdate.js">
</script>
<script type="text/javascript" src="/Facebook/asset/js/deleteWallPost.js">
</script>
<script type="text/javascript"
	src="/Facebook/asset/js/likeUnlikeComment.js">
</script>

<script type="text/javascript" src="/Facebook/asset/js/likesOthers.js">
</script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$(".friendRequestId").click(function(e){
		debugger;
			$.ajax({
				url: '/Facebook/module02/friendRequest',
				type: 'POST',
				success: function(data){
					var temp='&nbsp;&nbsp;&nbsp;&nbsp;Friend Request sent.';
					temp+='<input id="cancelRequestButton" type="button" value="Cancel Friend Request" style="background-color: rgb(106, 167, 79); font-weight:bold;color: white; float:right;margin-right: 2%;">';
					$("#addFriendID").html(temp);
				}		
			});
			e.preventDefault();
		});
		
		$("#addFriendID").on("click","#cancelRequestButton",function(e){
			$.ajax({
				url: '/Facebook/module02/canclefriendRequest',
				type: 'POST',
				success: function(data){
					var temp='&nbsp;&nbsp;&nbsp;&nbsp;To see,what shares with friends,<a class="friendRequestId" href="#" style="color: rgb(59, 89, 152);">Send a friend request.</a>';
					temp+='<input class="friendRequestId" type="button" value="+1 Add Friend" style="background-color: rgb(106, 167, 79); font-weight:bold;color: white; float:right;margin-right: 2%;">';
					$("#addFriendID").html(temp);
				}
			});
		});
	
	});
</script>

</head>
<body>
<div style="height: 100px; width: 100%; border: 1px solid; border-color:rgb(211, 214, 219); background-color: white; font-size:12px; " id="friend_status_div">
		<div style="height:35px;width:100%; border: 1px solid; border-color:rgb(211, 214, 219); background-color: rgb(246, 247, 248)">
			<h5 style="font-weight: bold; color: rgb(106, 116, 128)">&nbsp;&nbsp;&nbsp;Do you Know <s:property value="user.fname" />?</h5>  
		</div>
		<br>
		<!-- Depending on the value of isFriend, show different things like add friend button  -->
		<div id="addFriendID">
	<s:if test="%{isFriend == 0}">
	
	
		&nbsp;&nbsp;&nbsp;&nbsp;To see,what shares with friends,<a class="friendRequestId" href="#" style="color: rgb(59, 89, 152);">Send a friend request.</a>
		<s:if test="%{canSendFriendRequest == 1}">
		<input class="friendRequestId" type="button" value="+1 Add Friend" style="background-color: rgb(106, 167, 79); font-weight:bold;color: white; float:right;margin-right: 2%;">	
		</s:if>
	</s:if>
	
	<s:if test="%{isFriend == 1}">
		&nbsp;&nbsp;&nbsp;&nbsp;You and <s:property value="user.fname"/> are Friends
	</s:if>
	
	<s:if test="%{isFriend == 2}">
		&nbsp;&nbsp;&nbsp;&nbsp;Friend Request sent to <s:property value="user.fname"/>
		<input id="cancelRequestButton" type="button" value="Cancel Friend Request" style="background-color: rgb(106, 167, 79); font-weight:bold;color: white; float:right;margin-right: 2%;">
	</s:if>
	
		
	<s:if test="%{isFriend == 3}">
	<script type="text/javascript">
	$(document).ready(function(){
		$("#friend_status_div").hide();
	});
	</script>
	</s:if>
	</div>
		
	</div>
	<div id="side_menu">
	<!--  	<div
			style="height: 60px; width: 300px; margin-left: 0px; margin-top: 15%;">
			<img src='<s:property value="#session.user.getProfilePic()"/>'
				height="50px" width="50px" align="left" />&nbsp; 
				<s:url action="/Facebook/module02/gotoprofilepage" var="profileLink">
					<s:param name="profileId">
						<s:property value="#session.user.getProfile_id()"/>
					</s:param>
				</s:url>
				<s:a href="%{profileLink}"
				style="color: black; font-size: 12px; font-weight: bold;"><s:property
					value="#session.user.getFname()" />&nbsp;<s:property
					value="#session.user.getLname()" /></s:a> <br>&nbsp;&nbsp;
					<a href="#" style="font-size: 12px;">Edit Profile</a>
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
	<a href="/Facebook/module07/display_frnd_cat_list"><h6 style="font-weight: bold; color: gray;">FRIENDS</h6></a>
	-->
	</div>

	<div id="news_feeds_div">
		<div class="single_wallpost">
			<img alt="error" style="margin-left: 2%;"
				src="/Facebook/asset/images/update_status.png" align="left"
				width="16px" height="16px">
			<p style="font-weight: bold; font-size: 13px;">&nbsp;Post</p>
			<center>
				<div
					style="height: 1px; width: 96%; background-color: #e3e3e3; margin-bottom: 5px; margin-top: 5px;"></div>
			</center>
			<input type="hidden" id="post_to_id" value='<s:property value="#session.currentProfile"/>'/>
			<input type="text" id="newWallPostText" size="84"
				placeholder="Whats on your mind?" required="true"
				style="border: 0px; height: 40px; margin-left: 2%; outline: none; overflow: visible;" /><br>
			<div
				style="padding-left: 86%; padding-top: 6px; padding-bottom: 6px; background-color: #F6F7F8; border-top: 1px solid #e3e3e3;">
				<button type="button" id="newButton" class="btn btn-xs btn-primary"
					style="background-color: #5973A8; padding-left: 20px; padding-right: 20px;">Post</button>
			</div>
		</div>
		<div id="wallposts_collection">
			<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    			<div class="modal-dialog">
      				<div class="modal-content">
					  <div class="modal-header">
          				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          					<h4 class="modal-title" id="myModalLabel">People Who Like This</h4>
        				</div>
        				<div id="loader_likes" style="background-color: #E9EAED;width: 100%;border: 1px solid #e3e3e3;">
         				 	<center><img src="/Facebook/asset/images/loader.gif" height="30px" ></center>
       					</div>
        				<div class="modal-body" id="likes_list_others">
        				
       					</div>
      				</div><!-- /.modal-content -->
   			 	</div><!-- /.modal-dialog -->
  			</div>
			<s:iterator value="wallPostsList">
				<div class="single_wallpost">
					<div id="wallpost_body">
							<s:url action="/Facebook/module02/loadProfilePage" var="profileLink">
								<s:param name="profileId">
									<s:property value="postFrom"/>
								</s:param>
							</s:url>
						<s:a href="%{profileLink}" id="full_name"><img height="40px" width="40px"
							align="left" src='<s:property value="postFromPicture"/>' /></s:a>
							
						&nbsp;&nbsp;
							<s:url action="/Facebook/module02/loadProfilePage" var="profileLink">
								<s:param name="profileId">
									<s:property value="postFrom"/>
								</s:param>
							</s:url>
						<s:a href="%{profileLink}" id="full_name"><s:property
								value="postFromName" /></s:a>
								<s:if test="%{postFrom != postTo}">
									&nbsp;<img src="/Facebook/asset/images/right-normal.png" width="5px" height="7px">&nbsp;
										<s:url action="/Facebook/module02/loadProfilePage" var="profileLink">
											<s:param name="profileId">
												<s:property value="postTo"/>
											</s:param>
										</s:url>
									<s:a href="%{profileLink}" id="full_name"><s:property
									value="postToName" /></s:a>
								</s:if>
								<s:if test="%{postFrom == #session.user.getProfile_id() || postTo == #session.user.getProfile_id()}">
							<div style="float: right;margin-right: 2%">
								<ul type="none">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"><img src="/Facebook/asset/images/caret.png" height="10px" width="10px"></img></a>
									<ul class="dropdown-menu">
										<li><a href="#" id="delete_post">Delete</a></li>
									</ul></li></ul>
							</div>
						</s:if>
								 <br> <br> <br> <font
							size="2.7"><div class="text1">
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
										<s:url action="/Facebook/module02/loadProfilePage" var="profileLink">
											<s:param name="profileId">
												<s:property value="profileId"/>
											</s:param>
										</s:url>
											,<s:a href="%{profileLink}" style="color:#6D84B4; "><s:property value="fullName"/></s:a>
										
										</s:if>
									</s:if>
									<!-- 
									<s:if test="#currentIndex.index > 2">
										and &nbsp;<a class="likes_others" href="#likes_list_others"><s:property value="likesList.size()-2"/>&nbsp; others</a>
											
									</s:if> -->
								</s:iterator>
							</s:if>
							<s:if test="likesList.size() > 1">
										and &nbsp;<a class="likes_others" href="#likes_list_others" data-toggle="modal" data-target="#myModal"><s:property value="likesList.size()-1"/>&nbsp; others</a>
								
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
								<s:url action="/Facebook/module02/loadProfilePage" var="profileLink" namespace="/module02">
									<s:param name="profileId">
										<s:property value="profileId"/>
									</s:param>
								</s:url>
										<s:a href="%{profileLink}"
										id="full_name_comment">&nbsp;&nbsp;<s:property
											value="fullName" /></s:a>&nbsp;<font size="2.5"><s:property
											value="commentText" /></font> <br>
								</div>
							</s:iterator>
						</div>

						<div class="comment_form">
							<img
								src='<s:property value="#session.user.getProfilePic()"/>'
								width="32px" height="32px" align="left" />&nbsp;&nbsp; <input
								type="hidden" value='<s:property value="wallPostId"/>'
								id="comment_wp_id" /> <input style="height: 27px;" type="text"
								id="comment_wp_text" name="commentText"
								placeholder="Write a comment.." size="70" required="true"/>
						</div>
					</div>
				</div>

			</s:iterator>
		</div>
		
	</div>

</body>
</html>