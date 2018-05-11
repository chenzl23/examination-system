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
      <div id="buttons" class="middle">
        <button id="modify" class="button">修改</button>
        <button id="delete" class="button">删除</button>
      </div>
      <div id="content">
            <table class="table">
                <caption>学生个人信息一览表</caption>
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
                    <td class="sheet1">性别</td>
                    <td class="sheet2" id="stuSex">男</td>
                    <td class="sheet1">出生年月</td>
                    <td class="sheet2" id="stuBirth">2000-01-01</td>
                </tr>
                <tr>
                    <td class="sheet1">电话</td>
                    <td class="sheet2" id="stuPhone">22866110</td>
                    <td class="sheet1">邮箱</td>
                    <td class="sheet2" id="stuMail">123456789@qq.com</td>
                </tr>
                <tr>
                    <td class="sheet1">专业</td>
                    <td class="sheet2" id="stuMajor">软件工程</td>
                    <td class="sheet1">入学年份</td>
                    <td class="sheet2" id="stuEntrance">2015</td>
                </tr>
                <tr>
                    <td class="sheet1" id="stuGetCredit">已获学分</td>
                    <td class="sheet2">30</td>
                    <td class="sheet1" id="stuNeedCredit">需获学分</td>
                    <td class="sheet2">40</td>
                </tr>
                <tr>
                    <td class="sheet1" id="stuCourseState">课程状态</td>
                    <td class="sheet2">重修</td>
                    <td class="sheet1" id="stuCourseScore">总成绩</td>
                    <td class="sheet2">0</td>
                </tr>
            </table>
          
      </div>
    </div><!-- /wrapper -->


    <div id="footer">
    </div><!-- /footer --> 

  </div><!-- /container -->  
</body>
</html>
