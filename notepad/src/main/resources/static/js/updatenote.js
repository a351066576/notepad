$(function() {
});

function save() {
    var id = $("#id").val();
    var title = $("#title").val();
    var content = $("#content").val();
    if(title==""){
        $("#notitle").show();
    }
    if(content==""){
        $("#nocontent").show();
    }
    if(title!=""&&content!=""){
        $.ajax({
            url: "update",      //请求接口的地址
            type: "POST",                                   //请求的方法GET/POST
            data: {                                        //需要传递的参数
                id: id,
                title: title,
                content: content
            },
            success: function (res) {                      //请求成功后的操作
                if(res=="OK"){
                    alert("修改成功");
                    var url = "queryNote?id="+id
                    window.location.replace(url);
                }else{
                    alert("修改失败，请稍后再试");
                }                         //在控制台输出返回结果
            }
        })
    }
}