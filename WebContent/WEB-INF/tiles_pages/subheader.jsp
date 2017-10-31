<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
 <script>
 $(document).ready(function(){
	 $("#changecoverid").hide();
		
		$("#coverdivid").mouseenter(function(){
			$("#changecoverid").show();	
			});
		
		$("#coverdivid").mouseleave(function(){
			$("#changecoverid").hide();	
		});
});
 

 function pokeCall(){
	 alert("In poke");
 	$.ajax({
 		type: 'POST',
 		url:'/Facebook/module08/InsertPoke',
 		success:function(data){
 			var temp=data.poketext;
 			$("#modal-text").text(temp);
 		}
 		});
 		e.preventDefault();
 	};


</script>  
		<div id="profile_pic_update" class="modal fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Update Profile Picture</h4>
						</div>
						<div class="modal-body" id="update_profile_pic">
									<s:form action="/Facebook/updateProfilePicture" method="post" enctype="multipart/form-data">
										<s:file name="userImage" label="Select Profile Picture"></s:file>
										<s:submit value="Upload"></s:submit>
									</s:form>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<div id="cover_pic_update" class="modal fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Update Cover Picture</h4>
						</div>
						<div class="modal-body" id="update_profile_pic">
									<s:form action="/Facebook/updateCoverPicture" method="post" enctype="multipart/form-data">
										<s:file name="userImage" label="Select Profile Picture"></s:file>
										<s:submit value="Upload"></s:submit>
									</s:form>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
<div id="coverdivid" style="height:320px;width:100%; margin-top:2%; position: relative;">
		
	 <img src='<s:property value="user.getCoverpicFileName()"/>'  style="height:320px;width:100%; position: relative;z-index: 1;">	
	
	<p style="position: absolute; z-index: 100; left: 190px; top:280px; font-weight: bold; color: white; font-size: 20px;border: black; "><s:property value="user.getFname()"/>&nbsp;<s:property value="user.getLname()"/></p>
<%-- 			<s:if test="%{#session.user.getProfile_id() == #session.currentProfile}">
		
				<input type="button" value="Update Info" style="background-color:rgb(251, 251, 252);position: absolute; font-size:12px; font-weight:bold; z-index: 100; left: 85%; bottom:3%;">
			</s:if> --%>
			
	<s:if test="%{#session.user.getProfile_id() == #session.currentProfile}">
	<div id="changecoverid" style="font-size: 12px; font-weight: bold; height:7%; width:12%; border:1px solid; background-color:rgb(251, 251, 252);  color: ; margin-top:-15%;  margin-left: 85%; z-index: 100; position: absolute;">
				
					<input type="button" data-toggle="modal" data-target="#cover_pic_update" class="filestyle" data-input="false" id="filestyle-0" tabindex="-1" style="position: absolute; left: -9999px;" />
					
						<label for="filestyle-0" class="btn" style="margin-top: -6%; margin-left: -6%; font-size: 12px; font-weight:bold;" ><i class="icon-folder-open"></i> Change Cover</label>
	</div>
	
	</s:if>
	<div style="position:absolute; top:0; ; z-index:2 ;  height:150px; width:150px; border:1px solid; margin-top:24%; margin-left:2%; border:1px solid; border-color: rgb(211, 214, 219);">
		<s:if test="%{#session.user.getProfile_id() == #session.currentProfile}">
		
				<a href="#profile_pic_update" data-toggle="modal" data-target="#profile_pic_update" >
		</s:if>
		<img src='<s:property value="user.getProfilePic()" />' style="height:148px; width: 148px;" data-toggle="tooltip" data-placement="left" title="Click to update profile picture">
		<s:if test="%{#session.user.getProfile_id() == #session.currentProfile}">
		
			</a>
		</s:if>
	</div>
	
</div>


<nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid" style="position: relative; background-color: white;" >
        
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          
         
         
          
          <ul class="nav navbar-nav navbar-left">
       
       		<li>.</li>
       		<li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li>
       		<li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li><li>.</li>
       		
       		<li style="font-weight: bold; "><a href="/Facebook/module03/Call_To_geteductaiondata" style="color: rgb(82, 110, 166);">About</a></li>
       		<li style="font-weight: bold; "><a href="#" style="color: rgb(82, 110, 166);">Photo</a></li>
            <li style="font-weight: bold; ">
            <s:url namespace="/module02" action="/Facebook/module02/friends" var="loadFriends">
            	<s:param name="profileId">
            		<s:property value="user.getProfile_id()"/>
            	</s:param>
            </s:url>
            <s:a href="%{loadFriends}" style="color: rgb(82, 110, 166);">Friends</s:a></li>
            <s:if test="%{#session.currentProfile != #session.user.getProfile_id()}">
            <li style="font-weight: bold; ">
           
              <a href="#" onclick="pokeCall()" data-toggle="modal"
					data-target="#mymodal" aria-hidden="true" style="color: rgb(82, 110, 166);margin-left: 10%;">Poke</b></a>
            
             </li>
            </s:if>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    
    	<div class="modal fade" id="mymodal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<form action="/Facebook/module05/createEventAction">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header" style="background-color: #6d84b4;">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Poke</h4>
						</div>
						
						<div id="modal-text">
						<br>
						<br>
						</div>
						

					</div>

				</div>
			
			</form>

		</div>