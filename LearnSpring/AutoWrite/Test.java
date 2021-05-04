package AutoWrite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext context = new FileSystemXmlApplicationContext("LearnSpring/AutoWrite/AutoWrite.xml");

        Stu stu = context.getBean("stu", Stu.class);

        System.out.println(stu.toString());
    }
}
