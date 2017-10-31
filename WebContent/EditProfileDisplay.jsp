
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" import="java.sql.*" errorPage=""%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Display</title>

<script src="/Facebook/asset/js/jquery-1.9.1.min.js"  type="text/javascript"></script>

<link rel="stylesheet" type="text/css"
	href="/Facebook/asset/css/ProfileDisplay.css">

<script type="text/javascript">
<!-- block means show -->
	function ShowWorkEducationForm()

	{
		var ele = document.getElementById("form_workeducation");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}
	
	function AddWorkEducationForm()

	{
		var ele = document.getElementById("form_addworkeducation");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}

	function ShowRelationshipForm()

	{
		var ele = document.getElementById("form_relation");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}
	
	
	function AddRelationshipForm()

	{
		var ele = document.getElementById("form_addrelation");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}

	function ShowAboutmeForm() {
		var ele = document.getElementById("form_aboutme");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}
    
	
	function AddAboutmeForm() {
		var ele = document.getElementById("form_addaboutme");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}
	function ShowFavquoteForm()

	{
		var ele = document.getElementById("form_favquote");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}

	
    function AddFavquoteForm()
    {

		var ele = document.getElementById("form_addfavquote");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
    	
    }
	function ShowHometownForm() {
		var ele = document.getElementById("form_hometown");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}

	}

	function AddHometownForm() {
		var ele = document.getElementById("form_addhometown");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}

	}

	function ShowCurrentcityForm() {
		var ele = document.getElementById("form_currentcity");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}

	}

	
	function AddCurrentcityForm() {
		var ele = document.getElementById("form_addcurrentcity");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}

	}
	function ShowLanguageForm() {

		var ele = document.getElementById("form_language");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}

	}

	function AddLanguageForm()
	{
		

		var ele = document.getElementById("form_addlanguage");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}

		
	}
	function ShowGenderForm() {

		
		var ele = document.getElementById("form_gender");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}

	function AddGenderForm()
	{
		

		var ele = document.getElementById("form_addgender");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
		
	}
	function ShowInterestedInForm() {

		var ele = document.getElementById("form_interestedin");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}
	
	

	function AddInterestedInForm()
	{
		
		var ele = document.getElementById("form_addinterestedin");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
		
	}
	
	function ShowReligiousViewForm() {

		var ele = document.getElementById("form_religiousview");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}
	
	function AddReligiousViewForm() {

		var ele = document.getElementById("form_addreligiousview");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}

	function ShowPoliticalViewForm() {

		var ele = document.getElementById("form_politicalview");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}

	
	function AddPoliticalViewForm() {

		var ele = document.getElementById("form_addpoliticalview");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
	}

	
	function ShowPhoneNoForm()
	{
		
		var ele = document.getElementById("form_phoneno");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
		
	}
	

	function AddPhoneNoForm()
	{
		
		var ele = document.getElementById("form_addphoneno");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
		
	}
	
	function ShowEmailIdForm()
	{
		
		var ele = document.getElementById("form_emailid");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
		
	}
	
	function AddEmailIdForm() 
	{
		
		var ele = document.getElementById("form_addemailid");
		if (ele.style.display == "none") {
			ele.style.display = "block";
		} else {
			ele.style.display = "none";
		}
		
	}
	
	//Ajax code

	function updateWork() {

		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updatework.action?title='+ $("#title").val() +"&description=" +$("#desc").val(),
		
					success : function(data) {
						
						
						$('#displaytitle').html(data.title);
						$('#displaydescription').html(data.description);
						

					}
		
		});


		ShowWorkEducationForm();
	
	}
	
	
	
function updateAgainWork() {

		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateAgainwork.action?title='+ $("#title").val() +"&description=" +$("#desc").val(),
		
					success : function(data) {
						
					
						$('#updisplaytitle').html(data.title);
						$('#updisplaydesc').html(data.description);
						$('#addeditlinkwork').html("Edit");

					}
		
		});


		ShowWorkEducationForm();
	
	}
	
	function AddWork()
	{
		
		
		

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updatework.action?title='+ $("#addtitle").val() +"&description=" +$("#adddesc").val(),
		
					success : function(data) {
		
						
						$('#addworkeducationdetails').css('display', 'block');
						$('#updateworkeducationdetails').css('display', 'block');
						
						
						$("#adddisplaytitle").html(data.title);
						
					
						$('#adddisplaydesc').html(data.description);
						
						$('#addeditlinkwork').html("Edit");
						$('#addremovelinkwork').html("Remove");
						
						document.getElementById("addtitle").value=" ";
						document.getElementById("adddesc").value=" ";
						
						
						
						 
						}

				});

		AddWorkEducationForm();
		
	}
	
	
	var id2;
    function DeleteWork(id2)
	{
    	debugger;
		var element = $(this);

       alert(id2);
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/deletework.action?workeducation_id='+id2,
		
					success : function(data) {
						
						$('#updateworkeducationdetails').css('display', 'block');

						$('#parent').css('display', 'none');

						
						
						

					}
		
		});


	
		
	
	
		
			
		
	}

	function updateRelationshipStatus() {

		var id = document.getElementById("relationship_id");
		var status = id.options[id.selectedIndex].text;

		$.ajax({

					type : 'POST',
					url : '/Facebook/module03/updateRelationship.action?relationshipStatus='+ status,
					success : function(data) {

						$('#updaterelationshipdetails').css('display', 'block');
						$('#displaystatus').html(data.relationshipStatus);

					}

				});

		ShowRelationshipForm();
		var ele = document.getElementById("displayaddrelationship");
		if (ele.style.display == "block") {
			ele.style.display = "none";
		} else {
			ele.style.display = "none";
		}
		
		
		var ele1= document.getElementById("afterdeletionaddrelationship");
		ele1.style.display = "none";
	}
	

	
function AddRelationshipStatus()
{
	
	var id = document.getElementById("addrelationship_id");
	var status = id.options[id.selectedIndex].text;

	$.ajax({

				type : 'POST',
				url : '/Facebook/module03/updateRelationship.action?relationshipStatus='+ status,
				success : function(data) {

					
					var ele1= document.getElementById("afterdeletionaddrelationship");
					ele1.style.display = "none";
					
				
					
					$('#addrelationshipdetails').css('display', 'block');
					$('#adddisplaystatus').html(data.relationshipStatus);
					$('#addremovelinkre').html("Remove");
					$('#addeditlinkre').html("Edit");

				}

			});

	AddRelationshipForm();
	var ele = document.getElementById("displayaddrelationship");
	ele.style.display = "none";
		
	
}


