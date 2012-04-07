$(document).ready(function(){
	//获取图片的总数
	var len = $('.bannerbtn ul li').length;
	// 定义图片索引
	var index = 0;
	//定义一个计时器
	var timer;
	
	$(".bannerbtn ul li a").mouseover(function(){
		index  =   $(".bannerbtn ul li").index($(this).parent());
		showImg(index);
	 }).eq(0).mouseover();
	
	$('.picbox').hover(function(){
			 clearInterval(timer);
		 },function(){
			 timer = setInterval(function(){
			    showImg(index)
				index++;
				if(index==len){
					index=0;
				}
			  } , 8000);
	 }).trigger("mouseleave");
	
});

// 通过控制top ，来显示不同的幻灯片
function showImg(index){
        var height = $(".bannerpic").height();
		$("#slider").stop(true,false).animate({top: -height*index},1000);
		$(".bannerbtn ul li a:first-child").removeClass("on").eq(index).addClass("on");
}