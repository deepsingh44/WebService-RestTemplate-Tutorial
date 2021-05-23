$(document).ready(function() {

	$("#login").click(function() {
		var bemail = $("#email").val();
		var bpass = $("#pwd").val();

		$.post("user/login", {
			email : bemail,
			pass : bpass,
		}, function(response) {
			if(response=="Successfully Login"){
				window.location.replace("./home");
			}else{
				alert(response);
			}
		});
	});

});