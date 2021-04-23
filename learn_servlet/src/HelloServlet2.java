import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 使用http接口实现servlet程序，实际开发中也是如此

public class HelloServlet2 extends HttpServlet {
    /**
     * 在get请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("hello2的do方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello2的post方法");
        // ServletRequest作用: 获取所有请求的信息
        // 1.获取请求资源路径
        System.out.println("uri: " + req.getRequestURI());
        // 2.获取请求的统一资源定位符
        System.out.println("url: " + req.getRequestURL());
        // 3.获取客户端ip地址
        System.out.println("ip: " + req.getRemoteHost());
        // 4.获取请求头，请求头有很多key，这里获取其中一个
        System.out.println("请求头User-Agent: " + req.getHeader("User-Agent"));
        // 5.获取请求的方式：get or post
        System.out.println("请求方式: " + req.getMethod());
    }
}
