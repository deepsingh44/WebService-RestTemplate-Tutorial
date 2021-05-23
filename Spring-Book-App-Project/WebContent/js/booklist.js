$(document).ready(function() {

	$(".box").click(function() {
		var bookid = $(this).find("#bid").val();
		window.open("detail?id=" + bookid + "");
	});

});