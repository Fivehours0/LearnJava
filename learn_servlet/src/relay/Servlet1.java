package relay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数（也就是办事的材料）
        String username = req.getParameter("username");
        System.out.println("柜台1的材料: " + username);
        //2.给材料盖一个章，让servlet2看到.要让servlet2看到，就得通过域了
        req.setAttribute("key1", "柜台1的章");
        //3.问路，servlet2怎么走。请求转发必须以斜杠打头，斜杠表示http://ip:port/工程目/，映射到idea代码的web目录
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        //4.走向柜台2
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
