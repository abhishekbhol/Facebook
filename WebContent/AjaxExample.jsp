<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery.js">
</script>
<script type="text/javascript">
var temp="<h4>"; 
$(document).ready(function(){
	$("#subjectlist").click(function(){
		$.ajax({
			type: 'POST',
			url:'subjectaction',
			success:function(data){
			temp=temp+data.name;
			temp=temp+"</h4> <h3>";
			$.each(data.subjects, function(index,value)
					{
					temp=temp+value+"<br>";
					});
			temp=temp+"</h3>";
			$("#displayid").html(temp);
			}
		});
	});
});


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Ajax Examples</title>
</head>
<body>
	<input type="button" value="subjects" id="subjectlist">
	<div id="displayid"> </div>
</body>
</html>