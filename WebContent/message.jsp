<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/Facebook/asset/css/jquery.cssemoticons.css" media="screen"
	rel="stylesheet" type="text/css" />
<script src="/Facebook/asset/js/jquery.cssemoticons.js"
	type="text/javascript"></script>
<link href="/Facebook/asset/css/message.css" rel="stylesheet">
<style type="text/css">
#messages:hover{
	cursor: pointer;
	text-decoration: none;
}
</style>
<script type="text/javascript">

$(document).ready(
		function() {
			
			//when enter is pressed in replyarea
			
			$("#reply").on("keypress",function(e) {
				if(e.which==13){
					var f = $(this);
				
					$.ajax({
						type:'POST', 
						url:'/Facebook/module01/replyMsg1.action?conversation_id='+document.getElementById("conversation_id").value+"&conversation_body="+document.getElementById("replytext").value,
						success: function(data){
							var temp =  ' <a href="#">&nbsp;&nbsp;&nbsp;&nbsp;<img src="'+data.profile_pic+'" align="left" width="35px" height="33px"/>'+
										'&nbsp;<b>'+data.firstname+'&nbsp;'+data.lastname+'</b></a><span class="label label-info">'+data.time+
										'</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data.conversation_body+'&nbsp;&nbsp;<br><br>';
										
										
										$("#detailmsg").append(temp);
										$("#detailmsg").animate({ scrollTop: $(document).height() }, "fast");
										document.getElementById("replytext").value="";
										$("#detailmsg").emoticonize();
										
							var tmp="";
										
							for (var i = 0; i < data.namelist.length; i++) { 
							
										
							tmp += 
								'<ul class="nav nav-tabs nav-stacked affix-top" data-offset-top="125">'+
							'<li ><a onclick="namelistshow('+data.namelist[i].profile_id+')"><fieldset>'+
							'<img src="'+data.namelist[i].profile_pic+'" width="35px" height="33px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data.namelist[i].firstname+'&nbsp;'+data.namelist[i].lastname+''+
							'</fieldset></a></li>'+
							'</ul>';
										
						}
							$("#messages").html(tmp);
								
						}
					});
				}
			});

			
			
		});
//struts call for reply button click

function test(){
		window.location = "replyMsg.action?message_body="+document.getElementById("replytext").value+"&conversation_id="+document.getElementById("conversation_id").value; 
	
}


// struts call for delete conversation link click

function deleteconversation(){
		window.location = "deleteconversation.action?conversation_id="+document.getElementById("conversation_id").value; 
	
}


//shows conversation with the person whose name is clicked in namelist

function namelistshow(id) {
	
	$.ajax({
		type:'POST', 
		url:'/Facebook/module01/canceldelmsg.action?conversation_id='+id,
		success: function(data){
			var tmp="";
			
			for (var i = 0; i < data.conversation.length; i++) { 
			   
			
			    tmp +=
				'<a href="#"><img src="'+data.conversation[i].profile_pic+'" width="35px" height="33px" /></a>'+
				'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"><b>'+data.conversation[i].firstname+'&nbsp;'+data.conversation[i].lastname+'</b></a><span class="label label-info">'+data.conversation[i].time+
				'</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data.conversation[i].conversation_body+'&nbsp;&nbsp;<br><br>';
			
			}
			
			var tmp2 = '<a href="#"><h4><b>'+data.name+'</b></h4></a>';
			
					$("#detailmsg").html(tmp);
					
					$("#name").html(tmp2);
					$("#detailmsg").emoticonize();
					$("#detailmsg").animate({ scrollTop: $(document).height() }, "fast");

					
					var tmp1 = 	'<form action="replyMsg" method="get">   '+      
					'<textarea rows="4" cols="82" name="message_body" id="replytext" placeholder="Write a reply..." ></textarea>'+
					'<br><input type="hidden" name="conversation_id" id="conversation_id" value='+data.id+'>'+
		
					'<button type="button" onclick="test()" id="replyBtn" class="btn btn-xs btn-primary ">Reply</button>'+
					'</form>';
		
					$("#reply").html(tmp1);

			
		}
	});
	
}


