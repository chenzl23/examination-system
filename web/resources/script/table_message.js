$(document).ready(function () {
    $('#tb_info').bootstrapTable({
        pagination: true,//启用分页
        clickToSelect: true,//启用点击选中
        striped: true,//启用条纹样式
        search: true,//启用搜索框
        showRefresh: true,//启用刷新按钮
        showColumns:true,
        searchAlign:'left',
        sortName:"id" ,
        showExport:"true",
        exportDataType:"all",
        exportTypes:[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx'],  //导出文件类型
        onRefresh: function () {//刷新事件
            location.reload();
        },
        onEditableSave: function (field, row, oldValue) {//输入框保存事件
            /**
             * 参数说明：
             * field：刚刚修改的列的Id，就是下面columns数组里的field
             * row：修改项所在行
             * 具体的值就是像  row.id   row.name  row.birth ... 这样子的
             * 
             * 
             * 这里写ajax方法保存输入框输入的值
             * */
        },
        columns: [
            {
                field: 'id',
                title:'学生学号'
            },
            {
                field: 'from_name',
                title:'学生姓名'
            },
            {
                field: 'message',
                title:'反馈信息'
            },
            {
                field: 't_name',
                title:'反馈老师'
            }
        ]
    });
});