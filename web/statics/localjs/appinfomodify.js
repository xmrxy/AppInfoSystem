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


function  loadCategoryLevel(pid,cl,categoryLevel){
	$.ajax({
		type:"GET",//请求类型
		url:"categorylevellist.json",//请求的url
		data:{pid:pid},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			
			$("#"+categoryLevel).html("");
			var options = "<option value=\"\">--请选择--</option>";
			for(var i = 0; i < data.length; i++){
				if(cl != null && cl != undefined && data[i].id == cl ){
					options += "<option selected=\"selected\" value=\""+data[i].id+"\" >"+data[i].categoryName+"</option>";
				}else{
					options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
			}
			$("#"+categoryLevel).html(options);
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("加载分类列表失败！");
		}
	});
}   

function delfile(id){
	$.ajax({
		type:"GET",//请求类型
		url:"/dev/picture.json",//请求的url
		data:{appId:id},//请求参数
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data.result == "success"){
				alert("删除成功！");
				$("#uploadfile").show();
				$("#logoFile").html('');
			}else if(data.result == "failed"){
				alert("删除失败！");
			}
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			alert("请求错误！");
		}
	});  
}



	$("#back").on("click",function(){
		window.location.href = "/dev/appList.html";
	});
	
	
	//LOGO图片---------------------
	var logoPicPath = $("#logoPicPath").val();
	var id = $("#id").val();
	if(logoPicPath == null || logoPicPath == "" ){
		$("#uploadfile").show();
	}else{
		$("#logoFile").append("<p><img src=\""+logoPicPath+"?m="+Math.random()+"\" width=\"100px;\"/> &nbsp;&nbsp;"+
							"<a href=\"javascript:;\" onclick=\"delfile('"+id+"');\">删除</a></p>");
		
	}


      
      