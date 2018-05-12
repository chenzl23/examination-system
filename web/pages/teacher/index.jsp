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
  <script src="../../resources/script/table.js"></script>

</head>
<body>
<div id="wrapper">
  <%@ include file="/pages/common/header.jsp" %>
  <div id="menu">
    <ul class="first_menu">
      <li>
        <a href="#">学生信息管理</a>
        <ul class="second_menu">
          <li id="chosenPage"><a href="/index">查看学生信息</a></li>
          <li ><a href="/index/importStudentInfo">学生信息导入</a></li>
        </ul><!-- /二级菜单 -->
      </li><!-- /学生信息管理li -->

      <li>
        <a href="#">学生成绩管理</a>
        <ul class="second_menu">
          <li>
            <a href="#">考勤情况</a>
            <ul class="third_menu">
              <li><a href="/index/studentAttendScore">查看考勤情况</a></li>
              <li><a href="/index/importStudentAttendScore">导入考勤情况</a></li>
            </ul><!-- /三级菜单 -->
          </li>

          <li>
            <a href="#">平时成绩</a>
            <ul class="third_menu">
              <li><a href="/index/studentOrdinaryScore">查看平时成绩</a></li>
              <li><a href="/index/importStudentOrdinaryScore">导入平时成绩</a></li>
            </ul><!-- /三级菜单 -->
          </li>

          <li>
            <a href="#">实验成绩</a>
            <ul class="third_menu">
              <li><a href="/index/studentExperimentScore">查看实验成绩</a></li>
              <li><a href="/index/importStudentExperimentScore">导入实验成绩</a></li>
            </ul><!-- /三级菜单 -->
          </li>

          <li>
            <a href="#">期中成绩</a>
            <ul class="third_menu">
              <li><a href="/index/studentMidTestScore">查看期中成绩</a></li>
              <li><a href="/index/importStudentMidTestScore">导入期中成绩</a></li>
            </ul><!-- /三级菜单 -->
          </li>

          <li>
            <a href="#">卷面成绩</a>
            <ul class="third_menu">
              <li><a href="/index/studentFinalExamScore">查看卷面成绩</a></li>
              <li><a href="/index/importStudentFinalExamScore">导入卷面成绩</a></li>
            </ul><!-- /三级菜单 -->
          </li>
        </ul><!-- /二级菜单 -->
      </li><!-- /学生成绩管理li -->

      <li>
        <a href="#">成绩统计表</a>
        <ul class="second_menu">
          <li><a href="/index/studentTotalScore">查看总成绩</a></li>
        </ul><!-- /二级菜单 -->
      </li><!-- /成绩统计表li -->
    </ul><!-- /menu_ul -->
  </div><!-- /menu -->




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
                <th>学生学号</th>
                <th>学生姓名</th>
                <th>出生年月</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>已获学分</th>
                <th>需获学分</th>
                 <th>入学年份</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="line" >
                <tr>
                    <td> ${line.id}</td>
                    <td>${line.name}</td>
                    <td>${line.birth}</td>
                    <td>${line.tel}</td>
                    <td>${line.email}</td>
                    <td>${line.credit_got}</td>
                    <td>${line.credit_need}</td>
                    <td>${line.enrollyear}</td>
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
