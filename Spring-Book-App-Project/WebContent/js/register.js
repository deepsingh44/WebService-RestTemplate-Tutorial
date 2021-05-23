$(document).ready(function() {

	$("#register").click(function() {
		var bname = $("#name").val();
		var bemail = $("#email").val();
		var bpass = $("#pwd").val();

		$.post("user/register", {
			name : bname,
			email : bemail,
			pass : bpass,
		}, function(response) {
			alert(response);
		});
	});

});