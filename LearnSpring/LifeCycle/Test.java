package LifeCycle;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("LifeCycle/bean.xml");
        Order order = context.getBean("order", Order.class);

        context.close();
    }
}
