<!DOCTYPE html>
<html>
<head>
  <title>软件工程系考务管理系统-教师</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../resources/css/studentInfo.css">
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <script src="../../resources/script/studentInfo.js"></script>
</head>
<body>

  <div id="container">
    <div  id="header">
      <div class="inline">
        <h1>软件工程系考务管理系统</h1>
        <p>当前用户：XXXXXXXXXXXXXXX</p>
      </div>
    </div>
    <!-- /header -->

    <div id="wrapper">
      
      <div id="content">
            <table class="table">
                <caption>学生单科总成绩</caption>
                <tr>
                    <td class="sheet1">学期学年</td>
                    <td class="sheet2" id="stuCourseYear">2015-2016</td>
                    <td class="sheet1">课程</td>
                    <td class="sheet2" id="stuCourse">Java</td>
                </tr>
                <tr>
                    <td class="sheet1">学生学号</td>
                    <td class="sheet2" id="stuId">111500101</td>
                    <td class="sheet1">学生姓名</td>
                    <td class="sheet2" id="stuName">李</td>
                </tr>
                <tr>
                    <td class="sheet1">总成绩</td>
                    <td class="sheet2" id="stuTotalScore"><input type="text" value="80"></td>
                    <td class="sheet1">成绩排名</td>
                    <td class="sheet2" id="stuRankScore">3</td>
                </tr>
            </table>
            <div id="buttons" class="middle">
                <button id="confirmModifyTotalScore" class="button confirmModify">确认修改</button>
                <button id="cancelModifyTotalScore" class="button cancelModify">取消修改</button>
            </div>
      </div>
    </div><!-- /wrapper -->


    <div id="footer">
    </div><!-- /footer --> 

  </div><!-- /container -->  
</body>
</html>
