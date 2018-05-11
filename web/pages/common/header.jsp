<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="container">
    <div  id="header">
        <div class="inline">
            <h1>软件工程系考务管理系统</h1>
            <p>当前用户：<%=session.getAttribute("username")%></p>
        </div>


        <ul>
            <li>
                <button id="btnLogout">注销</button>
            </li>
        </ul>
    </div>
    <!-- /header -->