function DeleteRelationshipStatus()
{
	


	$.ajax({

				type : 'POST',
				url : '/Facebook/module03/updateRelationship.action?relationshipStatus='+"",
				success : function(data) {

			$('#addrelationshipdetails').css('display', 'none');
			$('#updaterelationshipdetails').css('display', 'none');
			$('#afterdeletionaddrelationship').html("Add RelationShip Status");				

		}

	});


	
		
	var ele1= document.getElementById("afterdeletionaddrelationship");
	ele1.style.display = "block";
		
	
}

	function updateAboutMe() {

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateAboutMe.action?aboutMe='+ $("#aboutme_id").val(),
			success : function(data) {
                
				$('#displayaboutme').html(data.aboutMe);

			}

		});

		ShowAboutmeForm();
	}
	
	function AddAboutMe() {

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateAboutMe.action?aboutMe='+ $("#addaboutme_id").val(),
			success : function(data) {
				
				var ele1= document.getElementById("afterdeletionaddaboutme");
				ele1.style.display = "none";
				$('#addaboutmedetails').css('display', 'block');

				$('#adddisplayaboutme').html(data.aboutMe);
				$('#addremovelinkabout').html("Remove");
				$('#addeditlinkabout').html("Edit");

			}

		});

		AddAboutmeForm();
		var ele = document.getElementById("displayaddaboutme");
		ele.style.display = "none";
		
			
	
	}
	
	function DeleteAboutMe() {

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateAboutMe.action?aboutMe='+"",
			success : function(data) {

				$('#addaboutmedetails').css('display', 'none');
				$('#updateaboutmedetails').css('display', 'none');
				$('#afterdeletionaddaboutme').html("Add About Yourself");				

			}

		});


		
			
		var ele1= document.getElementById("afterdeletionaddaboutme");
		ele1.style.display = "block";
			
	
	}
	
	

	function updateFavQuote() {

		//alert($("#favquote_id").val());	 

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateFavQuote.action?favQuote='	+ $("#favquote_id").val(),
			success : function(data) {

				$('#displayfavquote').html(data.favQuote);

			}

		});

		ShowFavquoteForm();
	}

	
	function AddFavQuote() {

		//alert($("#favquote_id").val());	 

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateFavQuote.action?favQuote='	+ $("#addfavquote_id").val(),
			success : function(data) {

				var ele1 = document.getElementById("afterdeletionaddfavquote");
				ele1.style.display = "none";
				
				$('#addfavquotedetails').css('display', 'block');
				$('#adddisplayfavquote').html(data.favQuote);
				$('#addremovelinkfav').html("Remove");
				$('#addeditlinkfav').html("Edit");
			

			}

		});

		AddFavquoteForm();
		var ele = document.getElementById("displayaddfavquote");
		ele.style.display = "none";
		
	
	}
	
	function DeleteFavQuote()
	{
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateFavQuote.action?favQuote='	+"",
			success : function(data) {

				
				$('#addfavquotedetails').css('display', 'none');
				$('#updatefavquotedetails').css('display', 'none');
				$('#afterdeletionaddfavquote').html("Add Favourite Quotation");
			}

		});

	
	
		var ele = document.getElementById("afterdeletionaddfavquote");
		ele.style.display = "block";
		
	}
	
	function UpdateHomeTown() {
		$.ajax({
			type : 'POST',
			url : '/Facebook/module03/updateHomeTown.action?homeTown='+ $("#hometown_id").val(),
			success : function(data) {
 
				
				$('#displayhometown').html(data.homeTown);

			}

		});

		ShowHometownForm();
	
	}

	


	
	function AddHomeTown() {
		$.ajax({
			type : 'POST',
			url : '/Facebook/module03/updateHomeTown.action?homeTown='+ $("#addhometown_id").val(),
			success : function(data) {
				$('#addhometowndetails').css('display', 'block');
				
				$('#adddisplayhometown').html(data.homeTown);
				$('#removelinkhome').html("Remove");
				$('#editlinkhome').html("Edit");
				$('#deschome').html("homeTown");
			}

		});

		AddHometownForm();
		var ele = document.getElementById("afterdeletionaddhometown");
		ele.style.display = "none";
		
		var ele = document.getElementById("displayaddhometown");
		ele.style.display = "none";
			
		
	}

//delete hometown
	
	function DeleteHomeTown() {
		$.ajax({
			type : 'POST',
			url : '/Facebook/module03/updateHomeTown.action?homeTown='+"",
			success : function(data) {
				$('#addhometowndetails').css('display', 'none');
				$('#hometown_updatedetails').css('display', 'none');
				$('#afterdeletionaddhometown').html("Add HomeTown");
				
				
			}

		});
		
		var ele = document.getElementById("afterdeletionaddhometown");
		ele.style.display = "block";	
	}
	
	function UpdateCurrentCity() {

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateCurrentCity.action?currentCity='+ $("#currentcity_id").val(),
			success : function(data) {

				$('#displaycurrentcity').html(data.currentCity);
			
			}

		});

		
		ShowCurrentcityForm();
		
	}	
	
	function AddCurrentCity() {

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateCurrentCity.action?currentCity='+ $("#addcurrentcity_id").val(),
			success : function(data) {
				
				$('#addcurrentcitydetails').css('display', 'block');
			    $('#adddisplaycurrentcity').html(data.currentCity);
				 $('#removelinkcity').html("Remove");
				$('#editlinkcity').html("Edit");
				$('#desccity').html("Current City");
			}

		});

		
	   AddCurrentcityForm();
		
		var ele = document.getElementById("afterdeleteaddcurrentcity");
		ele.style.display = "none";
		
		var ele = document.getElementById("displayaddcurrentcity");
		ele.style.display = "none";
	}
	
	function DeleteCurrentCity() {
		$.ajax({
			type : 'POST',
			url : '/Facebook/module03/updateCurrentCity.action?currentCity='+"",
			success : function(data) {
				$('#addcurrentcitydetails').css('display', 'none');
				$('#updatecurrentcitydetails').css('display', 'none');
				$('#afterdeleteaddcurrentcity').html("Add CurrentCity");
				
				
			}

		});
		
		var ele = document.getElementById("afterdeleteaddcurrentcity");
		ele.style.display = "block";	
	}
	

	function updateLanguage() {
       
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateLanguage.action?languageKnown='+$("#language_id").val(),
			success : function(data) {

				$('#displaylanguage').html(data.languageKnown);

			}

		});

		ShowLanguageForm();
	}
	
	
