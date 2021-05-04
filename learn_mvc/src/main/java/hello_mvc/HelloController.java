package hello_mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // Model And View 模型和视图
        ModelAndView mv = new ModelAndView();

        // 封装对象，放在ModelAndView中
        mv.addObject("msg", "HelloSpringMVC");
        // 封装要跳转的视图，放在ModelAndView中
        //: /WEB_INF/jsp/hello.jsp    这里利用了web-inf中的前缀后缀，自动拼接出这样的一个地址
        mv.setViewName("hello");
        return mv;
    }
}
