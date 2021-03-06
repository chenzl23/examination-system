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
                <c:choose>
                    <c:when test="${page.equals('index')}">
                        <li id="chosenPage"><a href="/${base_url}/index?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看学生信息</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/${base_url}/index?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看学生信息</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.equals('importStudentInfo')}">
                        <li id="chosenPage"><a href="/${base_url}/importStudentInfo?key=<%=session.getAttribute("key") %>">学生信息导入</a></li>
                    </c:when>
                    <c:otherwise>
                        <li ><a href="/${base_url}/importStudentInfo?key=<%=session.getAttribute("key") %>">学生信息导入</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.equals('getmessage')}">
                        <li id="chosenPage"><a href="/${base_url}/getmessage?key=<%=session.getAttribute("key") %>">查看学生反馈</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/${base_url}/getmessage?key=<%=session.getAttribute("key") %>">查看学生反馈</a></li>
                    </c:otherwise>
                </c:choose>
            </ul><!-- /二级菜单 -->
        </li><!-- /学生信息管理li -->

        <li>
            <a href="#">教务信息管理</a>
            <ul class="second_menu">
                <li>
                    <a href="#">课程安排</a>
                    <ul class="third_menu">
                    <c:choose>
                    <c:when test="${page.equals('getCourseInfo')}">
                        <li id="chosenPage"><a href="/${base_url}/getCourseInfo?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看课程信息</a></li>
                    </c:when>
                    <c:otherwise>
                         <li><a href="/${base_url}/getCourseInfo?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看课程信息</a></li>
                    </c:otherwise>
                    </c:choose>
                <c:choose>
                    <c:when test="${page.equals('importCourseInfo')}">
                        <li id="chosenPage"><a href="/${base_url}/importCourseInfo?key=<%=session.getAttribute("key") %>">导入课程信息</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/${base_url}/importCourseInfo?key=<%=session.getAttribute("key") %>">导入课程信息</a></li>
                    </c:otherwise>
                </c:choose>
                    </ul>
                </li>

                <li>
                    <a href="#">教师信息</a>
                    <ul class="third_menu">
                        <c:choose>
                            <c:when test="${page.equals('getTeacher')}">
                                <li id="chosenPage"><a href="/${base_url}/getTeacher?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看教师信息</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/${base_url}/getTeacher?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看教师信息</a></li>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${page.equals('importTeacher')}">
                                <li id="chosenPage"><a href="/${base_url}/importTeacher?key=<%=session.getAttribute("key") %>">导入教师信息</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/${base_url}/importTeacher?key=<%=session.getAttribute("key") %>">导入教师信息</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul><!-- /三级菜单 -->
                </li>
                <li>
                    <a href="#">选课信息</a>
                    <ul class="third_menu">
                        <c:choose>
                            <c:when test="${page.equals('getCourseChosen')}">
                                <li id="chosenPage"><a href="/${base_url}/getCourseChosen?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看选课信息</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/${base_url}/getCourseChosen?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看选课信息</a></li>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${page.equals('importCourseChosen')}">
                                <li id="chosenPage"><a href="/${base_url}/importCourseChosen?key=<%=session.getAttribute("key") %>">导入选课信息</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/${base_url}/importCourseChosen?key=<%=session.getAttribute("key") %>">导入选课信息</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul><!-- /三级菜单 -->
                </li>

            </ul><!-- /二级菜单 -->
        </li><!-- /学生成绩管理li -->

        <li>
            <a href="#">成绩查看</a>
            <ul class="second_menu">
                <c:choose>
                    <c:when test="${page.equals('getStudentMark')}">
                        <li id="chosenPage"><a href="/${base_url}/getStudentMark?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看学生成绩</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/${base_url}/getStudentMark?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看学生成绩</a></li>
                    </c:otherwise>
                </c:choose>
            </ul><!-- /二级菜单 -->
        </li><!-- /成绩统计表li -->
    </ul><!-- /menu_ul -->
</div><!-- /menu -->