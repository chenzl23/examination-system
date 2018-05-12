<%--
  Created by IntelliJ IDEA.
  User: chenz
  Date: 2018/5/8
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div id="menu">
        <ul class="first_menu">
            <li>
                <a href="#">学生信息管理</a>
                <ul class="second_menu">
                    <li id="chosenPage"><a href="/${base_url}/index">查看学生信息</a></li>
                    <li ><a href="/${base_url}/importStudentInfo">学生信息导入</a></li>
                </ul><!-- /二级菜单 -->
            </li><!-- /学生信息管理li -->

            <li>
                <a href="#">学生成绩管理</a>
                <ul class="second_menu">
                    <li>
                        <a href="#">考勤情况</a>
                        <ul class="third_menu">
                            <li><a href="/${base_url}/studentAttendScore">查看考勤情况</a></li>
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