//to delete selected messages

function deletemessages() {
	
	var delmsgs = new Array();
	var i=0;
	 $('.delete:checked').each(function(){
		
		delmsgs[i] = $(this).val();
		i++;
		}	
	);
	//alert(document.getElementById("conversation_id").value);
	 $.ajax({
			type:'POST', 
			url:'/Facebook/module01/delmsg.action?message_ids='+delmsgs+'&conversation_id='+document.getElementById("conversation_id").value,
			success: function(data){
				var tmp="";
				
				for (var i = 0; i < data.conversation.length; i++) { 
				   
				
				    tmp +=
					'<a href="#"><img src="'+data.conversation[i].profile_pic+'" width="35px" height="33px" /></a>'+
					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"><b>'+data.conversation[i].firstname+'&nbsp;'+data.conversation[i].lastname+'</b></a><span class="label label-info">'+data.conversation[i].time+
					'</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data.conversation[i].conversation_body+'&nbsp;&nbsp;<br><br>';
				
				}
					
						$("#detailmsg").html(tmp);
						$("#detailmsg").emoticonize();
						$("#detailmsg").animate({ scrollTop: $(document).height() }, "fast");

						
						var tmp1 = 	'<form action="replyMsg" method="get">   '+      
									'<textarea rows="4" cols="82" name="message_body" id="replytext" placeholder="Write a reply..." ></textarea>'+
									'<br><input type="hidden" name="conversation_id" id="conversation_id" value='+data.id+'>'+
						
									'<button type="button" onclick="test()" id="replyBtn" class="btn btn-xs btn-primary ">Reply</button>'+
									'</form>';
						$("#reply").html(tmp1);
			}
	 });
}


//when cancel button is clicked in delete messages

function canceldelete() {

	 $.ajax({
			type:'POST', 
			url:'/Facebook/module01/canceldelmsg.action?conversation_id='+document.getElementById("conversation_id").value,
			success: function(data){
				var tmp="";
				
				for (var i = 0; i < data.conversation.length; i++) { 
				   
				
				    tmp +=
					'<a href="#"><img src="'+data.conversation[i].profile_pic+'"  width="35px" height="33px"/></a>'+
					'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"><b>'+data.conversation[i].firstname+'&nbsp;'+data.conversation[i].lastname+'</b></a><span class="label label-info">'+data.conversation[i].time+
					'</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data.conversation[i].conversation_body+'&nbsp;&nbsp;<br><br>';
				
				}
					
						$("#detailmsg").html(tmp);
						$("#detailmsg").emoticonize();
						
						var tmp1 = 	'<form action="replyMsg" method="get">   '+      
									'<textarea rows="4" cols="82" name="message_body" id="replytext" placeholder="Write a reply..." ></textarea>'+
									'<br><input type="hidden" name="conversation_id" id="conversation_id" value='+data.id+'>'+
						
									'<button type="button" onclick="test()" id="replyBtn" class="btn btn-xs btn-primary ">Reply</button>'+
									'</form>';
									
						$("#reply").html(tmp1);
						$("#detailmsg").animate({ scrollTop: $(document).height() }, "fast");

			}
	 });
}


//when delete messages option is clicked from dropdown menu--gives the checkbox infront of every message
	
	function chkboxdelete() {
	
	$.ajax({
		type:'POST', 
		url:'/Facebook/module01/delmsgbutton.action?conversation_id='+document.getElementById("conversation_id").value,
		success: function(data){
			var tmp="";
			//alert(data.conversation);
			for (var i = 0; i < data.conversation.length; i++) { 
			   
			
			    tmp += '<input type="checkbox" class="delete" value ="'+data.conversation[i].message_id+'"align="left"'+
				'<a href="#">&nbsp;&nbsp;&nbsp;&nbsp;<img src="'+data.conversation[i].profile_pic+'"  width="35px" height="33px"/></a>'+
				'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"><b>'+data.conversation[i].firstname+'&nbsp;'+data.conversation[i].lastname+'</b></a><span class="label label-info">'+data.conversation[i].time+
				'</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+data.conversation[i].conversation_body+'&nbsp;&nbsp;<br><br>';
			
			}
				
					$("#detailmsg").html(tmp);
					$("#detailmsg").emoticonize();
					$("#detailmsg").animate({ scrollTop: $(document).height() }, "fast");
					
					var temp='<b>Select messages to delete</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button style="float:right;" type="button" onclick="canceldelete()" id="cancel" class="btn btn-xs btn-default ">Cancel</button>'+
					      '<input type="hidden" name="conversation_id" id="conversation_id" value='+document.getElementById("conversation_id").value+'>&nbsp;&nbsp;<button type="button" onclick="deletemessages()" class="btn btn-xs btn-primary ">Delete</button>';
					
					      $("#reply").html(temp);
					
			}
		});
	}

	

		
