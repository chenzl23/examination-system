<!DOCTYPE html>
<html>
<head>
  <title>软件工程系考务管理系统-教师</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../resources/css/teacher.css">
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <script src="../../resources/script/teacher.js"></script>
</head>
<body>

  <div id="container">
    <div  id="header">
      <div class="inline">
        <h1>软件工程系考务管理系统</h1>
        <p>当前用户：XXXXXXXXXXXXXXX</p>
      </div>
      

      <ul>
        <li>
          <button id="btnLogout">注销</button>
        </li>
      </ul>
    </div>
    <!-- /header -->

    <div id="wrapper">
      <div id="menu">
        <ul class="first_menu">
          <li>
            <a href="#">学生信息管理</a>
            <ul class="second_menu">
              <li><a href="index.html">查看学生信息</a></li>
              <li><a href="importStudentInfo.html">学生信息导入</a></li>
            </ul><!-- /二级菜单 -->
          </li><!-- /学生信息管理li -->
          
          <li>
            <a href="#">学生成绩管理</a>
            <ul class="second_menu">
              <li>
                <a href="#">考勤情况</a>
                <ul class="third_menu">
                  <li><a href="studentAttendScore.html">查看考勤情况</a></li>
                  <li><a href="importStudentAttendScore.html">导入考勤情况</a></li>
                </ul><!-- /三级菜单 -->
              </li>
              
              <li>
                <a href="#">平时成绩</a>
                <ul class="third_menu">
                  <li><a href="studentOrdinaryScore.html">查看平时成绩</a></li>
                  <li><a href="importStudentOrdinaryScore.html">导入平时成绩</a></li>
                </ul><!-- /三级菜单 -->
              </li>
              
              <li>
                <a href="#">实验成绩</a>
                <ul class="third_menu">
                  <li><a href="studentExperimentScore.html">查看实验成绩</a></li>  
                  <li><a href="importStudentExperimentScore.html">导入实验成绩</a></li>
                </ul><!-- /三级菜单 -->
              </li>
              
              <li>
                <a href="#">期中成绩</a>
                <ul class="third_menu">
                  <li id="chosenPage"><a href="studentMidTestScore.html">查看期中成绩</a></li>
                  <li><a href="importStudentMidTestScore.html">导入期中成绩</a></li>
                </ul><!-- /三级菜单 -->
              </li>
              
              <li>
                <a href="#">卷面成绩</a>
                <ul class="third_menu">
                  <li><a href="studentFinalExamScore.html">查看卷面成绩</a></li>
                  <li><a href="importStudentFinalExamScore.html">导入卷面成绩</a></li>
                </ul><!-- /三级菜单 -->
              </li>
            </ul><!-- /二级菜单 -->
          </li><!-- /学生成绩管理li -->
          
          <li>
            <a href="#">成绩统计表</a>
            <ul class="second_menu">
              <li><a href="studentTotalScore.html">查看总成绩</a></li>
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
          <input id="btnConfirmMidTestScore" type="button" class="button" value="确定" >
        </div><!-- /search -->

        <div id="stuMidTestScore" class="middle">
          <div>
              <input type="text" class="inputText" placeholder="学生学号">
              <input type="text" class="inputText" placeholder="学生姓名">
              <input id="btnSelectStuMidTestScore" type="button" class="button" value="查询">
              <input id="btnRefreshMidTestScore" type="button" class="button" value="刷新">
          </div>
          
          <table class="table">
            <thead>
              <tr>
                <th>学生学号</th>
                <th>学生姓名</th>
                <th>期中成绩</th>
              </tr>
            </thead>
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td>学生学号</td>
                <td>学生姓名</td>
                <td>80</td>
              </tr>
              <tr>
                <td>学生学号</td>
                <td>学生姓名</td>
                <td>90</td>
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