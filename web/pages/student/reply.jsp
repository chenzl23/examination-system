<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>软件工程系考务管理系统-学生</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../resources/css/teacher.css">
  <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

  <script src="../../resources/script/jquery.min.js"></script>
  <script src="../../resources/script/bootstrap.min.js"></script>
  <script src="../../resources/script/teacher.js"></script>

</head>
<body>
<div id="wrapper">
  <%@ include file="/pages/common/header.jsp" %>
  <%@ include file="/pages/common/student_menu.jsp" %>




  <div id="content">

        <div id="stuInfo" class="middle">

          <span class="font">教师：</span>
          <select id="teacher" class="select">
            <c:forEach items="${tealist}" var="item">
              <c:choose>
                <c:when test="${param.teacher == item.t_name}">
                  <option value="${item.t_name}" selected>${item.t_name}</option>
                </c:when>
                <c:otherwise>
                  <option value="${item.t_name}">${item.t_name}</option>
                </c:otherwise>
              </c:choose>
            </c:forEach>
          </select></br></br></br>
          <textarea id="message" rows="5" cols="100"></textarea></br></br>
          <input id="reply" type="button" class="button" value="确定" >
        </div>
      </div><!-- /content -->

    </div><!-- /wrapper -->


    <div id="footer">
    </div><!-- /footer -->

  </div><!-- /container -->
<script>
    $("#reply").click(function () {
        $.ajax({
            type: "POST",
            dataType: "json",
            url:"/student/sendmessage",
            data:
                {
                    key:<%=session.getAttribute("key")%>,
                    to: $("#teacher option:selected").val(),
                    message:$("#message").val()
                },
            success: function (data) {
                if (data.state == "true")
                {
                    alert("提交成功");
                }
                else
                {
                    alert("提交失败\n错误信息:"+data.error_message);
                }
            },
            error : function(data) {
                alert("请求失败");
            }
        });
        }
    )
</script>
</body>

</html>
