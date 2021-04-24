package re_location;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Responds extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 这里只是设置了服务器的字符类型，并没有设置浏览器的字符类型，在浏览器上显示还是会乱码
//        resp.setCharacterEncoding("utf-8");
//        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        // 方法二: 他会同时设置服务器和客户端，还有响应头
        // 设置字符集的方法只有在获取流对象之前才有效
        resp.setContentType("charset=UTF-8");
        // 字符流
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("杜");


        // 以下是重定向
        System.out.println("到此一游 responds");
//        resp.setStatus(302);
//        resp.setHeader("Location", "http://localhost:8080/learn_servlet/responds2");

        // 重定向方法二
        resp.sendRedirect("http://localhost:8080/learn_servlet/responds2");
    }
}
