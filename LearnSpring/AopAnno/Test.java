package AopAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext context = new FileSystemXmlApplicationContext("AopAnno/AopAnno.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
