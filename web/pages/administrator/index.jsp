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
  <script src="../../resources/script/teacher.js"></script>
  <script src="../../resources/script/${table_js}"></script>

</head>
<body>
<div id="wrapper">
  <%@ include file="/pages/common/header.jsp" %>
  <%@ include file="/pages/common/super_menu.jsp" %>




  <div id="content">
        <div id="selectCourse" class="middle">
          <span class="font">年级：</span>
          <select class="select">
              <option>2015</option>
              <option>2016</option>
          </select>
          <span class="font">课程：</span>
          <select class="select">
              <option>Java</option>
              <option>C#</option>
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
</body>

</html>