function AddLanguage() {
       
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateLanguage.action?languageKnown='+$("#addlanguage_id").val(),
			success : function(data) {

				var ele1 = document.getElementById("afterdeletionaddlanguage");
				ele1.style.display = "none";
				
				$('#addlanguagedetails').css('display', 'block');
				$('#adddisplaylanguage').html(data.languageKnown);
				$('#lablelanguage').html("Language Known :");
				$('#addremovelinklang').html("Remove");
				$('#addeditlinklang').html("Edit");
			}

		});

		AddLanguageForm();
		var ele = document.getElementById("displayaddlanguage");
		ele.style.display = "none";
		
		
			
	}
	
	
	function DeleteLanguage()
	{
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateLanguage.action?languageKnown='+"",
			success : function(data) {

				$('#addlanguagedetails').css('display', 'none');
				$('#updatelanguagedetails').css('display', 'none');
				$('#afterdeletionaddlanguage').html("Add Languages You Know");
			}

		});

		var ele = document.getElementById("afterdeletionaddlanguage");
		ele.style.display = "block";
		
		
	}
	
	function updateGender() 
	{
		
		var id = document.getElementById("gender_id");
		var gender = id.options[id.selectedIndex].text;
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateGender.action?gender='+ gender,
			success : function(data) {
				
				$('#displaygender').html(data.gender);

			}

		});

		ShowGenderForm();
	}

	
	function AddGender() 
	{
		
		var id = document.getElementById("addgender_id");
		var gender = id.options[id.selectedIndex].text;
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateGender.action?gender='+ gender,
			success : function(data) {
				
				$('#addgenederdetails').css('display', 'block');
                $('#adddisplaygender').html(data.gender);
                $('#genderlable').html("Gender :");
				$('#addremovelinkgender').html("Remove");
				$('#addeditlinkgender').html("Edit");

			}

		});

		AddGenderForm();
		var ele = document.getElementById("displayaddgender");
		ele.style.display ="none";
		var ele = document.getElementById("afterdeletionaddgender");
		ele.style.display = "none";
			
	}

	
	
	
	function DeleteGender()
	{
		

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateGender.action?gender='+ "",
			success : function(data) {

				$('#addgenderdetails').css('display', 'none');
				$('#updategenderdetails').css('display', 'none');
				$('#afterdeletionaddgender').html("Add Gnender");
			}

		});

		var ele = document.getElementById("afterdeletionaddgender");
		ele.style.display = "block";
		
		
			

		
	}
	
	function updateInterestedIn() 
	{
		
		var id = document.getElementById("interestedin_id");
		var interest = id.options[id.selectedIndex].text;
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateInterestedIn.action?interestedIn='+ interest,
			success : function(data) {

				$('#displayinterestedin').html(data.interestedIn);

			}

		});

		ShowInterestedInForm();
	}
	
	function AddInterestedIn()
	{
		
		var id = document.getElementById("addinterestedin_id");
		var interest = id.options[id.selectedIndex].text;
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateInterestedIn.action?interestedIn='+ interest,
			success : function(data) {
				
				var ele1 = document.getElementById("afterdeletionaddinterestedin");
				ele1.style.display = "none";

				$('#addinterestedindetails').css('display', 'block');
				$('#adddisplayinterestedin').html(data.interestedIn);
				$('#interestlable').html("Interested In :");
				$('#addremovelinkin').html("Remove");
				$('#addeditlinkin').html("Edit");

			}

		});

		AddInterestedInForm();
		var ele = document.getElementById("displayaddinterestedin");
		ele.style.display = "none";
		
		
	}
	
	
	function DeleteInterestedIn()
	{
		

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateInterestedIn.action?interestedIn='+"",
			success : function(data) {

				$('#addinterestedindetails').css('display', 'none');
				$('#updateinterestedindetails').css('display', 'none');
				$('#afterdeletionaddinterestedin').html("Add Interested In");
			}

		});

		var ele = document.getElementById("afterdeletionaddinterestedin");
		ele.style.display = "block";
		
		
			

		
	}
	
	function updateReligiousView() 
	{

		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateReligiousView.action?religiousView='+ $("#religiousview_id").val(),
			success : function(data) {

				$('#displayreligiousview').html(data.religiousView);

			}

		});

		ShowReligiousViewForm();
	}
	
	
	
	function AddReligiousView() 
	{

		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateReligiousView.action?religiousView='+ $("#addreligiousview_id").val(),
			success : function(data) {

				
				var ele1 = document.getElementById("afterdeletionaddreligiousview");
				ele1.style.display ="none";
				
				$('#addreligiousviewdetails').css('display', 'block');
				$('#adddisplayreligiousview').html(data.religiousView);
				$('#religiousviewlable').html("Add Religious View");
				$('#addremovelinkreligious').html("Remove");
				$('#addeditlinkreligious').html("Edit");

			}

		});

		AddReligiousViewForm();
		
		var ele = document.getElementById("displayaddreligiousview");
		ele.style.display ="none";
		
	}
	
	

	function DeleteReligiousView() 
	{

		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateReligiousView.action?religiousView='+"",
			success : function(data) {

				$('#addreligiousviewdetails').css('display', 'none');
				$('#updatereligiousviewdetails').css('display', 'none');
				$('#afterdeletionaddreligiousview').html("Add Religious View");
                
				
			}

		});

		
		var ele = document.getElementById("displayaddreligiousview");
		ele.style.display ="none";
		
		var ele1 = document.getElementById("afterdeletionaddreligiousview");
		ele1.style.display ="Block";
		
	}
	
	
	function updatePoliticalView() 
	{
		
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updatePoliticalView.action?politicalView='+ $("#politicalview_id").val(),
			success : function(data) {

				$('#displaypoliticalview').html(data.politicalView);

			}

		});

		ShowPoliticalViewForm();
	}
	
	

	function  AddPoliticalView() 
	{
		
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updatePoliticalView.action?politicalView='+ $("#addpoliticalview_id").val(),
			success : function(data) {
				
				var ele1 = document.getElementById("afterdeletionaddpoliticalview");
				ele1.style.display ="none";
				
				$('#addpoliticalviewdetails').css('display', 'block');

				$('#adddisplaypoliticalview').html(data.politicalView);
				$('#politicalviewlable').html("Political View :");
				$('#addremovelinkpolitical').html("Remove");
				$('#addeditlinkpolitical').html("Edit");

			}

		});

		AddPoliticalViewForm();
		var ele = document.getElementById("displayaddpoliticalview");
		ele.style.display = "none";
		
	}
	
	
	function  DeletePoliticalView() 
	{
		
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updatePoliticalView.action?politicalView='+"",
			success : function(data) {
				

				
				$('#addpoliticalviewdetails').css('display', 'none');
				$('#updatepoliticalviewdetails').css('display', 'none');
                 $('#afterdeletionaddpoliticalview').html("Add Political View");
			

			}

		});

		var ele = document.getElementById("displayaddpoliticalview");
		ele.style.display = "none";
		
		var ele = document.getElementById("afterdeletionaddpoliticalview");
		ele.style.display = "block";
		
	}
	
	
	function updateEmailId()
	{

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateEmailId.action?email='+ $("#email_id").val(),
			success : function(data) {

				$('#displayemailid').html(data.email);

			}

		});

		ShowEmailIdForm();
		
	
	}
	
	function AddEmailId()
	{

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateEmailId.action?email='+ $("#addemail_id").val(),
			success : function(data) {

				
				var ele1 = document.getElementById("afterdeletionaddemailid");
				ele1.style.display ="none";
				
				$('#addemailiddetails').css('display', 'block');
				
				$('#adddisplayemailid').html(data.email);
				$('#emailidlable').html("Email Id :");
				$('#addremovelinkemailid').html("Remove");
				$('#addeditlinkemailid').html("Edit");

			}

		});

		AddEmailIdForm();
		
		var ele = document.getElementById("displayaddemailid");
		ele.style.display = "none";
			
	}
	
	
	function  DeleteEmailId()
	{
		
		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updateEmailId.action?email='+"",
			success : function(data) {

				
				var ele1 = document.getElementById("afterdeletionaddemailid");
				ele1.style.display ="block";
				
				$('#addemailiddetails').css('display', 'none');
				$('#updateemailiddetails').css('display', 'none');
				$('#afterdeletionaddemailid').html("Add Your Email Id ");
				
				

			}

		});

		
		var ele = document.getElementById("displayaddemailid");
		ele.style.display = "none";
	}
	
	
	function updatePhoneNo()
	{

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updatePhoneNo.action?phoneNo='+ $("#phoneno_id").val(),
			success : function(data) {

				$('#displayphoneno').html(data.phoneNo);

			}

		});

		ShowPhoneNoForm();
		
		
	}
	
	function AddPhoneNo()
	{

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updatePhoneNo.action?phoneNo='+ $("#addphoneno_id").val(),
			success : function(data) {

				var ele1 = document.getElementById("afterdeletionaddphoneno");
				ele1.style.display ="none";
				
				$('#addphonenodetails').css('display', 'block');
				
				$('#adddisplayphoneno').html(data.phoneNo);
				$('#phonenolable').html("Phone No");
				$('#addremovelinkphoneno').html("Remove");
				$('#addeditlinkphoneno').html("Edit");

			}

		});

		AddPhoneNoForm();
		
		var ele = document.getElementById("displayaddphoneno");
		ele.style.display = "none";
		
		
		
	}
	
	
	
	function DeletePhoneNo()
	{

		$.ajax({

			type : 'POST',
			url : '/Facebook/module03/updatePhoneNo.action?phoneNo='+"",
			success : function(data) {

				var ele1 = document.getElementById("afterdeletionaddphoneno");
				ele1.style.display ="block";
				
				$('#addphonenodetails').css('display', 'none');
				$('#updatephonenodetails').css('display', 'none');
				
				$('#afterdeletionaddphoneno').html("Add Phone Number Here.");
				

			}

		});


		
		var ele = document.getElementById("displayaddphoneno");
		ele.style.display = "none";
	}
	
	
	$(document).ready(function(){
		debugger;
		$("#updateworkeducationtitle").on("click","#removelink",function(e){
			debugger;
			var parent = $(this).parents(".single_work");
			
			$(parent).hide();
		});
	});
	
	

	
</script>
<sx:head />
</head>


