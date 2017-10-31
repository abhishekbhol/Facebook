<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EVENT</title>

<!--<script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
                $('#example1').datepicker({
                    format: "yyyy-mm-dd"
                });  
            
            }); 
        </script>-->

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#inviteBtn")
								.click(
										function(event) {
											debugger;
											var temp = '<form>';
											$
													.ajax({
														url : "/Facebook/module05/loadFriendstoInvite",
														type : 'POST',
														success : function(data) {
															var i = 1;
															$
																	.each(
																			data.friendlist,
																			function(
																					index,
																					value) {
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
															$(
																	"#invitemodal-body")
																	.html(temp);

														}
													});
										});
						
	$("#inviteStatus").click(function(event){
							
							alert($("#inviteStatus").val());
							alert($("#hiddeneventId").val());
							var temp =$(this).val();
							$.ajax({
								url : "/Facebook/module05/changeJoinStatus?joinStatus="+temp+'&eventId='+$("#hiddeneventId").val(),
								type : 'POST',
								success : function(data) {
									
									temp= data.joinStatus;
									alert(temp);
									$("#joinstat").append(temp);
								
								}
							
								});
						});
						
						
	$("#inviteStatus1").click(function(event){
		
		alert($("#inviteStatus1").val());
		alert($("#hiddeneventId").val());
		var temp1 =$("#inviteStatus1").val();
		$.ajax({
			url : "/Facebook/module05/changeJoinStatus?joinStatus="+temp1+'&eventId='+$("#hiddeneventId").val(),
			type : 'POST',
			success : function(data) {
				
				temp1= data.joinStatus;
				alert(temp1);
				$("#joinstat").append(temp1);
			
			}
		
			});
	});
	
$("#inviteStatus2").click(function(event){
		
		alert($("#inviteStatus2").val());
		alert($("#hiddeneventId").val());
		var temp2 =$(this).val();
		$.ajax({
			url : "/Facebook/module05/changeJoinStatus?joinStatus="+temp2+'&eventId='+$("#hiddeneventId").val(),
			type : 'POST',
			success : function(data) {
				
				temp2= data.joinStatus;
				alert(temp2);
				$("#joinstat").append(temp2);
			
			}
		
			});
	});
	
	
	
	

					});

	function saveInvited() {
		var idString = "";
		var count = 0;

		$('#selectFriend:checked').each(function() {
			if (count != 0) {
				idString += "," + $(this).val();

			} else
				idString += $(this).val();

			count++;
		});
		count += " Friends Invited";

		// $("#inviteBtn").hide();
		$("#invitedCount").append(count);
		$("#hiddenField").val(idString);
		$("#invitemodal").hide();
		$("#inviteBtn").hide();

	}
</script>

<link rel="stylesheet" href="/Facebook/asset/css/datepicker.css">

<link rel="stylesheet" type="text/css"
	href="/Facebook/asset/css/eventlist.css">

<sx:head />

</head>
<body>
	<div id="main-content">
		<div class="main-header">
			<span id="createEventBtn"><button
					class="btn btn-default btn-sm" data-toggle="modal"
					data-target="#mymodal" aria-hidden="true">
					<b> + Create Event</b>
				</button> </span>
			<h3>
				<b>Events</b>
			</h3>


		</div>
		<div class="upcoming-events">
			<div class="upcoming-events-header">
				<h4>
					<b>Upcoming Events</b>
				</h4>
			</div>

		</div>
		<!-- trying hasmap

<s:iterator value="datedEventMap">
  <h3><s:property value="key" /></h3>
  <table>
  <s:iterator value="value">
    <tr><td><s:property value="eventTitle"/></td></tr>
  </s:iterator>
  </table>
</s:iterator>  -->


		<div class="all-eventslist">
			<s:iterator value="datedEventMap">
				<div class="event-row">
					<div class="event-header">
						<s:property value="key" />
					</div>
					<div class="event-content">
						<ul>
							<s:iterator value="value">
								<s:if test="isBirthday==0">
									<li>
										<table width="40%">

											<tr>
												<td rowspan="4" valign="top" width="20%"><s:property
														value="eventTime" /></td>
												<td rowspan="4"><a class="_8o _8t lfloat _ohe" href="">
														<img class="event-img"
														src="<s:property value='eventPhoto'/>" />
												</a></td>
												<td>
												<input type="hidden" id="hiddeneventId" value="<s:property value="eventId"/>">
												<a
													href='/Facebook/module05/loadSpecificEvent?eventId=<s:property value="eventId"/>'><s:property
															value="eventTitle" /></a></td>
											</tr>
											<tr>

												<td><s:property value="event_where" /></td>
											</tr>
											
											<s:if test="%{ eventOwnerId == #session.user.getProfile_id()}">
														
											</s:if>
											<s:else>
											<tr><td  id="joinstat"></td></tr>
												<tr>
													<td>
														<button id="inviteStatus" class="btn btn-default btn-sm"
															value="Going">
															<b> Going</b>
														</button>
													</td>


													<td>
														<button id="inviteStatus1" class="btn btn-default btn-sm"
															value="NotGoing">
															<b>Not Going</b>
														</button>
													</td>


													<td>
														<button id="inviteStatus2" class="btn btn-default btn-sm"
															value="Maybe">
															<b>May Be</b>
														</button>
													</td>
												</tr>
											</s:else>
											

										</table>
									</li>
								</s:if>
								<!-- else for birthday events -->
								<s:if test="isBirthday==1">
									<table>
										<tr>
											<td>Birthday</td>
											<td><a
												href='/Facebook/module02/loadProfilePage?profileId=<s:property value="eventOwnerId"/>'>
													<img class="event-img"
													src="<s:property value='eventPhoto'/>" />
											</a></td>
										</tr>
									</table>
								</s:if>

							</s:iterator>
						</ul>
					</div>
				</div>
			</s:iterator>

		</div>


		<div class="modal fade" id="mymodal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<form action="/Facebook/module05/createEventAction">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header" style="background-color: #6d84b4;">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Create Event</h4>
						</div>
						<div class="modal-body" id="createEventBody">

							Name: &nbsp; &nbsp;<input type="text"
								placeholder="Ex. Birthday Party" name="eventTitle" required="true" /><br>
							<br> Details:<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp;
							<textarea rows="3" cols="50" placeholder="Add more info."
								name="description" required="true"></textarea>
							<br>
							<br> Where: &nbsp; &nbsp; <input type="text" value=""
								placeholder="Add a place." name="event_where" required="true" /><br>
							<br> When: &nbsp; &nbsp;<input type="text"
								placeholder="click to show datepicker" id="example1"
								name="eventDateTemp" required="true">(yyyy-mm-dd)  &nbsp; &nbsp;<input type="text"
								placeholder="Add a time." name="eventTime" required="true"/> <br>
								 <input 	type="hidden" id="hiddenField" name="invitedFriendIds" required="true" /> <br>
							<p id="invitedCount"></p>

						</div>
					</div>

				</div>
				<div class="modal-footer">
					<span id="inviteBtn"><button type="button"
							class="btn btn-default btn-sm" data-toggle="modal"
							data-target="#invitemodal" aria-hidden="true">
							<span class="glyphicon glyphicon-envelope"> </span> Invite Friend
						</button> </span>

					<button type="submit" class="btn btn-primary">Save</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				</div>
			</form>

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
	</div>



</body>
</html>