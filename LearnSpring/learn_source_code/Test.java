package learn_source_code;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("learn_source_code/bean.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println(user.getName());
        System.out.println(user.getApplicationContext());
    }
}
