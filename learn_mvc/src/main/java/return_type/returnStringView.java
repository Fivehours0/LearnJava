package return_type;

import get_require_param.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class returnStringView {
    /**
     * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     */
    @RequestMapping(value = "returnString-view.do")
    public String doReturnView(HttpServletRequest request, String msg, Integer fun) {
        // 可以自己手动添加数据
        request.setAttribute("msg", msg);
        request.setAttribute("fun", fun);
        // 框架对视图执行forward转发操作, 会转到show.jsp页面下
        return "show";
    }

    /**
     * 处理器方法返回一个Student，通过框架转为json，响应ajax请求
     * @ResponseBody:
     *    作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器。
     *    位置：方法的定义上面。 和其它注解没有顺序的关系。
     * 返回对象框架的处理流程：
     *  1. 框架会把返回Student类型，调用框架的中ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *     检查那个HttpMessageConverter接口的实现类能处理Student类型的数据--MappingJackson2HttpMessageConverter
     *
     *  2.框架会调用实现类的write（）， MappingJackson2HttpMessageConverter的write()方法
     *    把李四同学的student对象转为json， 调用Jackson的ObjectMapper实现转为json
     *    contentType: application/json;charset=utf-8
     *
     *  3.框架会调用@ResponseBody把2的结果数据输出到浏览器， ajax请求处理完成
     */

    @ResponseBody
    @RequestMapping(value = "returnStudentJson.do")
    public Student doStudentJsonObject(String msg, Integer fun){

        Student student = new Student();
        student.setMsg("lisi");
        student.setFun(10);

        //会被框架转为json
        return student;
    }

    @ResponseBody
    @RequestMapping(value = "returnStudentJsonArray.do")
    public List<Student> doStudentJsonObjectArray(String msg, Integer fun){
        List<Student> list = new ArrayList<Student>();
        Student student = new Student();
        student.setMsg("lisi");
        student.setFun(10);
        list.add(student);

        Student student1 = new Student();
        student1.setMsg("zhangsan");
        student1.setFun(15);
        list.add(student1);

        //会被框架转为json
        return list;
    }


    /**
     * 处理器方法返回的是String ， String表示数据的，不是视图。
     * 区分返回值String是数据，还是视图，看有没有@ResponseBody注解
     * 如果有@ResponseBody注解，返回String就是数据，反之就是视图
     *
     * 默认使用“text/plain;charset=ISO-8859-1”作为contentType,导致中文有乱码，
     * 解决方案：给RequestMapping增加一个属性 produces, 使用这个属性指定新的contentType.
     * 返回对象框架的处理流程：
     *  1. 框架会把返回String类型，调用框架的中ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *     检查那个HttpMessageConverter接口的实现类能处理String类型的数据--StringHttpMessageConverter
     *
     *  2.框架会调用实现类的write（）， StringHttpMessageConverter的write()方法
     *    把字符按照指定的编码处理 text/plain;charset=ISO-8859-1
     *
     *  3.框架会调用@ResponseBody把2的结果数据输出到浏览器， ajax请求处理完成
     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "Hello SpringMVC 返回对象，表示数据";
    }
}
