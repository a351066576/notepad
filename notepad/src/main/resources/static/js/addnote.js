$(function () {
});

function save() {
    var title = $("#title").val();
    var content = $("#content").val();
    if (title == "") {
        $("#notitle").show();
    }
    if (content == "") {
        $("#nocontent").show();
    }
    if (title != "" && content != "") {
        $.ajax({
            url: "insert",      //请求接口的地址
            type: "POST",                                   //请求的方法GET/POST
            data: {                                        //需要传递的参数
                title: title,
                content: content
            },
            success: function (res) {                      //请求成功后的操作
                if(res=="OK"){
                    alert("新增成功");
                    window.location.replace("/main");
                }else{
                    alert("新增失败，请稍后再试");
                }                         //在控制台输出返回结果
            }
        })
    }
}