$(document).ready(function(){
    $("#modal-dialog").on("click",".ok",doSaveOrUpdate)
    $("#modal-dialog").on("hidden.bs.modal",function(){
    	$("#modal-dialog").off("click",".ok");
    	$("#modal-dialog").removeData("idKey");
    })
    var id=$("#modal-dialog").data("idKey");
    console.log("idVaule:"+id)
    if(id){
    	doFindeObject(id);
    }
})

function doFindeObject(id){
	var params={"id":id};
	var url="project/doFindById.do";
	$.getJSON(url,params,function(result){
        if(result.state==1){
        	doInsertTable(result.data);
        }else{
        	alert(result.message);
        }
	})
}

function doInsertTable(result){
	$("#nameId").val(result.name);
	$("#codeId").val(result.code);
	$("#beginDateId").val(result.beginDate);
	$("#endDateId").val(result.endDate);
	$("#noteId").val(result.note);
	$("#editFormId input[name='valid']").each(function(){
		if($(this).val()==result.valid){
			$(this).prop("checked",true);
		}
	})
}
function doSaveOrUpdate(){
	if(!$("#editFormId").valid()){
		return
	}
	
	var params=getEdit();
	
	var insertUrl="project/doSave.do";
	var updateUrl="project/doUpdate.do";
	
	var id=$("#modal-dialog").data("idKey");
	
	var url=id?updateUrl:insertUrl;
	if(id){params.id=id};
	
	$.post(url,params,function(result){
		if(result.state==1){
			$("#modal-dialog").modal("hide");
			alert(result.message);
			doGetObjects();
		}else{
			alert(result.message);
		}
		
	})
	
}

function getEdit(){
	var params={
			name:$("#nameId").val(),
	        code:$("#codeId").val(),
	        beginDate:$("#beginDateId").val(),
	        endDate:$("#endDateId").val(),
	        valid:$("input[type='radio']:checked").val(),
	        note:$("#noteId").val()
	}
	return params;
}
