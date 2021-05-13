<%--
  Created by IntelliJ IDEA.
  User: pkl
  Date: 2021/5/13
  Time: 16:47
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
    <title>查询学生ajax</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            // 进入当前页面直接就加载数据，不需要单击一下
            loadUserData();
            // 单击按钮重新加载数据
            $("#btnLoader").click(function () {
                loadUserData();
            })
        })
        
        function loadUserData() {
            $.ajax({
                url:"user/queryUser.do",
                type:"get",
                dataType:"json",
                success:function (data) {
                    // 清除旧的数据
                    $("#info").html("");
                    // 增加新的数据
                    $.each(data, function (i, n) {
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.username+"</td>")
                            .append("<td>"+n.birthday+"</td>")
                            .append("<td>"+n.sex+"</td>")
                            .append("<td>"+n.address+"</td>")
                            .append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div>
        <table>
            <thead>
                <tr>
                    <td>编码</td>
                    <td>用户名称</td>
                    <td>生日</td>
                    <td>性别</td>
                    <td>住址</td>
                </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" id="btnLoader" value="查询数据">
    </div>
</body>
</html>
