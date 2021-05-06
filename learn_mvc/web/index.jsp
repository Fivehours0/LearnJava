<%--
  Created by IntelliJ IDEA.
  User: pkl
  Date: 2021/4/28
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <p>这是一个springmvc的项目</p>
    <p><a href="some.do"> 发起一个some.do的请求</a> </p>
    <form action="other.do" method="post">
      <input type="submit" value="post请求other.do">
    </form>
    <p><a href="other.do"> 发起一个other.do的请求</a> </p>

    <!--使用request接收-->
    <form action="get_param.do" method="post">
      姓名: <input type="text" name="msg"> <br/>
      年龄: <input type="text" name="fun"> <br/>
      <input type="submit" value="提交参数">
    </form>

    <!--逐个接收参数-->
    <form action="get_param2.do" method="post">
      姓名: <input type="text" name="msg"> <br/>
      年龄: <input type="text" name="fun"> <br/>
      <input type="submit" value="提交参数">
    </form>

    <!--使用java对象接收参数-->
    <form action="get_param3.do" method="post">
      姓名: <input type="text" name="msg"> <br/>
      年龄: <input type="text" name="fun"> <br/>
      <input type="submit" value="提交参数">
    </form>
  </body>
</html>
