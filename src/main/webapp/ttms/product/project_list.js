$(document).ready(function(){
	$("#queryFormId")
	.on('click','.btn-search',doQueryObjects)
	.on('click','.btn-valid,.btn-invalid',doValidById)
	.on('click','.btn-add,.btn-update',doShowTable);
	doGetObjects();
})

function doShowTable(){
	var url="project/editUI.do";
	var title;
	if($(this).hasClass("btn-add")){
		title="添加项目信息";
	}
	
	if($(this).hasClass("btn-update")){
	    var idValue = $(this).parent().parent().data("id");
	    title="修改项目信息:"+idValue;
		$("#modal-dialog").data("idKey",idValue);
	}
	
	$("#modal-dialog .modal-body").load(url,function(){
		$(".modal-title").html(title);
		$("#modal-dialog").modal("show");
	})
}

function doQueryObjects(){
	console.log(123123123);
	$("#pageId").data("pagecurrent",1);
	doGetObjects();
}

function doValidById(){
	if($(this).hasClass("btn-valid")){
		valid=1;
	}
	if($(this).hasClass("btn-invalid")){
		valid=0;
	}
	var ids="";
	$("#tbodyId input[name='checkId']")
	.each(function(){
		if($(this).prop("checked")){
			if(ids==""){
				ids+=$(this).val();
			}else{
				ids+=","+$(this).val();
			}
		}
	});
	if(ids==""){
		alert("请至少选择也一个")
		return;
	}
	var url="project/daoValidById.do";
	var params={
			"valid":valid,
			"ids":ids
	}
	$.post(url,params,function(){
		doGetObjects();
	})
}

//获取项目信息
function doGetObjects(){
	console.log(1111);
	var url ="project/doGetObjects.do";
	var pageCurrent = $("#pageId").data("pageCurrent");
	if(!pageCurrent){pageCurrent=1};
	var params={"pageCurrent":pageCurrent};
	params.name=$("#searchNameId").val();//name是key，值为value
	params.valid=$("#searchValidId").val();
	console.log("asd:"+params);
	$.getJSON(url,params,function(result){
		console.log("2:"+result)
        setPagination(result.data.pageObject);
		setTableBodyRows(result.data.list);
	});
}

function setTableBodyRows(result){
	console.log("1:"+result.length)
	var tbody=$("#tbodyId");
	tbody.empty();
	for(i=0;i<result.length;i++){
		var tr=$("<tr></tr>");	
		var obj=result[i];
		var firTd='<td><input type="checkbox" name="checkId" value="[id]"></td>';
		firTd=firTd.replace("[id]",obj.id);
		tr.data("id",obj.id)
		tr.append(firTd);
		tr.append("<td>"+obj.code+"</td>");
		tr.append("<td>"+obj.name+"</td>");
		tr.append("<td>"+obj.beginDate+"</td>");
		tr.append("<td>"+obj.endDate+"</td>");
		tr.append("<td>"+(obj.valid?"启用":"禁用")+"</td>");
		tr.append("<td><input type='button' class='btn btn-primary btn-update' value='修改'></td>");
	    tbody.append(tr);
	}
	
}