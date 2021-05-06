package get_require_param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class GetParam {

    @RequestMapping(value = "/get_param.do")
    public ModelAndView doGetParam(ServletRequest servletRequest, ServletResponse servletResponse,
                                   HttpSession httpSession) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发" + servletRequest.getParameter("msg"));
        mv.addObject("fun","执行的是doGetParam方法" + servletRequest.getParameter("fun"));
        mv.setViewName("show");
        return mv;
    }

    /*
     * 逐个接收请求参数：
     *   要求：处理器（控制器）方法的形参名和请求中的参数必须一致(也就是jsp中form中input的参数的名称)
     *         同名的请求参数赋值给同名的参数
     *
     *
     * 请求参数名和处理器方法的形参名不一样
     * @RequestParam：定义在处理器方法的形参前面
     *   属性：1. value，请求参数名，可省略
     *        2. required，是一个Boolean类型，默认为true，表示必须包含参数
     * doGetParam(@RequestParam("rmsg", required=false) String msg, @RequestParam("rfun")int fun)
     *
     * 框架接收请求参数的过程：
     * 1 使用request对象接收请求参数
     *   String strName = request.getParameter("name");
     *   String strAge = request.getParameter("age");
     * 2 springmvc框架通过dispatcherServlet 调用GetParam的doGetParam方法
     *   调用方法时，按名称对应，把接收的参数赋值给形参 doGetParam(strName,Integer.valueOf(strAge))
     *   框架会提供类型转换的功能，把String转换为 int ，long ，float ，double等
     *   存在问题：
     *      strAge为空，或者为浮点数时，会出现无法转化的情况，将会出错
     *      Integer fun 包装类可以使得为空时不出错
     * */

    @RequestMapping(value = "/get_param2.do")
    public ModelAndView doGetParam(String msg, int fun) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",msg);
        mv.addObject("fun",fun);
        mv.setViewName("show");
        return mv;
    }

    /*
     * 处理器方法的形参是java对象，这个对象的属性名要求和请求中参数名一致
     * 框架会创建形参的java对象，给属性赋值。请求中的参数是msg，框架会调用setMsg()完成赋值
     * 实际应用最多
     * */

    @RequestMapping(value = "/get_param3.do")
    public ModelAndView doGetParam(Student student) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg",student.getMsg());
        mv.addObject("fun",student.getFun());
        // 也可以把对象加进去
        mv.addObject(student);
        mv.setViewName("show");
        return mv;
    }
}
