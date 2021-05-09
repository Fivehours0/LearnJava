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
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      $(function () {
        $("button").click(function () {
          // alert("button click");
          $.ajax({
            // url:"returnStudentJson.do",
            // url:"returnStudentJsonArray.do",
            url: "returnStringData.do",
            data:{
              msg:"zhangsan",
              fun:20
            },
            type:"post",
            // 返回的数据类型是json类型
            // dataType:"json",
            // 返回的数据是文本格式
            dataType: "text",
            success:function(resp) {
              //resq从服务器端返回的是json格式的字符串{"msg:" "zhangsan", "fun": 20}
              //jquery会把字符串转为json对象，赋值给resp形参
              // alert(resp.msg+"   "+resp.fun);

              // 返回的是Student数组
              //[{"name":"wangwu","age":22},{"name":"tianmao","age":10}]
              // $.each(resp,function (i,n) {
              //   alert(n.msg+"  "+n.fun);
              // })
              alert(resp);
            }
          })
        })
      })
    </script>
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

    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString-view.do" method="post">
      姓名: <input type="text" name="msg"> <br/>
      年龄: <input type="text" name="fun"> <br/>
      <input type="submit" value="提交参数">
    </form>

    <br/>
    <button id="btn">发起一个ajax请求</button>
  </body>
</html>
