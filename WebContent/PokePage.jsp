<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poke Page</title>
<style type="text/css">
.pokeimage {
	font-size: 15px;
	font-weight: bold;
}
</style>

<script type="text/javascript">

$(document).ready(function(){
$(".pokes").on("click","#pokebackbutton",function(e){ 
	var parent = $(this).parents(".pokediv");
	var pokeFromId = parent.find("#fromid");
	$.ajax({
		type: 'POST',
		url:'/Facebook/module08/PokeBack?pokefromid='+$(pokeFromId).val(),
		success:function(data){
			alert("Success");
			$(parent).html("You have successfully poked back ");
		}
	});
	e.preventDefault();
});
		


$(".pokes").on("click","#delete_button", function(e){
	var parent = $(this).parents(".pokediv");
	var pokeFromId = parent.find("#fromid");
	var grandparent = $(parent).parents(".single_poke");
	$.ajax({
		type: 'POST',
		url:'/Facebook/module08/DeletePoke?pokefromid='+$(pokeFromId).val(),
		success:function(data){
			alert("Success");
			$(grandparent).html(" ");
		}
		});
		e.preventDefault();
	});
});
</script>
</head>

<body>


	<div class="pokeimage">
		<img src="/Facebook/asset/images/poke.png" align="left" /> Pokes
	</div>

	<br>
<div class="pokes">

<s:iterator value="pokelist" >
<div class="single_poke">
	<table>
		<tr>
			<td>
				<div >
					<img  src="<s:property value="profilePic"/>"
						style="width: 60px; height: 60px;" />
				</div>
			</td>
	
		<td width="30%" >
		<div class="poketext">
			&nbsp; &nbsp; <s:property value="fromUserName"/> poked you!
		</div>
		
		<div class="pokediv">
			&nbsp;&nbsp;&nbsp; <button class="btn btn-primary ladda-button" data-style="expand-left" id ="pokebackbutton">
				<span class="ladda-label">Poke Back</span>
			</button>
			<a href="#" id="delete_button"><img src="/Facebook/asset/images/blackbutton.jpg"  style=" width:10px; height:10px;"></a>
			<input type="hidden" value='<s:property value="pokeFrom"/>' id="fromid">
		</div>
		
		</td>
		<td width="45%"></td>
		<td >
			<div class="timestamp" style="position: relative; float: right">
				<s:property value="timestamp"/></div>
		
		</td>
		</tr>
	</table>
	<br>
</div>
</s:iterator>
	</div>

</body>
</html>