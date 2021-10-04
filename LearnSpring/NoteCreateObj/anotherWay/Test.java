package NoteCreateObj.anotherWay;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("NoteCreateObj/NoteCreateObj.xml");
        // 获取spring当中所有组件的名字
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String name: beanDefinitionNames) {
            // 打印出来之后是有userAnotherWay01，和tom的
            System.out.println(name);
        }
        UserAnotherWay userAnotherWay01 = (UserAnotherWay) context.getBean("userAnotherWay01");
        PetAnotherWay tom = (PetAnotherWay) context.getBean("tom");
        // 返回的是true
        System.out.println(userAnotherWay01.getPet() == tom);

        MyConfig myConfig = (MyConfig) context.getBean("myConfig");

        /*
         * @Configuration(proxyBeanMethods = true)中proxyBeanMethods属性配置为true时，返回为true
         * proxyBeanMethods属性配置为true代表myConfig是被spring增强过的，
         * NoteCreateObj.anotherWay.MyConfig$$EnhancerBySpringCGLIB$$81f674e4@28261e8e
         * 调用userAnotherWay01方法，总会会去容器中检查是否有这个类，有就直接返回该引用，保持组件单实例
         */
        System.out.println(myConfig);
        System.out.println(myConfig.userAnotherWay01() == myConfig.userAnotherWay01());
        System.out.println(-5 % 3);
    }
}
