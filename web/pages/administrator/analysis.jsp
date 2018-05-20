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

    <script src="../../resources/script/Chart.bundle.js"></script>
    <script src="../../resources/script/Chart.bundle.min.js"></script>
    <script src="../../resources/script/Chart.js"></script>
    <script src="../../resources/script/Chart.min.js"></script>
  <script src="../../resources/script/teacher.js"></script>
  <script src="../../resources/script/table_analysis.js"></script>

</head>
<body>
<div id="wrapper">
  <%@ include file="/pages/common/header.jsp" %>

      <span class="font">课程：</span>
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
          <input id="selectTeacher" type="button" class="button" value="确定" >
      </select>
          <table  id="tb_info">
            <thead>
              <tr>
                  <th></th>
               <th>0-59</th>
               <th>60-69</th>
                  <th>70-79</th>
                  <th>80-89</th>
                  <th>90-100</th>
              </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${title[0]}</td>
                    <c:forEach items="${daily}" var="data">
                        <td>${data}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>${title[1]}</td>
                    <c:forEach items="${mid}" var="data">
                        <td>${data}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>${title[2]}</td>
                    <c:forEach items="${fin}" var="data">
                        <td>${data}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>${title[3]}</td>
                    <c:forEach items="${exp}" var="data">
                        <td>${data}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>${title[4]}</td>
                    <c:forEach items="${total}" var="data">
                        <td>${data}</td>
                    </c:forEach>
                </tr>
            </tbody>
          </table>
      <div id="stuInfo" class="middle" style="width: 500px; height: 500px; display: block;">
      <canvas id="Chart1" width="20" height="20" ></canvas>
      </div>
      <div id="stuInfo" class="middle" style="width: 500px; height: 500px; display: block;">
          <canvas id="Chart2" width="20" height="20" ></canvas>
      </div>

      <div id="stuInfo" class="middle" style="width: 500px; height: 500px; display: block;">
          <canvas id="Chart3" width="20" height="20" ></canvas>
      </div>

      <div id="stuInfo" class="middle" style="width: 500px; height: 500px; display: block;">
          <canvas id="Chart4" width="20" height="20" ></canvas>
      </div>

      <div id="stuInfo" class="middle" style="width: 500px; height: 500px; display: block;">
          <canvas id="Chart5" width="20" height="20" ></canvas>
      </div>
      <script>
          var ctx = $("#Chart1");
          var myChart = new Chart(ctx, {
              type: 'bar',

              data: {
                  labels: ["0-59", "60-69", "70-79", "80-89", "90-100"],
                  datasets: [{
                      label: '人数',
                      data: [<c:forEach items="${daily}" var="data">
                      ${data},</c:forEach>],
                      backgroundColor: [
                          'rgba(255, 99, 132, 0.2)',
                          'rgba(54, 162, 235, 0.2)',
                          'rgba(255, 206, 86, 0.2)',
                          'rgba(75, 192, 192, 0.2)',
                          'rgba(153, 102, 255, 0.2)'
                      ],
                      borderColor: [
                          'rgba(255,99,132,1)',
                          'rgba(54, 162, 235, 1)',
                          'rgba(255, 206, 86, 1)',
                          'rgba(75, 192, 192, 1)',
                          'rgba(153, 102, 255, 1)'
                      ],
                      borderWidth: 1
                  }]
              },
              options: {
                  title:{
                      display:true,
                      text:"平时成绩分布"
                  },
                  legend: {
                      labels: {
                          // This more specific font property overrides the global property
                          fontColor: 'black',
                      }
                  }

              }
          });

          var ctx = $("#Chart2");
          var myChart = new Chart(ctx, {
              type: 'bar',

              data: {
                  labels: ["0-59", "60-69", "70-79", "80-89", "90-100"],
                  datasets: [{
                      label: '人数',
                      data: [<c:forEach items="${mid}" var="data">
                          ${data},</c:forEach>],
                      backgroundColor: [
                          'rgba(255, 99, 132, 0.2)',
                          'rgba(54, 162, 235, 0.2)',
                          'rgba(255, 206, 86, 0.2)',
                          'rgba(75, 192, 192, 0.2)',
                          'rgba(153, 102, 255, 0.2)'
                      ],
                      borderColor: [
                          'rgba(255,99,132,1)',
                          'rgba(54, 162, 235, 1)',
                          'rgba(255, 206, 86, 1)',
                          'rgba(75, 192, 192, 1)',
                          'rgba(153, 102, 255, 1)'
                      ],
                      borderWidth: 1
                  }]
              },
              options: {
                  title:{
                      display:true,
                      text:"期中成绩分布"
                  },
                  legend: {
                      labels: {
                          // This more specific font property overrides the global property
                          fontColor: 'black',
                      }
                  }

              }
          });

          var ctx = $("#Chart3");
          var myChart = new Chart(ctx, {
              type: 'bar',

              data: {
                  labels: ["0-59", "60-69", "70-79", "80-89", "90-100"],
                  datasets: [{
                      label: '人数',
                      data: [<c:forEach items="${fin}" var="data">
                          ${data},</c:forEach>],
                      backgroundColor: [
                          'rgba(255, 99, 132, 0.2)',
                          'rgba(54, 162, 235, 0.2)',
                          'rgba(255, 206, 86, 0.2)',
                          'rgba(75, 192, 192, 0.2)',
                          'rgba(153, 102, 255, 0.2)'
                      ],
                      borderColor: [
                          'rgba(255,99,132,1)',
                          'rgba(54, 162, 235, 1)',
                          'rgba(255, 206, 86, 1)',
                          'rgba(75, 192, 192, 1)',
                          'rgba(153, 102, 255, 1)'
                      ],
                      borderWidth: 1
                  }]
              },
              options: {
                  title:{
                      display:true,
                      text:"期末卷面成绩分布"
                  },
                  legend: {
                      labels: {
                          // This more specific font property overrides the global property
                          fontColor: 'black',
                      }
                  }

              }
          });

          var ctx = $("#Chart4");
          var myChart = new Chart(ctx, {
              type: 'bar',

              data: {
                  labels: ["0-59", "60-69", "70-79", "80-89", "90-100"],
                  datasets: [{
                      label: '人数',
                      data: [<c:forEach items="${exp}" var="data">
                          ${data},</c:forEach>],
                      backgroundColor: [
                          'rgba(255, 99, 132, 0.2)',
                          'rgba(54, 162, 235, 0.2)',
                          'rgba(255, 206, 86, 0.2)',
                          'rgba(75, 192, 192, 0.2)',
                          'rgba(153, 102, 255, 0.2)'
                      ],
                      borderColor: [
                          'rgba(255,99,132,1)',
                          'rgba(54, 162, 235, 1)',
                          'rgba(255, 206, 86, 1)',
                          'rgba(75, 192, 192, 1)',
                          'rgba(153, 102, 255, 1)'
                      ],
                      borderWidth: 1
                  }]
              },
              options: {
                  title:{
                      display:true,
                      text:"实验成绩分布"
                  },
                  legend: {
                      labels: {
                          // This more specific font property overrides the global property
                          fontColor: 'black',
                      }
                  }

              }
          });

          var ctx = $("#Chart5");
          var myChart = new Chart(ctx, {
              type: 'bar',

              data: {
                  labels: ["0-59", "60-69", "70-79", "80-89", "90-100"],
                  datasets: [{
                      label: '人数',
                      data: [<c:forEach items="${total}" var="data">
                          ${data},</c:forEach>],
                      backgroundColor: [
                          'rgba(255, 99, 132, 0.2)',
                          'rgba(54, 162, 235, 0.2)',
                          'rgba(255, 206, 86, 0.2)',
                          'rgba(75, 192, 192, 0.2)',
                          'rgba(153, 102, 255, 0.2)'
                      ],
                      borderColor: [
                          'rgba(255,99,132,1)',
                          'rgba(54, 162, 235, 1)',
                          'rgba(255, 206, 86, 1)',
                          'rgba(75, 192, 192, 1)',
                          'rgba(153, 102, 255, 1)'
                      ],
                      borderWidth: 1
                  }]
              },
              options: {
                  title:{
                      display:true,
                      text:"期末总评成绩分布"
                  },
                  legend: {
                      labels: {
                          // This more specific font property overrides the global property
                          fontColor: 'black',
                      }
                  }

              }
          });

          $("#selectTeacher").click(function () {
                 tea = $("#teacher option:selected").val();
                  window.location.href="/super/analysis?key=<%=session.getAttribute("key")%>&grade=${param.grade}&course=${param.course}&teacher="+tea;
              }
          )
      </script>
</body>

</html>
