package AOPXml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext context = new FileSystemXmlApplicationContext("AOPXml/AopXml.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
