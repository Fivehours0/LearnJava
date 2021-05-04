package NoteCreateObj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("NoteCreateObj/NoteCreateObj.xml");
        Girl girl = context.getBean("girl", Girl.class);

        girl.test();
    }

    @org.junit.Test
    public void test1() { // 配置类的测试
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Girl girl = context.getBean("girl", Girl.class);

        girl.test();
    }
}
