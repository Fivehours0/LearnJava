package LearnSpring.OuterBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void testOuterBean() {
        // 加载Spring的配置文件
        ApplicationContext context = new FileSystemXmlApplicationContext("LearnSpring/OuterBean/outerBean.xml");

        // 获取配置表里的对象
        Service service = context.getBean("service", Service.class);
        service.add();
    }
}
