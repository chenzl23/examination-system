<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>软件工程系考务管理系统-教师</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../resources/css/teacher.css">
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <script src="../../resources/script/teacher.js"></script>
  <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="../../resources/css/bootstrap-table.css">
  <script src="../../resources/script/jquery.min.js"></script>
  <script src="../../resources/script/bootstrap.min.js"></script>
  <script src="../../resources/script/bootstrap-table.js"></script>
  <script src="../../resources/script/bootstrap-table-zh-CN.js"></script>
</head>
<body>

<%@ include file="/pages/common/header.jsp" %>
<div id="menu">
  <ul class="first_menu">
    <li>
      <a href="#">学生信息管理</a>
      <ul class="second_menu">
        <li ><a href="/${base_url}/index">查看学生信息</a></li>
        <li ><a href="/${base_url}/importStudentInfo">学生信息导入</a></li>
      </ul><!-- /二级菜单 -->
    </li><!-- /学生信息管理li -->

    <li>
      <a href="#">学生成绩管理</a>
      <ul class="second_menu">
        <li>
          <a href="#">考勤情况</a>
          <ul class="third_menu">
            <li id="chosenPage"><a href="/${base_url}/studentAttendScore">查看考勤情况</a></li>
            <li><a href="/${base_url}/importStudentAttendScore">导入考勤情况</a></li>
          </ul><!-- /三级菜单 -->
        </li>

        <li>
          <a href="#">平时成绩</a>
          <ul class="third_menu">
            <li><a href="/${base_url}/studentOrdinaryScore">查看平时成绩</a></li>
            <li><a href="/${base_url}/importStudentOrdinaryScore">导入平时成绩</a></li>
          </ul><!-- /三级菜单 -->
        </li>

        <li>
          <a href="#">实验成绩</a>
          <ul class="third_menu">
            <li><a href="/${base_url}/studentExperimentScore">查看实验成绩</a></li>
            <li><a href="/${base_url}/importStudentExperimentScore">导入实验成绩</a></li>
          </ul><!-- /三级菜单 -->
        </li>

        <li>
          <a href="#">期中成绩</a>
          <ul class="third_menu">
            <li><a href="/${base_url}/studentMidTestScore">查看期中成绩</a></li>
            <li><a href="/${base_url}/importStudentMidTestScore">导入期中成绩</a></li>
          </ul><!-- /三级菜单 -->
        </li>

        <li>
          <a href="#">卷面成绩</a>
          <ul class="third_menu">
            <li><a href="/${base_url}/studentFinalExamScore">查看卷面成绩</a></li>
            <li><a href="/${base_url}/importStudentFinalExamScore">导入卷面成绩</a></li>
          </ul><!-- /三级菜单 -->
        </li>
      </ul><!-- /二级菜单 -->
    </li><!-- /学生成绩管理li -->

    <li>
      <a href="#">成绩统计表</a>
      <ul class="second_menu">
        <li><a href="/${base_url}/studentTotalScore">查看总成绩</a></li>
      </ul><!-- /二级菜单 -->
    </li><!-- /成绩统计表li -->
  </ul><!-- /menu_ul -->
</div><!-- /menu -->

      

      <div id="content">
        <div id="selectCourse" class="middle">
          <span class="font">学期学年：</span>
          <select class="select">
              <option>2015-2016</option>
              <option>2016-2017</option>
          </select>
          <span class="font">课程：</span>
          <select class="select">
              <option>Java</option>
              <option>C#</option>
          </select>
          <input id="btnConfirmAttendScore" type="button" class="button" value="确定" >
        </div><!-- /search -->

        <div id="stuAttendScore" class="middle">
          <div>
              <input type="text" class="inputText" placeholder="学生学号">
              <input type="text" class="inputText" placeholder="学生姓名">
              <input id="btnSelectStuAttendScore" type="button" class="button" value="查询">
              <input id="btnRefreshAttendScore" type="button" class="button" value="刷新">
          </div>
          
          <table id="table"class="table table-striped table-bordered table-hover">
            <thead>
              <tr>
                <th>学生学号</th>
                <th>学生姓名</th>
                <th>迟到</th>
                <th>旷课</th>
                <th>请假</th>
                <th>备注</th>
              </tr>
            </thead>
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td>学生学号</td>
                <td>学生姓名</td>
                <th>1</th>
                <th>2</th>
                <th>3</th>
                <th></th>
              </tr>
              <tr>
                <td>学生学号</td>
                <td>学生姓名</td>
                <th>2</th>
                <th>0</th>
                <th>1</th>
                <th></th>
              </tr>
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