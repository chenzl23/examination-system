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
            </ul><!-- /二级菜单 -->
        </li><!-- /学生信息管理li -->

        <li>
            <a href="#">学生成绩管理</a>
            <ul class="second_menu">
                <c:choose>
                    <c:when test="${page.equals('getStudentMark')}">
                        <li id="chosenPage"><a href="/${base_url}/getStudentMark?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看学生成绩</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/${base_url}/getStudentMark?key=<%=session.getAttribute("key") %>&grade=0&course=0">查看学生成绩</a></li>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${page.equals('importStudentMark')}">
                        <li id="chosenPage"><a href="/${base_url}/importStudentMark?key=<%=session.getAttribute("key") %>">学生成绩导入</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/${base_url}/importStudentMark?key=<%=session.getAttribute("key") %>">学生成绩导入</a></li>
                    </c:otherwise>
                </c:choose>
            </ul><!-- /二级菜单 -->
        </li><!-- /成绩统计表li -->
    </ul><!-- /menu_ul -->
</div><!-- /menu -->