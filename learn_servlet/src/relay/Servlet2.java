package relay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.查看办事的材料,这里的req是从servlet1中传过来的，所以1，2共享req域中的数据
        String username = req.getParameter("username");
        System.out.println("柜台2的材料: " + username);
        //2.查看是否有盖章
        Object key1 = req.getAttribute("key1");
        System.out.println("柜台1的章: " + key1);

        //3.处理自己的业务
        System.out.println("servlet2处理自己的业务");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
