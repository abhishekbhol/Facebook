<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">

$(document).ready(
		function() {
			
$("#reply").on("keypress",function(e) {
	if(e.which==13){
		
		window.location = "/Facebook/module01/newMsgSend.action?message_body="+document.getElementById("message_text").value+"&receiver_fullname="+document.getElementsByName("receiver_fullname")[0].value; 
	}
});

		});


</script>
<link href="/Facebook/asset/css/newMessage.css" rel="stylesheet">
<sx:head />
</head>
<body>

	
	<div id="container1">
		<div id="left">
			<div id="title">
				<a href="/Facebook/module01/inboxTitle">Inbox</a><span class="badge"><s:property value="unreadMessages"/></span>

			</div>
			<div id="messages">
				<ul class="nav nav-tabs nav-stacked affix-top" 
					data-offset-top="125">
					
					
					<s:iterator value="namelist">
					<li ><a href="conversation?conversation_id=<s:property value="profile_id"/>"><fieldset>
					<img src="<s:property value="profile_pic"/>" width="35px" height="33px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="firstname"/>&nbsp;<s:property value="lastname"/>
							
						
					</fieldset></a></li>				
					</s:iterator>						
				</ul>
			</div>
		</div>

		<div id="middle">
		<form action="/Facebook/module01/newMsgSend">
		
			<div id="newMsgHeading">
			<h5>	<b>New Message</b></h5>
			</div>
			<div  id="detailmsg">
			<div id="to">
			To:&nbsp; <sx:autocompleter size="1" list="friendslist" name="receiver_fullname"  showDownArrow="false" ></sx:autocompleter>
			</div>
			</div>
			<div id="replyarea">
				<div id="reply">
					
						<textarea name="message_body" id="message_text" rows="4" cols="82" placeholder="Write a message..."></textarea>
						<br><input type="hidden" name="conversation_id" id="conversation_id" value='<s:property value ="conversation_id"/>'/> 
												<button type="submit" class="btn btn-xs btn-primary ">Send </button>
					
				</div>
			</div>
			</form>
		</div>
		
	</div>
</body>
</html>