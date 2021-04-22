import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1 构造器");
    }

    // 这里自己申明了一个servletConfig对象，因为这里不是继承HttpServlet
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init方法");

        this.servletConfig = servletConfig;
        //ServletConfig作用：是servlet程序的配置信息类
        //1.可以获得servlet程序的别名
        System.out.println("servlet程序的别名: " + servletConfig.getServletName());
        //2.获取初始化参数init-param，init-param在web.xml中配置
        System.out.println("获取初始化参数: " + servletConfig.getInitParameter("username"));
        //3.获取ServletContext对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问了");
        System.out.println("3 service方法");
        // request 有get和post两种请求。需要将servletRequest强制类型转换为他的子类，因为他的子类有geMethod方法，可以知道请求的类型
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    /**
     * 处理do请求
     */
    public void doGet() {
        System.out.println("GET请求");
        //ServletContext类的四个作用:
        //1.获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println("context-param参数password的值为: " + servletContext.getInitParameter("password"));
        //2.获取当前工程路径, 格式:/工程路径
        System.out.println("当前的工程路径: " + servletContext.getContextPath());
        //3.获取工程部署后在服务器硬盘上的绝对路径
        // 打印的是这个信息D:\LearnJava\out\artifacts\web_server_war_exploded\。
        // / 斜杆在服务器解析的时候表示http://ip:port/工程路径，这里的/指的是得到这个斜杠表示的工程在硬盘中的绝对路径，也就是上面那串
        System.out.println("硬盘上的绝对路径: " + servletContext.getRealPath("/"));
        //4.像map一样存取数据
        servletContext.setAttribute("key1", 10);
        System.out.println("context存的数据: " + servletContext.getAttribute("key1"));
    }

    /**
     * 处理post请求
     */
    public void doPost() {
        System.out.println("POST请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy方法");
    }
}
