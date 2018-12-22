function delfile(id){
	$.ajax({
		type:"GET",//请求类型
		url:"/appVersion/delApk.json",//请求的url
		data:{versionId:id},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data.result == "success"){
				alert("删除成功！");
				$("#uploadfile").show();
				$("#apkFile").html('');
			}else if(data.result == "failed"){
				alert("删除失败！");
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("请求错误！");
		}
	});  
}

function downLoad(){
    var id = $("#appId").val();
    $.ajax({
		url:"/appVersion/downVersion.html/",
		type:"get",
		data:{appId:id},
		dataType:"json",
		success:function (data) {
			if (data.result==="下载成功"){
                alert("下载成功！")
			}else if (data.result==="下载失败") {
                alert("下载失败！")
			}
		},
		error:function (data) {
			alert("下载失败！")
        }
	})
}

$(function(){
	$("#back").on("click",function(){
		window.location.href = "/dev/appList.html";
	});
	
	//上传APK文件---------------------
	var downloadLink = $("#downloadLink").val();
	var id = $("#id").val();
	var apkFileName = $("#apkFileName").val();
	if(downloadLink == null || downloadLink == "" ){
		$("#uploadfile").show();
	}else{
		$("#apkFile").append("<p>"+apkFileName+
							"&nbsp;&nbsp;<a onclick='downLoad()' href=\""+downloadLink+"?m="+Math.random()+"\" >下载</a> &nbsp;&nbsp;" +
							"<a href=\"javascript:;\" onclick=\"delfile('"+id+"');\">删除</a></p>");
	}

});
      
      
      