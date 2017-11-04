$(document).ready(function(){
	$("#pageId").on('click',
			'.pre,.next,.first,.last',jumpToPage);		
});

function setPagination(pageObject){
	console.log(213);
	$(".pageCount").html("总页数("+pageObject.pageCount+")");
	$(".pageCurrent").html("当前页("+pageObject.pageCurrent+")");
    $("#pageId").data("pageCount",pageObject.pageCount);
    $("#pageId").data("pageCurrent",pageObject.pageCurrent);
}

function jumpToPage(){
	console.log(213123);
	var clazz=$(this).attr("class");
	var pageCurrent=$('#pageId').data("pageCurrent");
	var pageCount=$('#pageId').data("pageCount");
	if(clazz=="pre"&&pageCurrent>1){
		pageCurrent--;
	}
	if(clazz=="next"&&pageCurrent<pageCount){
		console.log("+++");
		pageCurrent++;
	}
	if(clazz=="first"){
		pageCurrent=1;
	}
	if(clazz=="last"){
		pageCurrent=pageCount;
	}
	$("#pageId").data("pageCurrent",pageCurrent);
	doGetObjects();
}