<%--
  Created by IntelliJ IDEA.
  User: pkl
  Date: 2021/5/13
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>注册用户</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <form action="user/addUser.do" method="post">
            <table>
                <tr>
                    <td>编号:</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>姓名:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>出生年月日:</td>
                    <td><input type="date" name="birthday"></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td><input type="text" name="sex"></td>
                </tr>
                <tr>
                    <td>住址:</td>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="submit" value="注册"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
