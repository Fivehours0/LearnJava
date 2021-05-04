package InnerBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void testInnerBean() {
        ApplicationContext context = new FileSystemXmlApplicationContext("InnerBean/InnerBean.xml");

        Employee employee = context.getBean("employee", Employee.class);

        System.out.println(employee.toString());
    }
}
