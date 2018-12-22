$("#back").on("click",function(){
	window.location.href = "/dev/appList.html";
});

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

	
	
	