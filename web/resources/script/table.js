$(document).ready(function () {
    $('#tb_info').bootstrapTable({
        pagination: true,//启用分页
        clickToSelect: true,//启用点击选中
        striped: true,//启用条纹样式
        search: true,//启用搜索框
        showRefresh: true,//启用刷新按钮
        showColumns:true,
        sortName:"id" ,

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
            },
            {
                field: 'name',
                editable: {//启用输入框
                    type: 'text',//input输入框类别
                    validate: function (v) {
                        if (v == '')
                            return '输入不能为空';
                    }
                }
            },
            {
                field: 'birth',
                editable: {
                    type: 'date',
                    title: '生日'
                }
            },
            {
                field: 'tel',
                editable: {
                    type: 'text',
                    title: '电话',
                    validate: function (v) {
                        if (isNaN(v))//这个只是判断是不是数字，验证你可以自己写
                            return '输入的电话号码不合法';
                    }
                }
            },
            {
                field: 'email',
                editable: {
                    type: 'email',//这个不确定能不能用，不可的话就改成text，然后自己加验证方法
                    title: '邮箱'
                }
            },
            {
                field: 'credit_got'
            },
            {
                field: 'credit_need'
            },
            {
                field: 'encroll_year',
                editable: {
                    type: 'number',
                    min: 1900,//最小值
                    step: 1,
                    value: 2000//默认值
                }
            }
        ]
    });
});