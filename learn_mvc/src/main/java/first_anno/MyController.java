package first_anno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * @Controller：创建处理器对象，对象放在springmvc容器中
 *
 * 能处理请求的都是控制器（处理器）：MyController能处理请求，
 *                               叫做后端控制器（back controller）
 */

@Controller
//@RequestMapping("/user")  //配置了这个之后，url中的地址变成/user/some.do  相当于所有请求的公共部分，叫做模块名称

public class MyController {
    /*
     * 处理用户提交的请求，springmvc中是使用方法来处理的。
     * 方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     * */

    /*
     * 准备使用doSome方法处理some.do请求。
     * @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起。
     *                  一个请求指定一个方法处理。
     *             属性：1. value是一个String类型，表示请求的uri地址（这里是：some.do）
     *                     value值是唯一的，不能重复，在使用时，推荐以 / 开头
     *             位置：1. 方法上面(常用)
     *                  2. 类上面
     *             说明：使用@RequestMapping修饰的方法叫做处理器方法或者控制器方法
     *                   可以处理请求，类似servlet中的doGet,doPost
     * */


    /*
     * 返回值 ModelAndView 表示本次请求的处理结果
     *   model:数据，请求处理完后，要显示给用户的数据
     *   view：视图，比如jsp等
     *
     * value = "/some.do"
     * value也可以是数组   value = {"/some.do", "/first.do"}
     * */

    @RequestMapping(value = {"/some.do", "/first.do"})
    public ModelAndView doSome() {
        //处理some.do请求，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求的最后把数据放入到request作用域
        //request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
        //request.setAttribute("msg","欢迎使用....");
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的是doSome方法");

        //指定视图，指定视图的完整路径
        //框架对视图执行的forward操作，request.getRequestDispather("/show.jsp").forward(...)
        //show.jsp页面会将request域中的数据进行显示
        //mv.setViewName("/show.jsp");

        //当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
        //框架会使用视图解析器的 前缀 + 逻辑名称 +后缀 组成完整路径
        mv.setViewName("show");

        return mv;
    }

    /*
     * 可以写多个方法 */

    /*
     * @RequestMapping(value = "",method = )
     * 	属性：method 表示请求的方式，它的值是RequestMethod类枚举值
     *
     * 	get请求方式， method = RequestMethod.GET
     * 	post请求方式，method = RequestMethod.POST
     *  如果没有指定，则post，get方法都可以访问，指定了post，get请求会报错
     * */

    @RequestMapping(value = {"/other.do", "/second.do"}, method = RequestMethod.POST)
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("other");

        return mv;
    }
}
