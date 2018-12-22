$(function () {
    //获取分类
    $.ajax({
        url:"/category/categoryList.json",
        type:"get",
        data:{parentId:0},
        dataType:"json",
        success:function (data) {
            $("#queryCategoryLevel1").html("");
            var options1 = "<option value=\"\">--请选择--</option>";
            var options2;
            $("#queryCategoryLevel1").append(options1)
            $.each(data,function (index, category) {
                options2 = "<option value=\""+category.id+"\">"+category.categoryName+"</option>"
                $("#queryCategoryLevel1").append(options2);
            });
        },
        error:function (data) {
            alert("加载一级分类错误！")
        }
    })

    //获取平台信息
    $.ajax({
        url:"/pingTai/pingTaiList.json",
        type:"get",
        dataType:"json",
        success:function (data) {
            $("#queryFlatformId").html("");
            var options1 = "<option value=\"\">--请选择--</option>";
            var options2;
            $("#queryFlatformId").append(options1)
            $.each(data,function (index, status) {
                options2 = "<option value=\""+status.valueId+"\">"+status.valueName+"</option>"
                $("#queryFlatformId").append(options2)
            })
        },
        error:function (data) {
            alert("加载所属平台错误！")
        }
    })

})

$("#queryCategoryLevel1").change(function(){
    var queryCategoryLevel1 = $("#queryCategoryLevel1").val();
    if(queryCategoryLevel1 != '' && queryCategoryLevel1 != null){
        $.ajax({
            type:"GET",//请求类型
            url:"/category/categoryList.json",//请求的url
            data:{parentId:queryCategoryLevel1},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                $("#queryCategoryLevel2").html("");
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#queryCategoryLevel2").html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载二级分类失败！");
            }
        });
    }else{
        $("#queryCategoryLevel2").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#queryCategoryLevel2").html(options);
    }
    $("#queryCategoryLevel3").html("");
    var options = "<option value=\"\">--请选择--</option>";
    $("#queryCategoryLevel3").html(options);
});

$("#queryCategoryLevel2").change(function(){
    var queryCategoryLevel2 = $("#queryCategoryLevel2").val();
    if(queryCategoryLevel2 != '' && queryCategoryLevel2 != null){
        $.ajax({
            type:"GET",//请求类型
            url:"/category/categoryList.json",//请求的url
            data:{parentId:queryCategoryLevel2},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                $("#queryCategoryLevel3").html("");
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    //alert(data[i].id);
                    //alert(data[i].categoryName);
                    options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#queryCategoryLevel3").html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载三级分类失败！");
            }
        });
    }else{
        $("#queryCategoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#queryCategoryLevel3").html(options);
    }
});

$(".checkApp").on("click",function(){
	var obj = $(this);
	var status = obj.attr("status");
	var vid = obj.attr("versionid");
	if(status == "1" && vid != "" && vid != null){//待审核状态下才可以进行审核操作
		window.location.href="/backend/checkApp.html/"+ obj.attr("appinfoid") + "/"+ obj.attr("versionid");
	}else if(vid != "" || vid != null){
		alert("该APP应用没有上传最新版本,不能进行审核操作！");
	}else if(status != "1"){
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
	}
});



	
