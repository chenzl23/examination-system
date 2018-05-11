<!DOCTYPE html>
<html>
<head>
  <title>软件工程系考务管理系统-教师</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../resources/css/importFile.css">
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <script src="../../resources/script/importFile.js"></script>
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
              <li><a href="/index">查看学生信息</a></li>
              <li><a href="importStudentInfo.importStudentInfo.jsp">学生信息导入</a></li>
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
                    <li><a href="studentMidTestScore.html">查看期中成绩</a></li>
                    <li id="chosenPage"><a href="importStudentMidTestScore.html">导入期中成绩</a></li>
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
        <div id="importStudent">
          <p class="title">导入期中成绩</p>
          <div id="import">
            <input type="file" id="file" class="file" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <input type="text" id="URLText" class="input" placeholder="请输入URL">
            <input type="button" id="btnChooseFile" class="button" value="选择文件">
            <input type="button" id="btnConfirmMidTestScore" class="button" value="导入">
            <p class="remind">提示：请选择内容为<strong>期中成绩</strong>的Excel表格</p>
          </div>
          <div id="example">
            <p class="remind">Excel表格格式如下：</p>
            <img src="../../resources/image/期中成绩导入格式.png" width="700px">
          </div>
          
        </div><!-- /importStudent -->

        
      </div><!-- /content -->
      
    </div><!-- /wrapper -->


    <div id="footer">
    </div><!-- /footer --> 

  </div><!-- /container -->  
</body>
</html>