<body>
	    <!-- code for hiding button and edit things from friends profile -->
	  
	    <script type="text/javascript">
	    
         $(document).ready(function(){
	var currentProfileId = $("#current_profile").val();
	var loggedIn = $("#logged_in_profile").val();
	
			
	if(currentProfileId != loggedIn)
		{
			$(".hrefclass").hide();
			
			$(".basicinfoclass").hide();
			
			
			$(".addhyperlink").hide();
			
			
			$("#button_workeducation").hide();
			
		}
	
	else
		{
		
		}
		});
		
	</script>
	
	
	
	
	
	
	<input type="hidden" id="current_profile" value='<s:property value="#session.currentProfile"/>'/>
    <input type="hidden" id="logged_in_profile" value='<s:property value="#session.user.getProfile_id()"/>'/>
	
	<!-- validation code for empty field -->
	
	<script type="text/javascript">
	
	<!--about me-->
	
	$(document).ready(function(){
		$('#addtitle').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addjob').removeAttr('disabled'); 
			}else{ 
				$('#button_addjob').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#aboutme_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_about').removeAttr('disabled'); 
			}else{ 
				$('#button_about').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addaboutme_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addabout').removeAttr('disabled'); 
			}else{ 
				$('#button_addabout').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#favquote_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_favquote').removeAttr('disabled'); 
			}else{ 
				$('#button_addfavquote').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addfavquote_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addfavquote').removeAttr('disabled'); 
			}else{ 
				$('#button_addfavquote').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	

	$(document).ready(function(){
		$('#hometown_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_home').removeAttr('disabled'); 
			}else{ 
				$('#button_home').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addhometown_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addhome').removeAttr('disabled'); 
			}else{ 
				$('#button_addhome').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#currentcity_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_city').removeAttr('disabled'); 
			}else{ 
				$('#button_city').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addcurrentcity_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addcity').removeAttr('disabled'); 
			}else{ 
				$('#button_addcity').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#language_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_language').removeAttr('disabled'); 
			}else{ 
				$('#button_language').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addlanguage_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addlanguage').removeAttr('disabled'); 
			}else{ 
				$('#button_addlanguage').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	

	$(document).ready(function(){
		$('#religiousview_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_religiousview').removeAttr('disabled'); 
			}else{ 
				$('#button_religiousview').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addreligiousview_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addreligiousview').removeAttr('disabled'); 
			}else{ 
				$('#button_addreligiousview').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	$(document).ready(function(){
		$('#politicalview_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_politicalview').removeAttr('disabled'); 
			}else{ 
				$('#button_politicalview').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addpoliticalview_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addpoliticalview').removeAttr('disabled'); 
			}else{ 
				$('#button_addpoliticalview').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#phoneno_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_phone').removeAttr('disabled'); 
			}else{ 
				$('#button_phone').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addphoneno_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addphone').removeAttr('disabled'); 
			}else{ 
				$('#button_addphone').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#email_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_email').removeAttr('disabled'); 
			}else{ 
				$('#button_email').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	
	$(document).ready(function(){
		$('#addemail_id').keyup(function(){
			var content = $(this).val();
			if(content.length != 0)
			  { 
				$('#button_addemail').removeAttr('disabled'); 
			}else{ 
				$('#button_addemail').attr('disabled', 'disabled'); 
				} }); 
			  
		});
	
	</script>
	
	 
		
	
	
	
	
	

	
	
	
	
	
	<div id="container1">

		<div id="about">

			<img src="/Facebook/asset/images/person_image.png" width="30px"
				height="30px" style="padding-top: 30px; float: left" />
			<h2 class="lable">
				<a href="C:/Users/Divya M/git/fb/Facebook/WebContent/Profile.html">About</a>
			</h2>
			<input type="button" value="Add" class="button" />
		</div>


		           <div id="leftdivision">

				<div id="work_education">

				
				<h4 class="lable">Work and Education</h4>
				<input type="button" class="button" value="Add"  id="button_workeducation"
					onclick="AddWorkEducationForm();" />

				
				
				<div id="form_addworkeducation" style="display: none;">

					<s:form theme="simple">
						<table>
							<tr>
								<td><label class="formlable">Title</label></td>
								<td valign="bottom"><s:textfield type="text" size="35"
										name="workeducation_title" id="addtitle"
										placeholder="Where you have worked?" /></td>
							</tr>

							<tr>
								<td><label class="formlable">Position</label></td>
								<td valign="bottom"><s:textfield type="text" size="35"
										name="description" id="adddesc" placeholder="short description.." /></td>
							</tr>


						</table>


						<input type="button" class="addbutton" value="Add job"
							onclick="AddWork()"  id="button_addjob" disabled="disabled"/>
						<input type="button" class="cancelbutton" value="Cancel"
							onclick="AddWorkEducationForm();" />
					</s:form>

				</div>


				<div id="addworkeducationdetails">
					
					    <h5 class="data">
							<span id="adddisplaytitle"></span>
						</h5>
						
                       <div  class="hrefclass" style="float:right"> <a  id="addremovelinkwork" onclick="DeleteWork(<s:property value="workeducation_id"/>);"></a></div>
			            <div class="hrefclass" style="float:right"> <a id="addeditlinkwork" onclick="AddWorkEducationForm();"></a></div>
					<div style="float: left; width:100%;">
						<h6 class="description">
							<span id="adddisplaydesc"></span>
						</h6>
					</div>

<span id="workeducation_id">  <input type="hidden"  value='<s:property value="workeducation_id"/>'/></span>
				   
					<!--  <div style="float:left;"><h6 class="description">
					<span id="displaystartdate"><label style="color: rgb(102, 102, 102);"></label><s:property value="pfobj. getStartDate() " /></span>
				</h6></div>
				
				<div style="float:left;"><h6 class="description">
					<span id="displayenddate"><label style="color: rgb(102, 102, 102);"></label><s:property value="pfobj.getEndDate() " /></span>
				</h6></div>
				
				 <div style="float:left;"><h6 class="description">
					<span id="displaygraduated"><s:property value="pfobj.getGraduation() " /></span>
				</h6></div>-->
				
				</div>

              
                <div id="updateworkeducationdetails">
				
				<s:iterator value="pfobj.getWorkexlist()" id="workid">
			
				   
				   
				      <input type="hidden" id="workeducation_id" value='<s:property value="workeducation_id"/>'/>
				      
				     
				        <div id="parent">
				    
					    <h5 class="data"  id="uptitle"><s:property value="workeducation_title" /></h5>
					     <div  class="hrefclass" style="float:right"> <a  id="addremovelinkwork" onclick="DeleteWork(<s:property value="workeducation_id"/>);">Remove</a></div>
			            <div class="hrefclass" style="float:right"> <a id="addeditlinkwork" onclick="ShowWorkEducationForm();">Edit</a></div>
			            
					     <h6 class="description" id="updesc"><s:property value="description" /></h6>
					   </div>
					
					
		
				</s:iterator>
				
				<div id="form_workeducation" style="display: none;">

					<s:form theme="simple">
						<table>
							<tr>
								<td><label class="formlable">Title</label></td>
								<td valign="bottom"><s:textfield type="text" size="35"
										name="workeducation_title" id="title"
										placeholder="Where you have worked?" /></td>
							</tr>

							<tr>
								<td><label class="formlable">Position</label></td>
								<td valign="bottom"><s:textfield type="text" size="35"
										name="description" id="desc" placeholder="short description.." /></td>
							</tr>


						</table>


						<input type="button" class="addbutton" value="Add job"
							onclick="updateWork()" />
						<input type="button" class="cancelbutton" value="Cancel"
							onclick="ShowWorkEducationForm();" />
					</s:form>

				</div>
				
               </div>


                



			</div>


	
                
	



			<div id="relationship">

				<h4 class="lable">Relationship</h4>
			<!--  	<input type="button" value="Edit" class="button"
					onclick="AddRelationshipForm();"> -->




				<!--  <img src="/Facebook/asset/images/placeholder-relationship.png"  class="imageclass"/> -->

				 <div id="addrelationshipdetails">
					<h5 class="data" >
						<span id="adddisplaystatus"></span></h5>
						<div  class="hrefclass" style="float:right"> <a  id="addremovelinkre" onclick="DeleteRelationshipStatus();"></a></div>
			            <div class="hrefclass" style="float:right"> <a id="addeditlinkre" onclick="AddRelationshipForm();"></a></div>
				</div>


                <div id ="updaterelationshipdetails">
				<s:if test='%{! pfobj.getRelationshipStatus().equalsIgnoreCase("") }'>
					<h5 class="data">
						<span id="displaystatus"> <s:property value="pfobj.getRelationshipStatus()" /></span>
					</h5>
					    <div  class="hrefclass" style="float:right"> <a  id="removelinkre" onclick="DeleteRelationshipStatus();">Remove</a></div>
			            <div class="hrefclass" style="float:right"> <a id="editlinkre" onclick="ShowRelationshipForm();">Edit</a></div>
				</s:if>
				<s:else>
					<div class="addhyperlink" style="margin-top: 20px;">
						 <a id="displayaddrelationship" onclick="ShowRelationshipForm();">Add RelationShip Status</a>
					</div>

				</s:else>
                  </div>
                  
                  
                  <!-- in case of deletion -->
                  <div class="addhyperlink" style="margin-top: 20px;">
						 <a id="afterdeletionaddrelationship" onclick="AddRelationshipForm();"></a>
					</div>

				<div id="form_relation" style="display: none;">

					<label class="formlable"> Relationship Status </label> <select
						id="relationship_id" class="textbox">
						<option>Single</option>
						<option>In a Relation</option>
						<option>Engaged</option>
						<option>Married</option>
						<option>In a open Relationship</option>
						<option>It's Complicated</option>
						<option>Separated</option>
						<option>Divorced</option>
						<option>Widowed</option>
					</select> <input type="submit" class="addbutton" value="Save"
						onclick="updateRelationshipStatus();" /> <input type="submit"
						class="cancelbutton" value="Cancel"
						onclick="ShowRelationshipForm();" />
				</div>




				<div id="form_addrelation" style="display: none;">

					<label class="formlable"> Relationship Status </label> <select
						id="addrelationship_id" class="textbox">
						<option>Single</option>
						<option>In a Relation</option>
						<option>Engaged</option>
						<option>Married</option>
						<option>In a open Relationship</option>
						<option>It's Complicated</option>
						<option>Separated</option>
						<option>Divorced</option>
						<option>Widowed</option>
					</select> <input type="submit" class="addbutton" value="Save"
						onclick="AddRelationshipStatus();" /> <input type="submit"
						class="cancelbutton" value="Cancel"
						onclick="AddRelationshipForm();" />
				</div>





			</div>




			<div id="aboutme">

				<h4 class="lable">About You</h4>
				<!--  <input type="button" value="Edit" class="button"
					onclick="ShowAboutmeForm();" /> -->

				<div id="addaboutmedetails">
					<h5 class="data">
						<span id="adddisplayaboutme"></span>
					</h5>
					 <div  class="hrefclass" style="float:right"> <a  id="addremovelinkabout" onclick="DeleteAboutMe();"></a></div>
			            <div class="hrefclass" style="float:right"> <a id="addeditlinkabout" onclick="AddAboutmeForm();"></a></div>
				</div>

				
				<div id="updateaboutmedetails">
				<s:if test='%{! pfobj.getAboutMe().equalsIgnoreCase("") }'>

					<div>
						<h5 class="data">
							<span id="displayaboutme"><s:property value="pfobj.getAboutMe()" /></span>
								
						</h5>
						<div  class="hrefclass" style="float:right"> <a  id="removelinkabout" onclick="DeleteAboutMe();">Remove</a></div>
			            <div class="hrefclass" style="float:right"> <a id="editlinkabout" onclick="ShowAboutmeForm();">Edit</a></div>
						
					</div>

				</s:if>

				<s:else>
					<div class="addhyperlink" style="margin-top: 20px;">
					<a id="displayaddaboutme" onclick="AddAboutmeForm();">Add About Yourself.</a>
					
					</div>
				</s:else>
				</div>
				
				
				<!-- in case of deletion -->
				
				<div class="addhyperlink" style="margin-top: 20px;">
					<a id="afterdeletionaddaboutme" onclick="AddAboutmeForm();"></a>
					</div>

				<div id="form_aboutme" style="display: none;">

					<label class="formlable">About You</label>
					<s:textfield type="text"  size="35" id="aboutme_id" />

					<input type="submit" class="addbutton"  id="button_about" value="Save"
						onclick="updateAboutMe()"  disabled="disabled"/> 
						<input type="submit" class="cancelbutton"  value="Cancel" onclick="ShowAboutmeForm();" />
				</div>


				<div id="form_addaboutme" style="display: none;">


					<label class="formlable">About You</label>
					<s:textfield type="text" size="35"   id="addaboutme_id" />

					<input type="submit" class="addbutton" value="Save"
						onclick="AddAboutMe()"  id="button_addabout"  disabled="disabled" /> <input type="submit"
						class="cancelbutton" value="Cancel" onclick="AddAboutmeForm();" />
				</div>

			</div>



			<div id="favquote">

				<h3 class="lable">Favourite Quotations</h3>
				<!--  <input type="button" value="Edit" class="button" onclick="ShowFavquoteForm();" /> -->


				<!-- add fav quote -->
				<div id="addfavquotedetails">
				<div>
					  <h5 class="data">
						<span id="adddisplayfavquote"></span></h5>
						 <div  class="hrefclass" style="float:right"> <a  id="addremovelinkfav" onclick="DeleteFavQuote();"></a></div>
			            <div class="hrefclass" style="float:right"> <a id="addeditlinkfav" onclick="AddFavquoteForm();"></a></div>
						
					
				</div>
                </div>

                   <!-- update favquote -->
				<div id="updatefavquotedetails">
				<s:if test='%{! pfobj.getFavQuote().equalsIgnoreCase("") }'>
					<div>
						<h5 class="data">
							<span id="displayfavquote"><s:property value=" pfobj.getFavQuote()" /></span>
							</h5>
							<div  class="hrefclass" style="float:right"> <a  id="upremovelinkfav" onclick="DeleteFavQuote();">Remove</a></div>
			                <div class="hrefclass" style="float:right"> <a id="upeditlinkfav" onclick="ShowFavquoteForm();">Edit</a></div>
					</div>
				</s:if>

				<s:else>
					<div class="addhyperlink" style="margin-top: 20px;">
				<a id="displayaddfavquote" onclick="AddFavquoteForm();">Add Favourite Quotations.</a>
					</div>
				</s:else>
				</div>
				
				
				<!-- in case of deletion -->
				<div class="addhyperlink" style="margin-top: 20px;">
				<a id="afterdeletionaddfavquote"  onclick="AddFavquoteForm();"></a>
				</div>

				<div id="form_favquote" style="display: none;">

					<label class="formlable">Favourite Quotation</label>
					<s:textfield type="text" size="35" id="favquote_id" />

					<input type="submit" class="addbutton" value="Save"
						onclick="updateFavQuote()" id="button_favquote" disabled="disabled" /> <input type="submit"
						class="cancelbutton" value="Cancel" onclick="ShowFavquoteForm();" />
				</div>



				<div id="form_addfavquote" style="display: none;">

					<label class="formlable">Favourite Quotation</label>
					<s:textfield type="text" size="35" id="addfavquote_id" />

					<input type="submit" class="addbutton" value="Save"
						onclick="AddFavQuote()"  id="button_addfavquote" disabled="disabled"/> <input type="submit"
						class="cancelbutton" value="Cancel" onclick="AddFavquoteForm();" />
				</div>
			
			</div>

		</div>




		<div id="rightdivision">


			<div id="placeslived">

				<h4 class="lable">Places Lived</h4>
			
			
			    
				   <!--  code for added home town -->
				   <div id="addhometowndetails"  style="margin-top: 1px;">
			       <h5 class="data"><span id="adddisplayhometown"  style="float: left"></span></h5>
			        <div  class="hrefclass" style="float:right"> <a  id="removelinkhome" onclick="DeleteHomeTown();"></a></div>
			        <div class="hrefclass" style="float:right"> <a id="editlinkhome" onclick="AddHometownForm();"></a></div>
		            <div><h6 class="description" id="deschome"></h6>
			       </div>        
			 	   </div>
				
				<!-- code for updation -->	
	                <div id="hometown_updatedetails">
		              <s:if test='%{!pfobj.getHomeTown().equalsIgnoreCase("")}'>
                        <div   style="margin-top:10px;">
					
						<h5 class="data"><span id="displayhometown"  style="float: left"><s:property value="pfobj.getHomeTown()" /></span></h5>
						<div  class="hrefclass" style="float:right"> <a id="remove" onclick="DeleteHomeTown();"> Remove</a></div>
						<div  class="hrefclass" style="float:right"> <a id="edit" onclick="ShowHometownForm();"> Edit</a></div>
						<div ><h6 class="description" id="desc">HomeTown</h6></div>
					</div>
		          </s:if>
		           <!-- code for checking empty value -->
                <s:else>
					<div class="addhyperlink">
					<span id="displayaddhometown"><a onclick="AddHometownForm();">Add HomeTown</a></span>
					</div>
				</s:else>
				</div>
				
				
				<!-- in case deletion show hyperlink -->
				<div class="addhyperlink">
				<a id="afterdeletionaddhometown" onclick="AddHometownForm();"></a>
                 </div>
                 
			<!-- update form -->
                <div id="form_hometown" style="display: none;">
					<label class="formlable"> Hometown</label>
					<s:textfield type="text" class="textbox" id="hometown_id"/>
					
					<input type="button" class="addbutton" value="Save" onclick="UpdateHomeTown();"  id="button_home" disabled="disabled"/> <input type="button"
						class="cancelbutton" value="Cancel" onclick="ShowHometownForm();" />
				</div>
        
            <!-- add hometown form -->
               <div id="form_addhometown" style="display: none;">
					<label class="formlable">Add Hometown</label>
					<s:textfield type="text" class="textbox" id="addhometown_id" />
					<input type="button" class="addbutton" value="Save" onclick="AddHomeTown();"   id="button_addhome" disabled="disabled"/> <input type="button"
						class="cancelbutton" value="Cancel" onclick="AddHometownForm();" />
				</div>      





         <!--  code for currrent city -->
                      
                      <!-- code for add current city -->
                       <div id="addcurrentcitydetails">
                       <div style="margin-top: 1px;">
						<h5 class="data"> <span id="adddisplaycurrentcity" style="float:left;"></span></h5>
						  <div class="hrefclass" style="float: right"> <a  id="removelinkcity"onclick="DeleteCurrentCity();"></a></div>
                          <div class="hrefclass" style="float: right"> <a  id="editlinkcity"onclick="AddCurrentcityForm();"></a></div>
						<div><h6 class="description"  id="desccity"></h6>
						</div>
					   </div>
					   </div>
                   
                   
                   <!-- code for update current city -->
                   <div id="updatecurrentcitydetails">
				<s:if test='%{! pfobj.getCurrentCity().equalsIgnoreCase("") }'>
					<div style="margin-top: 10px;">
						  <h5 class="data"> <span id="displaycurrentcity" style="float:left;"><s:property value="pfobj.getCurrentCity()" /></span></h5>
						   <div class="hrefclass" style="float: right"><a id="cityremove" onclick="DeleteCurrentCity();"> Remove</a></div>
                          <div class="hrefclass" style="float: right"><a id="cityedit" onclick="ShowCurrentcityForm();"> Edit</a></div>
						<div><h6 class="description" id="citydesc">Current City</h6></div>
					</div>
              </s:if>
				<s:else>
					<div class="addhyperlink" style="margin-top: 20px;">
						<span id="displayaddcurrentcity"><a onclick="AddCurrentcityForm();">Add CurrentCity</a></span>
					</div>

				</s:else>
                </div>
                
                
                <!-- in case of deletion -->
                <div class="addhyperlink" style="margin-top: 20px;">
				<a id="afterdeleteaddcurrentcity" onclick="AddCurrentcityForm();"></a>
					</div>
                
                
				<div id="form_currentcity" style="display: none;">
					<label class="formlable">Currentcity</label>
					<s:textfield type="text" class="textbox" id="currentcity_id" />
					<input type="button" class="addbutton" value="Save"
						onclick="UpdateCurrentCity();" id="button_city" disabled="disabled" /> <input type="button"
						class="cancelbutton" value="Cancel"
						onclick="ShowCurrentcityForm();" />
				</div>


                <div id="form_addcurrentcity" style="display: none;">
					<label class="formlable">Add Currentcity</label>
					<s:textfield type="text" class="textbox" id="addcurrentcity_id" />
					<input type="button" class="addbutton" value="Save"
						onclick="AddCurrentCity();"  id="button_addcity" disabled="disabled" /> <input type="button"
						class="cancelbutton" value="Cancel"
						onclick="AddCurrentcityForm();" />
				</div>






             
             
            

                
				
			</div>



			<div id="basicinfo">

				<h4 class="lable">Basic Information</h4>

				<div id="basicinfo_alignment">

					<s:if test='%{! pfobj.getBirthday().equalsIgnoreCase("") }'>
						<div>
							<div class="data" style="float: left;">
								<h6>
									<label style="color: rgb(102, 102, 102);">Birth Date :</label>
									<s:property value="pfobj.getBirthday()" />
								</h6>
							</div>
						</div>
					</s:if>
					<s:else>
						<div class="addhyperlink" style="margin-top: 0px;">
							<a onclick="ShowCurrentcityForm();">Add Birthdate</a>
						</div>
					</s:else>
					</div>
					
					
					<!-- language -->
					<div id="addlanguagedetails">
                    <div class="data" style="float: left;">
							<h6>
								<label id="lablelanguage" style="color: rgb(102, 102, 102);"></label>
								<span id="adddisplaylanguage" ></span>
							</h6>
					</div>
					
					<div class="basicinfoclass" style="float: right"> <a id="addremovelinklang" onclick="DeleteLanguage();"></a></div>
					<div class="basicinfoclass" style="float: right"> <a id="addeditlinklang" onclick="AddLanguageForm();"></a></div>
					
					</div>
					
					<div id="updatelanguagedetails">
					<s:if test='%{! pfobj.getLanguageKnown().equalsIgnoreCase("") }'>
						<div class="data" style="float: left;">
							<h6>
								<label style="color: rgb(102, 102, 102);">Languages Known :</label>
								<span id="displaylanguage" ><s:property value="pfobj.getLanguageKnown()" /></span>
							</h6>
						</div>
						<div class="basicinfoclass" style="float: right"> <a id="removelinklang" onclick="DeleteLanguage();">Remove</a></div>
						<div class="basicinfoclass" style="float: right"> <a id="editlinklang" onclick="ShowLanguageForm();"> Edit</a></div>
					</s:if>
					<s:else>
						<div class="addhyperlink" style="margin-top: 10px;">
				        <a  id="displayaddlanguage" onclick="AddLanguageForm();">Add Languages</a>
						</div>
					</s:else>
					</div>

                   <!-- in case of delete -->
                   <div class="addhyperlink" style="margin-top: 10px;">
				        <a  id="afterdeletionaddlanguage" onclick="AddLanguageForm();"></a>
						</div>

					<!-- forms -->

					<div id="form_language" style="display: none;">

						<label class="formlable">Language</label>
						<s:textfield type="text" size="35" id="language_id" />

						<input type="submit" class="addbutton" value="Save"  onclick="updateLanguage()"  id="button_language" disabled="disabled"/>
							<input type="submit" class="cancelbutton" value="Cancel" onclick="ShowLanguageForm();" />
					</div>

                    <div id="form_addlanguage" style="display: none;">

						<label class="formlable">Language</label>
						<s:textfield type="text" size="35" id="addlanguage_id" />

						<input type="submit" class="addbutton" value="Save"  onclick="AddLanguage()"  id="button_addlanguage" disabled="disabled"/>
							<input type="submit" class="cancelbutton" value="Cancel" onclick="AddLanguageForm();" />
					</div>
                    
				

        <!-- code for Gender -->

                 <div id="addgenderdetails">
                    <div class="data" style="float: left;">
						<h6>
							<label  id="genderlable" style="color: rgb(102, 102, 102);"></label>
							<span id="adddisplaygender"></span>
						</h6>
					</div>
					<div class="basicinfoclass" style="float: right"> <a id="addremovelinkgender" onclick="DeleteGender();"></a></div>
					<div class="basicinfoclass" style="float: right"> <a id="addeditlinkgender" onclick="AddGenderForm();"></a></div>
					
				</div>

				
				
				<!-- code for update gender -->
				<div id="updategenderdetails">
				<s:if test='%{! pfobj.getGender().equalsIgnoreCase("") }'>
					<div class="data" style="float: left;">
						<h6>
							<label style="color: rgb(102, 102, 102);">Gender :</label>
							<span id="displaygender"><s:property value="pfobj.getGender()" /></span>
						</h6>
					</div>
					        <div class="basicinfoclass" style="float: right"> <a id="addremovelinklang" onclick="DeleteGender();">Remove</a></div>
					       <div class="basicinfoclass" style="float: right"> <a id="genderedit" onclick="ShowGenderForm();">Edit</a></div>
					
				
				</s:if>
				
				<s:else>
		       <div  id="displayaddgender" class="addhyperlink" style="margin-top: 10px;"> <a onclick="AddGenderForm();">Add Gender</a>
					</div>
				
				</s:else>
				</div>



              <!-- in case of deletion -->
              <div   class="addhyperlink" style="margin-top: 10px;"> <a id="afterdeletionaddgender" onclick="AddGenderForm();"></a> </div>
				
				
				
				<div id="form_gender" style="display: none;">

					<label class="formlable"> Gender </label> <select id="gender_id"
						class="textbox">
						<option>Male</option>
						<option>Female</option>
					</select> <input type="submit" class="addbutton" value="Save" onclick="updateGender()" /> 
						<input type="submit" class="cancelbutton" value="Cancel" onclick="ShowGenderForm();" />

				</div>


                <div id="form_addgender" style="display: none;">

					<label class="formlable"> Gender </label> <select id="addgender_id"
						class="textbox">
						<option>Male</option>
						<option>Female</option>
					</select> <input type="submit" class="addbutton" value="Save" onclick="AddGender()" /> 
						<input type="submit" class="cancelbutton" value="Cancel" onclick="AddGenderForm();" />

				</div>
                

	
	
				<!-- Code For Add Interested In -->
				
				<div id="addinterestedindetails">
				<div class="data" style="float: left;">
						<h6>
							<label  id="interestlable" style="color: rgb(102, 102, 102);"></label>
						    <span id="adddisplayinterestedin"></span>
						</h6>
					</div>
					 <div class="basicinfoclass" style="float: right"> <a id="addremovelinkin" onclick="DeleteInterestedIn();"></a></div>
					 <div class="basicinfoclass" style="float: right"> <a id="addeditlinkin" onclick="AddInterestedInForm();"></a></div>
				</div>
				
				
			
				<!-- code for update interested in -->
				
				<div id="updateinterestedindetails">
				<s:if test='%{!pfobj.getInterestedIn().equalsIgnoreCase("") }'>
					<div class="data" style="float: left;">
						<h6>
							<label style="color: rgb(102, 102, 102);">Interested In:</label>
						<span id="displayinterestedin">	<s:property value="pfobj.getInterestedIn()" /></span>
						</h6>
					</div>
					 <div class="basicinfoclass" style="float: right"> <a id="addremovelinkin" onclick="DeleteInterestedIn();">Remove</a></div>
					 <div class="basicinfoclass" style="float: right"> <a id="addeditlinkin" onclick="ShowInterestedInForm();">Edit</a></div>
					
				</s:if>
				<s:else>
					<div class="addhyperlink" style="margin-top: 0px;">
				<span id="displayaddinterestedin"><a onclick="AddInterestedInForm();">Add Interested In</a></span>
					</div>
				</s:else>
               </div>
               
               
               <!-- in case of deletion -->
               <div class="addhyperlink" style="margin-top: 10px;">
				<a  id="afterdeletionaddinterestedin" onclick="AddInterestedInForm();"></a>
					</div>
               

				<div id="form_interestedin" style="display: none;">

					<label class="formlable"> Interested In </label> <select
						id="interestedin_id" class="textbox">
						<option>Male</option>
						<option>Female</option>
					</select> <input type="submit" class="addbutton" value="Save"
						onclick="updateInterestedIn()" /> 
						<input type="submit" class="cancelbutton" value="Cancel"
						onclick="ShowInterestedInForm();" />

				</div>


                
				<div id="form_addinterestedin" style="display: none;">

					<label class="formlable"> Interested In </label> <select
						id="addinterestedin_id" class="textbox">
						<option>Male</option>
						<option>Female</option>
					</select> <input type="submit" class="addbutton" value="Save"
						onclick="AddInterestedIn()" /> 
						<input type="submit" class="cancelbutton" value="Cancel"
						onclick="AddInterestedInForm();" />

				</div>
                


               
               <!-- code for Religious View -->
               
               <!-- add religious view -->
               
             <div id="addreligiousviewdetails">
              <div class="data" style="float: left;">
						<h6>
							<label  id="religiousviewlable" style="color: rgb(102, 102, 102);"></label>
							<span id= "adddisplayreligiousview"></span>
						</h6>
				</div>
	                  <div class="basicinfoclass" style="float: right"> <a id="addremovelinkreligious" onclick="DeleteReligiousView();"></a></div>
					 <div class="basicinfoclass" style="float: right"> <a id="addeditlinkreligious" onclick="AddReligiousViewForm();"></a></div>
             </div>
             
               
               <!-- code for update religious view -->
                  
                  <div id="updatereligiousviewdetails">
                  <s:if test='%{! pfobj.getReligiousView().equalsIgnoreCase("") }'>
					<div class="data" style="float: left;">
						<h6>
							<label style="color: rgb(102, 102, 102);">Religious View:</label>
							<span id= "displayreligiousview"><s:property value="pfobj.getReligiousView()" /></span>
						</h6>
					</div>
					 <div class="basicinfoclass" style="float: right"> <a id="removelinkreligious" onclick="DeleteReligiousView();">Remove</a></div>
					 <div class="basicinfoclass" style="float: right"> <a id="editlinkreligious" onclick="ShowReligiousViewForm();">Edit</a></div>
				</s:if>

				<s:else>
					<div class="addhyperlink" style="margin-top: 10px;">
				<span id="displayaddreligiousview">	<a onclick="AddReligiousViewForm()">Add Religious Views</a></span>
					</div>
				</s:else>
				</div>
				
				<!-- in case of deletion -->
				
				<div class="addhyperlink" style="margin-top: 10px;">
					<a  id="afterdeletionaddreligiousview" onclick="AddReligiousViewForm()"></a>
					</div>

				<div id="form_religiousview" style="display: none;">

					<label class="formlable">Religious Views</label>
					<s:textfield type="text" size="35" id="religiousview_id" />

					<input type="submit" class="addbutton" value="Save" onclick="updateReligiousView()" id="button_religiousview"  disabled="disabled"/>
						<input type="submit" class="cancelbutton" value="Cancel" onclick="ShowReligiousViewForm();;" />
				</div>

               <div id="form_addreligiousview" style="display: none;">

					<label class="formlable">Religious Views</label>
					<s:textfield type="text" size="35" id="addreligiousview_id" />

					<input type="submit" class="addbutton" value="Save" onclick="AddReligiousView()" id="button_addreligiousview"  disabled="disabled" />
				   <input type="submit" class="cancelbutton" value="Cancel" onclick="AddReligiousViewForm();" />
				</div>
			




                <!-- code for add political view -->
 
              <div id="addpoliticalviewdetails">
             <div class="data" style="float: left;">
					<h6>
						<label id="politicalviewlable" style="color: rgb(102, 102, 102);"></label>
						<span id="adddisplaypoliticalview"></span>
					</h6>
				</div>
				     <div class="basicinfoclass" style="float: right"> <a id="addremovelinkpolitical" onclick="DeletePoliticalView();"></a></div>
					 <div class="basicinfoclass" style="float: right"> <a id="addeditlinkpolitical" onclick="AddPoliticalViewForm();"></a></div>
				</div>


            <!-- code for update political view -->
             <div id="updatepoliticalviewdetails">
			 <s:if test='%{! pfobj.getPoliticalView().equalsIgnoreCase("") }'>
				<div class="data" style="float: left;">
					<h6>
						<label style="color: rgb(102, 102, 102);">Political View:</label>
						<span id="displaypoliticalview"><s:property value="pfobj.getPoliticalView()" /></span>
					</h6>
				</div>
				<div class="basicinfoclass" style="float: right"> <a id="removelinkpolitical" onclick="DeletePoliticalView();">Remove</a></div>
					 <div class="basicinfoclass" style="float: right"> <a id="editlinkpolitical" onclick="ShowPoliticalViewForm();">Edit</a></div>
			</s:if>
			
			<s:else>
				<div class="addhyperlink" style="margin-top: 10px;">
			<span id="displayaddpoliticalview">	<a onclick="AddPoliticalViewForm();">Add Political Views</a></span>
				</div>
			</s:else>
			</div>
			
			
			<!-- in case of deletion -->
			
			<div class="addhyperlink" style="margin-top: 10px;">
			<a  id="afterdeletionaddpoliticalview" onclick="AddPoliticalViewForm();"></a>
			</div>

			<div id="form_politicalview" style="display: none;">

				<label class="formlable">Political Views</label>
				<s:textfield type="text" size="35" id="politicalview_id" />

				<input type="submit" class="addbutton" value="Save" onclick="updatePoliticalView()" id="button_politicalview" disabled="disabled" /> 
					<input type="submit" class="cancelbutton" value="Cancel"
					onclick="ShowPoliticalViewForm();" />
			</div>
			
			
			
			<div id="form_addpoliticalview" style="display: none;">

				<label class="formlable">Political Views</label>
				<s:textfield type="text" size="35" id="addpoliticalview_id" />

				<input type="submit" class="addbutton" value="Save" onclick="AddPoliticalView()" id="button_addpoliticalview" disabled="disabled"/> 
					<input type="submit" class="cancelbutton" value="Cancel"
					onclick="AddPoliticalViewForm();" />
			</div>


		</div>
	


			<div id="contactinfo">
			    
			    
				<h4 class="lable">Contact Information :</h4>
               
               <div id="addemailiddetails">
               
                <div class="data" style="float: left;">

				<h6><label id="emailidlable" style="color: rgb(102, 102, 102);"></label>
					<span id="adddisplayemailid"></span>
				</h6>
			   </div>
	    <div class="basicinfoclass" style="float: right"> <a id="addremovelinkemailid" onclick="DeleteEmailId();"></a></div>
		<div class="basicinfoclass" style="float: right"> <a id="addeditlinkemailid" onclick="AddEmailIdForm();"></a></div>
			
             </div>
             
             
             <!-- code email updation details -->
             <div id="updateemailiddetails">
			<s:if test='%{! pfobj.getEmail().equalsIgnoreCase("") }'>

				<div class="data" style="float: left;">
					<h6>
						<label style="color: rgb(102, 102, 102);">Email :</label> 
						<span id="displayemailid"><s:property value="pfobj.getEmail()" /></span>
					</h6>
				</div>
				<div class="basicinfoclass" style="float: right"> <a id="removelinkemailid" onclick="DeleteEmailId();">Remove</a></div>
		         <div class="basicinfoclass" style="float: right"> <a id="editlinkemailid" onclick="ShowEmailIdForm();">Edit</a></div>
			</s:if>
			
			<s:else>
				<div class="addhyperlink" style="margin-top: 10px;">
					<span id="displayaddemailid"> <a onclick="AddEmailIdForm();">Add Email Id</a></span>
				</div>
			</s:else>

                 </div>
                 
                 
                 <!-- in case of deletion -->
                 
                 <div class="addhyperlink" style="margin-top: 10px;">
			 <a id="afterdeletionaddemailid" onclick="AddEmailIdForm();"></a>
				</div>
                 
			  <div id="form_emailid" style="display: none;">

				<label class="formlable">Enter Email</label>
				<s:textfield type="text" size="35" id="email_id" placeholder="Update Email" />

				<input type="submit" class="addbutton" value="Save"
					onclick="updateEmailId()"   id="button_email" disabled="disabled" /> <input type="submit"
					class="cancelbutton" value="Cancel" onclick="ShowEmailIdForm();" />
			</div>

			<div id="form_addemailid" style="display:none;">

				<label class="formlable">Enter Email</label>
				<s:textfield type="text" size="35" id="addemail_id" />

				<input type="submit" class="addbutton" placeholder="Add Email"
					onclick="AddEmailId()"  id="button_addemail" disabled="disabled" /> <input type="submit"
					class="cancelbutton" value="Cancel" onclick="AddEmailIdForm();" />
			</div>



  <!--code for phone no  -->
  
             <div id="addphonenodetails">
			<div class="data" style="float: left;">
				<h6>
					<label id="phonenolable" style="color: rgb(102, 102, 102);"></label>
					<span id="adddisplayphoneno"></span>
				</h6>
			</div>
			<div class="basicinfoclass" style="float: right"> <a id="addremovelinkphoneno" onclick="DeletePhoneNo();"></a></div>
		    <div class="basicinfoclass" style="float: right"> <a id="addeditlinkphoneno" onclick="AddPhoneNoForm();"></a></div>
			</div>


       <div id ="updatephonenodetails">
			<s:if test='%{! pfobj.getPhoneNo().equalsIgnoreCase("") }'>

				<div class="data" style="float: left;">
					<h6>
						<label style="color: rgb(102, 102, 102);">Phone No :</label> <span
							id="displayphoneno"><s:property
								value="pfobj.getPhoneNo()" /></span>
					</h6>
				</div>
				<div class="basicinfoclass" style="float: right"> <a id="removelinkphoneno" onclick="DeletePhoneNo();">Remove</a></div>
		       <div class="basicinfoclass" style="float: right"> <a id="editlinkphoneno" onclick="ShowPhoneNoForm();">Edit</a></div>
			</s:if>
			<s:else>
				<div class="addhyperlink" style="margin-top: 10px;">
					<span id="displayaddphoneno"> <a onclick="AddPhoneNoForm();">AddPhone No</a></span>
				</div>
			</s:else>

            </div>
            
            <!-- in case deletion -->
            <div class="addhyperlink" style="margin-top: 10px;">
					<span > <a id="afterdeletionaddphoneno" onclick="AddPhoneNoForm();"></a></span>
				</div>
				
				
			<div id="form_phoneno" style="display: none;">

				<label class="formlable">Enter PhoneNo</label>
				<s:textfield type="text" size="35" id="phoneno_id"   />

				<input type="submit" class="addbutton" value="Save"
					onclick="updatePhoneNo()"  id="button_phone" disabled="disabled" /> <input type="submit"
					class="cancelbutton" value="Cancel" onclick="ShowPhoneNoForm();" />
			</div>
			
			
			<div id="form_addphoneno" style="display: none;">

				<label class="formlable">Enter PhoneNo</label>
				<s:textfield type="text" size="35" id="addphoneno_id" />

				<input type="submit" class="addbutton" value="Save"
					onclick="AddPhoneNo()"  id="button_addphone" disabled="disabled"/> <input type="submit"
					class="cancelbutton" value="Cancel" onclick="AddPhoneNoForm();" />
			</div>



		</div>

	</div>
</div>
</body>
</html>



