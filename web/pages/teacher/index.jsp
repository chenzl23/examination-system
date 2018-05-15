<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>软件工程系考务管理系统-教师</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../resources/css/teacher.css">
  <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="../../resources/css/bootstrap-table.css">
  <link href="../../resources/css/bootstrap-editable.css" rel="stylesheet">

  <script src="../../resources/script/jquery.min.js"></script>
  <script src="../../resources/script/bootstrap.min.js"></script>
  <script src="../../resources/script/bootstrap-table.js"></script>
  <script src="../../resources/script/bootstrap-table-zh-CN.js"></script>
  <script src="../../resources/script/bootstrap-editable.min.js"> </script>
  <script src="../../resources/script/bootstrap-table-editable.js"> </script>
    <script src="../../resources/script/tableExport.jquery.plugin-master/tableExport.js"> </script>
    <script src="../../resources/script/tableExport.jquery.plugin-master/tableExport.min.js"> </script>
    <script src="../../resources/script/tableExport.jquery.plugin-master/libs/js-xlsx/xlsx.core.min.js"> </script>
    <script src="../../resources/script/tableExport.jquery.plugin-master/libs/jsPDF/jspdf.min.js"> </script>
    <script src="../../resources/script/tableExport.jquery.plugin-master/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"> </script>
    <script src="../../resources/script/bootstrap-table-export.js"> </script>
  <script src="../../resources/script/teacher.js"></script>
  <script src="../../resources/script/${table_js}"></script>

</head>
<body>
<div id="wrapper">
  <%@ include file="/pages/common/header.jsp" %>
  <%@ include file="/pages/common/teacher_menu.jsp" %>




  <div id="content">
        <div id="selectCourse" class="middle">
          <span class="font">年级：</span>
          <select id="grade" class="select">
              <option value="2015">2015</option>
              <option value="2016">2016</option>
          </select>
          <span class="font">课程：</span>
          <select id="course" class="select">
              <c:forEach items="${courselist}" var="course">
                  <c:choose>
                      <c:when test="${param.course == course.cno}">
                          <option value="${course.cno}" selected>${course.c_name}</option>
                      </c:when>
                      <c:otherwise>
                          <option value="${course.cno}">${course.c_name}</option>
                      </c:otherwise>
                  </c:choose>
              </c:forEach>
          </select>
          <input id="btnConfirm" type="button" class="button" value="确定" >
        </div><!-- /search -->

        <div id="stuInfo" class="middle">

          <table  id="tb_info">
            <thead>
              <tr>
                <c:forEach items="${title}" var="line" >
                    <th>${line}</th>
                </c:forEach>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="line" >
                <tr>
                    <c:forEach items="${line}" var="data">
                        <td>${data}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div><!-- /content -->

    </div><!-- /wrapper -->


    <div id="footer">
    </div><!-- /footer -->

  </div><!-- /container -->
<script>
    $("#btnConfirm").click(function () {
        course = $("#course option:selected").val();
        grade = $("#grade option:selected").val();
        window.location.href="/teacher/${page}?key=<%=session.getAttribute("key")%>&grade="+grade+"&course="+course;
        }
    )
</script>
</body>

</html>
