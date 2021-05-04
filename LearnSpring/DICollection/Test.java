package DICollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext context = new FileSystemXmlApplicationContext("LearnSpring/DICollection/CollectionBean.xml");

        Stu stu = context.getBean("stu", Stu.class);

        System.out.println(stu.toString());
    }

    @org.junit.Test
    public void publicBean() {
        ApplicationContext context = new FileSystemXmlApplicationContext("LearnSpring/DICollection/publicBean.xml");

        Stu stu = context.getBean("stu", Stu.class);

        System.out.println(Arrays.toString(stu.getCourse()));

    }
}