</script>

</head>
<body>

	<div id="container1">
		<div id="left">
			<div id="title">
				<a href="/Facebook/module01/inboxTitle">Inbox</a><span class="badge"><s:property
						value="unreadMessages" /></span>

			</div>
			<div id="messages">
				<ul class="nav nav-tabs nav-stacked affix-top" data-offset-top="125">


					<s:iterator value="namelist">
						<li><a onclick="namelistshow(<s:property value="profile_id"/>)"><fieldset>
									<img src="<s:property value="profile_pic"/>" width="35px" height="33px"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<s:property value="firstname" />
								
									<s:property value="lastname" />


								</fieldset></a></li>
					</s:iterator>
				</ul>
			</div>
		</div>

		<div id="middle">
			<div id="namenmsg">
				<div id="name">
					<a href="#"><h4>
							<b><s:property value="firstMessageName" /></b>
						</h4></a>

				</div>
				<div id="newmsg">
					<form action="/Facebook/module01/newMessageButton" method="post">
						<div class="btn-group">

							<button type="submit" class="btn btn-xs btn-default">
								<span class="glyphicon glyphicon-plus"></span>&nbsp;New Message
							</button>

							<div class="btn-group">
								<button type="button"
									class="btn btn-xs btn-default dropdown-toggle"
									data-toggle="dropdown">
									<span class="glyphicon glyphicon-asterisk"></span>&nbsp;Actions
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu dropdown-menu-right" role="menu">
									<li><a onclick="chkboxdelete()" class="delmsg" href="#"><font
											size="1">Delete Messages</font></a></li>
									<li><a onclick="deleteconversation()" href="#"><font
											size="1">Delete Conversation</font></a></li>


								</ul>
							</div>
							<!--  	<button type="button"
							class="btn btn-xs btn-default dropdown-toggle"
							data-toggle="dropdown">
							<span class="glyphicon glyphicon-search"></span>&nbsp;
						</button>   -->

						</div>
					</form>
				</div>

			</div>

			<div id="detailmsg">

				<s:iterator value="conversation">
					<fieldset>
						<a href="#"> <!-- <a href="profile?profile_id=<s:property value="profile_id"/>"> -->
							&nbsp;&nbsp;&nbsp;&nbsp;<img
							src="<s:property value="profile_pic"/>" align="left" width="35px" height="33px"/>&nbsp;<b><s:property
									value="firstname" />&nbsp;<s:property value="lastname" /></b></a> <span
							class="label label-info"><s:property value="time" /></span><br>&nbsp;&nbsp;&nbsp;&nbsp;
						<s:property value="conversation_body" />
						&nbsp;&nbsp;&nbsp;&nbsp;<br> <br>

					</fieldset>
				</s:iterator>
			</div>
			<div id="replyarea">
				<div id="reply">
					<form action="replyMsg" method="get">
						<textarea rows="4" cols="82" name="message_body" id="replytext"
							placeholder="Write a reply..."></textarea>
						<br> <input type="hidden" name="conversation_id"
							id="conversation_id"
							value='<s:property value="conversation_id"/>' />

						<button type="submit" id="replyBtn"
							class="btn btn-xs btn-primary ">Reply</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script>
	$("#detailmsg").animate({ scrollTop: $(document).height() }, "fast");
	$("#detailmsg").emoticonize();

	 // return false;
	</script>

</body>
</html>