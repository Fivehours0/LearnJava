package LearnSpring.OuterProperty;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("LearnSpring/OuterProperty/OuterProperty.xml");
        Book book = context.getBean("book", Book.class);

        System.out.println(book.toString());
    }
}