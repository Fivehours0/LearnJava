package demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpring5 {
    @Test
    public void testAdd() {
        // 加载Spring的配置文件
        ApplicationContext context = new FileSystemXmlApplicationContext("demo/bean1.xml");

        // 获取配置里的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
        System.out.println(user.getName()); // 在xml文件中进行依赖注入DI
        System.out.println(user.getAddress());

        // 用有参构造方式注入属性
        User userConstructor = context.getBean("userConstructor", User.class);
        System.out.println("使用有参构造的方式注入属性:" + userConstructor.getName()); // 在xml文件中进行依赖注入DI
    }
}
