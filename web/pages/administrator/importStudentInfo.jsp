<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>软件工程系考务管理系统-教师</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../resources/css/teacher.css">
  <link rel="stylesheet" href="../../resources/css/importFile.css">
  <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="../../resources/css/bootstrap-table.css">
  <link href="../../resources/css/bootstrap-editable.css" rel="stylesheet">

  <script src="../../resources/script/jquery.min.js"></script>
  <script src="../../resources/script/bootstrap.min.js"></script>
  <script src="../../resources/script/bootstrap-table.js"></script>
  <script src="../../resources/script/bootstrap-table-zh-CN.js"></script>
  <script src="../../resources/script/bootstrap-editable.min.js"> </script>
  <script src="../../resources/script/bootstrap-table-editable.js"> </script>
  <script src="../../resources/script/importFile.js"></script>
</head>
<body>
<div id="wrapper">
<%@ include file="/pages/common/header.jsp" %>
<%@ include file="/pages/common/super_menu.jsp" %>

      

      <div id="content">
        <div id="importStudent">
          <p class="title">导入${title}</p>
          <div id="import">
            <input type="file" id="file" class="file" name="file" style="display: none" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <input class="input" id="URLText" type="text" placeholder="请输入URL">
            <input class="button" id="btnChooseFile" type="button" value="选择文件">
            <input type="button" id="btnConfirm" class="button" value="导入">
            <p class="remind">提示：请选择内容为<strong>${title}</strong>的Excel表格</p>
          </div>
          <div id="example">
            <p class="remind">Excel表格格式如下：</p>
            <img src="../../resources/image/学生信息导入格式.png" width="700px">
          </div>
          
        </div><!-- /importStudent -->

        
      </div><!-- /content -->
      
    </div><!-- /wrapper -->


    <div id="footer">
    </div><!-- /footer --> 

  </div><!-- /container -->
<script>
    $("#btnConfirm").click(function(){
        if(true) //URL存在并且文件内容格式正确
        {
            alert("开始上传");
            //TODO:后端录入文本框中的学生信息Excel文件

            var file = $('#file').prop('files');
            var formdata = new FormData();
            formdata.append('file',file[0]);
            $.ajax({
                url: '/upload/${sub_url}' ,
                type: 'post',
                data: formdata,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (result) {
                    if (result.state =="success")
                        alert("上传成功,成功导入"+result.nums+"条${title}");
                    else
                        alert("上传失败，请检查文件格式和内容\n错误信息："+result.state);
                },
                error:function (result) {
                    alert("上传失败\n错误信息：服务器连接失败");
                    console.log(formdata.get("file"));
                }
            });

        }
    })
</script>
</body>
</html>