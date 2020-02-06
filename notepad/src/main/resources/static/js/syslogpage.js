$(function () {
    load();
});

function load() {
    $('#sysLogListTable').bootstrapTable({
        url: "/syslog/querySysLogList", // 请求的后台URL（*）
        method: 'get', // 请求方式：get/post（*）
        showRefresh: false, // 是否显示刷新按钮
        showToggle: false, // 是否显示详细视图和列表视图的切换按钮
        showColumns: false, // 是否显示列操作按钮
        detailView: false, // 是否显示详细视图
        striped: true, // 设置为true会有隔行变色效果
        dataType: "json", // 服务器返回的数据类型
        pagination: true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // 设置为limit则会发送符合RESTFull格式的参数
        singleSelect: true, // 设置为true将禁止多选
        clickToSelect: true, // 是否启用点击选中行

        // contentType : "application/x-www-form-urlencoded",
        // 发送到服务器的数据编码类型
        pageSize: 10, // 如果设置了分页，每页数据条数
        pageNumber: 1, // 如果设置了分布，首页页码
        search: false, // 是否显示搜索框
        sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams: function (params) {
            return {
                // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                pageSize: 10,
                offset: params.offset,
                search: params.search,
            };
        },
        // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
        // queryParamsType = 'limit' ,返回参数必须包含
        // limit, offset, search, sort, order 否则, 需要包含:
        // pageSize, pageNumber, searchText, sortName,
        // sortOrder.
        // 返回false将会终止请求
        columns: [{
            title: '序号',
            field: 'id',
            align: 'left',
            valign: 'center',
            formatter: function (value, row, index) {
                return index + 1;
            }

        }, {
            title: '日志ID',
            field: 'id',
            align: 'left',
            valign: 'center',

        }, {
            title: '用户名',
            field: 'userName',
            align: 'left',
            valign: 'center',

        }, {
            title: '用户操作',
            field: 'operation',
            align: 'left',
            valign: 'center',

        }, {
            title: '响应时间(毫秒)',
            field: 'time',
            align: 'left',
            valign: 'center',

        }, {
            title: '请求方法',
            field: 'method',
            align: 'left',
            valign: 'center',

        }, {
            title: 'ip地址',
            field: 'ip',
            align: 'left',
            valign: 'center',

        }, {
            title: '创建时间',
            field: 'createTime',
            align: 'left',
            valign: 'center',

        }]
    });
}
