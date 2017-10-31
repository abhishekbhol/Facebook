$(document).ready(function() {
	debugger;


	$("#comment_link").unbind();
	$("#wallposts_collection").on("click","#like_link",function(event) {
		debugger;
		var element = $(this).parents(".single_wallpost");
		var hiddenBox = element.find("#like_wp_id");
		var link = element.find("#like_link");
		var status = element.find("#like_image");


		$.ajax({
			type : 'POST',
			url : '/Facebook/module06/likePost.action?wallPostId='+$(hiddenBox).val(),
			success : function(data) {
				$(link).html("Unlike");
				$(link).attr('id','unlike_link');
				$(status).after("&nbsp;You");
			}
		});

	});

	$("#wallposts_collection").on("click","#unlike_link",function(event) {
		debugger;
		var element = $(this).parents(".single_wallpost");
		var hiddenBox = element.find("#like_wp_id");
		var link = element.find("#unlike_link");
		var status = element.find("#like_image");
		var likesDiv = element.find("#likes");
		var str = $(likesDiv).text().replace('You','');
		var img = element.find("#like_image");


		$.ajax({
			type : 'POST',
			url : '/Facebook/module06/unlikePost.action?wallPostId='+$(hiddenBox).val(),
			success : function(data) {

				$(link).html("Like");
				$(link).attr('id','like_link');
				//$(likesDiv).html(str);
				//$(likesDiv).prepend(img);
				//$(likesDiv).prepend("&nbsp;&nbsp;");
			}
		});
		var temp = "";
		debugger;
		$.ajax({
			type : 'POST',
			url : '/Facebook/module06/loadLikes.action?wallPostId='+$(hiddenBox).val(),
			success: function(data1){
				$.each(data1.likesList, function(index, value1){
					temp = temp + ',<a href="#" style="color:#6D84B4; ">'+value1.fullName+'</a>';
					alert(value1.fullName);
				});
				temp += " like this";
				$(likesDiv).html(temp);
				$(likesDiv).prepend(img);
				$(likesDiv).prepend("&nbsp;&nbsp;");

			}
		});

	});
	$(".single_wallpost").on("click","#comment_link",function(event) {
		debugger;
		var element = $(this).parents(".single_wallpost");
		var commentTextBox = element.find("#comment_wp_text");
		$(commentTextBox).focus();

	});
});