<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="/Facebook/asset/css/settings.css" rel="stylesheet">
<script>
	function viewsetting() {

		$(".viewsetting").toggle();
		$(".viewsetting1").toggle();
		$(".viewsetting2").toggle();
		$(".editviewsetting").toggle();

	}
	
	function msgsetting() {

		$(".msgsetting").toggle();
		$(".msgsetting1").toggle();
		$(".editmsgsetting").toggle();

	}
	
	
	function friendsetting() {

		$(".friendsetting").toggle();
		$(".friendsetting1").toggle();
		$(".editfriendsetting").toggle();

	}
	
	function updateviewsetting() {
		
		var e = document.getElementById("category");
		var setting = e.options[e.selectedIndex].text;
		
		$.ajax({
			type:'POST', 
			url:'/Facebook/module04/viewupdate.action?viewsetting='+setting,
			success: function(data){
				
							 $('.viewsetting').text(data.viewsetting);
						
							
			}
		});
		
		viewsetting();
		}

	
	function updatefriendsetting() {
		
		var e = document.getElementById("frndsetting");
		var setting = e.options[e.selectedIndex].text;
		
		$.ajax({
			type:'POST', 
			url:'/Facebook/module04/friendrequpdate.action?friendreqsetting='+setting,
			success: function(data){
				
							 $('.friendsetting').text(data.friendreqsetting);
						
							
			}
		});
		
		friendsetting();
		}
	
	
	
	function updatemsgsetting() {
		
		var e = document.getElementById("setting");
		var setting = e.options[e.selectedIndex].text;
		
		$.ajax({
			type:'POST', 
			url:'/Facebook/module04/msgupdate.action?messagesetting='+setting,
			success: function(data){
				
							 $('.msgsetting').text(data.messagesetting);
						
							
			}
		});
		
		msgsetting();
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
					<a href="settings"><img
						src="/Facebook/asset/images/newsfeed.png" height="15px">&nbsp;&nbsp;General</a><br>
				</p>


				<p id="menu_items">
					<a href="privacySettings"><img
						src="/Facebook/asset/images/messages.png" height="17px">&nbsp;&nbsp;Privacy</a><br>
				</p>


			</div>

		</div>

		<div id="middle">



			<div id="newMsgHeading">
				<h4>
					<b>Privacy Settings</b>
				</h4>
			</div>


			<table class="table">

				<tbody>
					<tr class="table-hover">
						<td width="20%" class="boldText">Who can see my stuff?</td>
						<td width="50%"><span class="viewsetting2">Who can see
								your future posts?</span>
							
							<div class="editviewsetting" style="display: none;">

								Who can see your future posts? <br> <br> This control
								remembers your selection so future posts will be shared with the
								same audience unless you change it. <br> <br>
								<div id="single_wallpost">

									<input type="text" disabled="disabled" size="50"
										placeholder="Whats on your mind?" required="true"
										style="border: 1px; height: 50px; outline: border; overflow: visible;" /><br>
									<div
										style="padding-top: 6px; padding-bottom: 6px; background-color: #F6F7F8; border-top: 1px solid #e3e3e3;">

										<span style="margin-left: 180px" class="btn-group">
										
										 <select id="category">

												<s:iterator value="s.getCatgname().getCatList()">
													<option><a href="#"><s:property /></a></option>

												</s:iterator>
												</select>
												</span>

										<button type="button" id="newButton" disabled="disabled"
											class="btn btn-sm btn-primary"
											style="background-color: #5973A8; padding-right: 20px;">Post</button>
									</div>
								</div>



								<br>
								<div style="padding-top: 10px;">
									<button type="button" class="btn btn-xs btn-primary"
										onclick="updateviewsetting()">Save changes</button>
									<button type="button" class="btn btn-xs btn-default"
										onclick="viewsetting()">Close</button>

								</div>

							</div></td>
						<td width="20%"><span class="viewsetting"><s:property
									value="s.getViewsetting()" /></span></td>
						<td width="10%"><a href="#" class="viewsetting1"
							onclick="viewsetting()">Edit</a></td>
					</tr>
					
					
					
					
					<tr class="table-hover">
						<td class="boldText" rowspan="2">Who can contact me?</td>
						<td>Who can send you friend requests?
						<br><br>
						<div class="editfriendsetting" style="display: none;">

										
										 <select id="frndsetting">
													<option><a href="#">Everyone</a></option>
													<option><a href="#">Friends of Friends</a></option>
													
												</select>
												

								<br><br>
								<div style="padding-top: 10px;">
									<button type="button" class="btn btn-xs btn-primary"
										onclick="updatefriendsetting()">Save changes</button>
									<button type="button" class="btn btn-xs btn-default"
										onclick="friendsetting()">Close</button>

								</div>

							</div>	
						
						</td>
						<td><span class="friendsetting"><s:property value="s.getFriendreqsetting()" /></span></td>
						<td><a href="#" class="friendsetting1" onclick="friendsetting()">Edit</a></td>
					</tr>
					
					
					
				<%-- 	<tr class="table-hover">

						<td>Who can send you messages?
						<br><br>
						<div class="editmsgsetting" style="display: none;">

										
										 <select id="setting">
													<option><a href="#">Everyone</a></option>
													<option><a href="#">Friends</a></option>
													
												</select>
												

								<br><br>
								<div style="padding-top: 10px;">
									<button type="button" class="btn btn-xs btn-primary"
										onclick="updatemsgsetting()">Save changes</button>
									<button type="button" class="btn btn-xs btn-default"
										onclick="msgsetting()">Close</button>

								</div>

							</div>	
						
						
						</td>
						<td><span class="msgsetting"><s:property value="s.getMessagesetting()" /></span></td>
						<td><a href="#" class="msgsetting1" onclick="msgsetting()">Edit</a></td>
					</tr> --%>

				</tbody>
			</table>

		</div>

	</div>

</body>
</html>