import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetRequireParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // post请求中，当提交的内容有中文名字的时候会出现乱码问题，如下设置字符集为utf-8解决该问题
        // 要在所有getParameter调用之前调用setCharacterEncoding才会生效
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hobby = req.getParameter("hobby");
        // 如果是有多个值的时候用这个函数，例如多选
        // String[] hobbies = req.getParameterValues("hobby");
        System.out.println(username + " " + password + " " + hobby);
    }
}
