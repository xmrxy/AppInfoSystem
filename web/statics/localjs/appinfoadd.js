$(function () {
    //获取分类
    $.ajax({
        url:"/category/categoryList.json",
        type:"get",
        data:{parentId:0},
        dataType:"json",
        success:function (data) {
            $("#categoryLevel1").html("");
            var options1 = "<option value=\"\">--请选择--</option>";
            var options2;
            $("#categoryLevel1").append(options1)
            $.each(data,function (index, category) {
                options2 = "<option value=\""+category.id+"\">"+category.categoryName+"</option>"
                $("#categoryLevel1").append(options2);
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
            $("#flatformId").html("");
            var options1 = "<option value=\"\">--请选择--</option>";
            var options2;
            $("#flatformId").append(options1)
            $.each(data,function (index, status) {
                options2 = "<option value=\""+status.valueId+"\">"+status.valueName+"</option>"
                $("#flatformId").append(options2)
            })
        },
        error:function (data) {
            alert("加载所属平台错误！")
        }
    })

    //获取App状态
    $.ajax({
        url:"/appStatus/appStatusList.json",
        type:"get",
        dataType:"json",
        success:function (data) {
            $("#queryStatus").html("");
            var options1 = "<option value=\"\">--请选择--</option>";
            var options2;
            $("#queryStatus").append(options1)
            $.each(data,function (index, status) {
                options2 = "<option value=\""+status.valueId+"\">"+status.valueName+"</option>"
                $("#queryStatus").append(options2);
            })
        },
        error:function (data) {
            alert("加载一级分类错误！")
        }
    })


})

$("#categoryLevel1").change(function(){
    var queryCategoryLevel1 = $("#categoryLevel1").val();
    if(queryCategoryLevel1 != '' && queryCategoryLevel1 != null){
        $.ajax({
            type:"GET",//请求类型
            url:"/category/categoryList.json",//请求的url
            data:{parentId:queryCategoryLevel1},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                $("#categoryLevel2").html("");
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#categoryLevel2").html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载二级分类失败！");
            }
        });
    }else{
        $("#categoryLevel2").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel2").html(options);
    }
    $("#categoryLevel3").html("");
    var options = "<option value=\"\">--请选择--</option>";
    $("#categoryLevel3").html(options);
});

$("#categoryLevel2").change(function(){
    var queryCategoryLevel2 = $("#categoryLevel2").val();
    if(queryCategoryLevel2 != '' && queryCategoryLevel2 != null){
        $.ajax({
            type:"GET",//请求类型
            url:"/category/categoryList.json",//请求的url
            data:{parentId:queryCategoryLevel2},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                $("#categoryLevel3").html("");
                var options = "<option value=\"\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    //alert(data[i].id);
                    //alert(data[i].categoryName);
                    options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#categoryLevel3").html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载三级分类失败！");
            }
        });
    }else{
        $("#categoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel3").html(options);
    }
});

$("#back").on("click",function(){
    history.back(-1)
});

$("#APKName").bind("blur",function(){
	//ajax后台验证--APKName是否已存在
	$.ajax({
		type:"GET",//请求类型
		url:"/dev/apkExist.json",//请求的url
		data:{apkName:$("#APKName").val()},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data.APKName == "empty"){//参数APKName为空，错误提示
				alert("APKName为不能为空！");
			}else if(data.APKName == "exist"){//账号不可用，错误提示
				alert("该APKName已存在，不能使用！");
			}else if(data.APKName == "noexist"){//账号可用，正确提示
			    $("#apk_div").html("该APKName可以使用")
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("请求错误！");
		}
	});
});
