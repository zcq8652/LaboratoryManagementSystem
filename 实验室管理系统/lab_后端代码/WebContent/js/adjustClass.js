$(document).ready(function(){

	$(".wait_btn").click(function(){
		$(".delete_btn").css('display','none');
		$(".main").css('display','none');
		$(".main2").css('display','block');
	});

	$(".complete_btn").click(function(){
		$(".delete_btn").css('display','block');
		$(".main").css('display','block');
		$(".main2").css('display','none');
	});
})