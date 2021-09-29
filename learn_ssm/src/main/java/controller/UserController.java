package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.UserServiceSSM;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceSSM userService;

    @RequestMapping(value = "/addUser.do")
    public ModelAndView addUser(User user) {
        String tips = "注册成功";
        int num = userService.insertUser(user);

        ModelAndView mv = new ModelAndView();
        if (num > 0) {
            tips = "用户【" + user.getUsername() + "】注册成功";
        }
        // 添加数据
        mv.addObject("tips", tips);
        mv.setViewName("result");
        return mv;
    }

    // 处理查询，响应ajax
    @RequestMapping(value = "/queryUser.do")
    @ResponseBody
    public List<User> queryUsers() {
        return userService.selectUsers();
    }
}
