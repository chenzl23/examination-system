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
            $.ajax({
                type: "post",
                url: "/modify/mark",
                data: row,
                dataType: 'JSON',
                success: function (data, status) {
                    if (status == "success") {
                        alert('提交数据成功');
                    }
                },
                error: function () {
                    alert('编辑失败');
                },
                complete: function () {

                }

            });
        },
        columns: [
            {
                field: 'course_num',
                title:'选课编码'
            },
            {
                field: 'course_name',
                title:'课程名'
            },
            {
                field: 's_no',
                title:'选课编码'
            },
            {
                field: 's_name',
                title:'姓名'
            },
            {
                field: 'term',
                title:'开设年级'
            },
            {
                field: 'teacher',
                title:'教师'
            },
            {
                field: 'daily_work',
                title:'平时成绩',
                editable: {
                    type: 'number',
                    min: 0,//最小值
                    step: 1,
                    value: 100//默认值
                }
            },
            {
                field: 'mid_exam',
                title:'期中成绩',
                editable: {
                    type: 'number',
                    min: 0,//最小值
                    step: 1,
                    value: 100//默认值
                }
            },
            {
                field: 'final_exam',
                title:'期末成绩',
                editable: {
                    type: 'number',
                    min: 0,//最小值
                    step: 1,
                    value: 100//默认值
                }
            },
            {
                field: 'experiment',
                title:'实验成绩',
                editable: {
                    type: 'number',
                    min: 0,//最小值
                    step: 1,
                    value: 100//默认值
                }
            },
            {
                field: 'total_remark',
                title:'总评成绩',
                editable: {
                    type: 'number',
                    min: 0,//最小值
                    step: 1,
                    value: 100//默认值
                }
            },
            {
                field: 'status',
                title:'选课状态',
            }

        ]
    });
});