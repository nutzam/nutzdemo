$(document).ready(function(){
	//记录小组个数
	var size = $(".xsxzli dl").length;
	var index = 0;
	var lastindex = size - 1;
	
	$(".xsxzli dl").hide().eq(0).show();	
	
	//点击向上按钮
	$(".mar1 a img").click(function(){
		if(index<1){
			index=0;
		}else{
			index--;
		}
		
		showGroup(index);
	});
	//点击向下按钮
	$(".nextbtn a img").click(function(){
		if(index>lastindex-1){
			index=lastindex;
		}else{
			index++;
		}
		showGroup(index);
	});
});

function showGroup(index){
	//记录显示区域高度
	var height = $(".xsxzli").height();
	$(".xsxzli dl").slideUp("slow").eq(index).slideDown("slow");	
}