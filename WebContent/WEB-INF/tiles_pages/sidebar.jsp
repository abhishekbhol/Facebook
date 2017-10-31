<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<style>
	.popover.left>.arrow{
		margin-top: -70px;
	}
	.popover.left{
		margin-top: 5%;
		margin-left: -3%;
		min-width: 30%;

	}
</style>
<script>
$(document).ready(function(){
	$("#sidebar").on("keypress","#wish_birthday", function(e){
		debugger;

		if(e.which == 13){
			var wallPostText = $(this).val();
			var parent = $(this).parents("#single_birthday");
			var profileId= parent.find("#bday_profile_id").val();
			var bdayBox = parent.find("#bday_box");
			$.ajax({
				type:'POST',
				url:'/Facebook/module06/addWallPost?wallPostText='+wallPostText+'&postToId='+profileId,
				success : function(data){
					$(bdayBox).html("You wished birthday");
				}
			});
		}
	});
});

</script>
<script type="text/javascript">
$(document).ready(function(){
	var temp='<img src="/Facebook/asset/images/birthday_icon.png" height="20px" width="20px" align="left"/>';
	$.ajax({
		url:'/Facebook/module02/getTodaysBirthDay',
		type:'POST',
		success: function(data){
			$.each(data.todayBirthdayList,function(index,value){
				temp +='<div id="single_birthday"><a href="/Facebook/module02/loadProfilePage?profileId='+value.profile_id+'" style="margin-left:1%;"><img src="'+value.profilePic+'" align="left" width="50px" height="50px">'+value.fname+'&nbsp;'+value.lname+'</a>' ;
				temp +='<div id="bday_box"><input type="text" id="wish_birthday" placeholder="Wish happy birthday..." size="40"/></div>';
				temp += '<input id="bday_profile_id" type="hidden" value="'+value.profile_id+'"></div><br><br>';
				$("#birthday").html(index+1+" friends have birthday");
			});
			
			
			
				 $('#birthday').popover(
						  {
						     trigger: 'click',
						     title:'Birthdays Today',
						     html: true,
						     placement: 'left',
						     content: temp
					  });
			
		}
	});
	
});

</script>

<script>
	$(document).ready(function(){
		setInterval(refreshPeopleYouMayKnow, 7000);
	});
	function refreshPeopleYouMayKnow(){
		var temp="";
		$.ajax({
			url:'/Facebook/module02/peopleYouMayKnow',
			type: 'POST',
			success:function(data){
				$.each(data.mayKnownPeople,function(index,value){
					temp+='<div id="people"; class="friendRequestId" style="height:60px;width:96%; border: 1px solid; border-color: rgb(211, 214, 219); margin-top: 2%; margin-left: 2%;">'+'<a href="/Facebook/module02/loadProfilePage?profileId='+value.profile_id+'"><img src="'+value.friendprofilepic+'" style="height: 60px; width: 60px; float: left;" /></a>';
					temp+='<div style="margin-top: 5%;">&nbsp;<a href="/Facebook/module02/loadProfilePage?profileId='+value.profile_id+'" style="color: rgb(59, 89, 152); font-size: 12px; font-weight: bold; float: left; margin-left:1%;">'+value.fname+'&nbsp;'+value.lname+'<a>';
					temp+='<input type="hidden" value='+value.profile_id+' class="hiddenpid">';
					temp+='<div id="buttondivid" style="margin-bottom:-10%;" ><input type="button" class="addFriendClass" value="Add Friend" style="height:20px; width:25%; font-size:10px; float: right; margin-right:13%;" /></div>';
					temp+='</div></div>';
				});
				$("#peoplesContainerId").hide();

				$("#peoplesContainerId").html(temp);
				$("#peoplesContainerId").fadeIn(1000);
			
			}
		});
	}
</script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#peoplesContainerId").on("click",".addFriendClass", function(e){
			e.stopPropagation();
			var parent=$(this).parents(".friendRequestId");
			var pid= parent.find(".hiddenpid");
			var buttonDiv = parent.find("#buttondivid");
			var pidValue= $(pid).val();
		$.ajax({
			url:'/Facebook/module02/peopleYouMayKnowFriendRequest?profileId='+pidValue,
			type:'POST',
			success:function(data)
			{
				var temp='<h6>friend request send</h6>';
				$(buttonDiv).html(temp);
				$(parent).fadeOut(1000);
			}
			
		});
	});
	});	
</script>
<br>
&nbsp;&nbsp;<div class="clickable" style="cursor: pointer;float:left;margin-left: 3%" id="birthday"></div>
<hr>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Advertisment
<div style="height: 460px; background-color:white;  margin-top: 51%; overflow-y:auto ">
	<h5 align="center">People You May Know</h5>

<hr>

<!-- Division to show people you may know results -->
<div id="peoplesContainerId" >

</div>
</div>