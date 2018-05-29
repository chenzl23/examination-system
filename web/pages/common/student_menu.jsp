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
            <a href="#">学生操作</a>
            <ul class="second_menu">
                <c:choose>
                    <c:when test="${page.equals('index')}">
                        <li id="chosenPage"><a href="/${base_url}/index?key=<%=session.getAttribute("key") %>">查看学生成绩</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/${base_url}/index?key=<%=session.getAttribute("key") %>">查看学生成绩</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${page.equals('reply')}">
                        <li id="chosenPage"><a href="/${base_url}/reply?key=<%=session.getAttribute("key") %>">反馈</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/${base_url}/reply?key=<%=session.getAttribute("key") %>">反馈</a></li>
                    </c:otherwise>
                </c:choose>
            </ul><!-- /二级菜单 -->
        </li><!-- /学生信息管理li -->

    </ul><!-- /menu_ul -->
</div><!-- /menu -->