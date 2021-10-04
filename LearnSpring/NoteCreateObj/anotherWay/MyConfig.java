package NoteCreateObj.anotherWay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是一个组件（spring容器中的一个bean），在容器里面可以找到myConfig
 * 3.proxyBeanMethods: 是spring5.2的新特性，代理bean的方法，默认为true
 *      Full模式：proxyBeanMethods = true, 会对Myconfig进行代理，每次调用@Bean方法都会去容器里面检查是否存在该实例
 *      Lite模式：proxyBeanMethods = false, 每一次调用userAnotherWay01，都会生成一个新的对象
 *
 * Lite优缺点
 * 优点:
 * 运行时不再需要给对应类生成CGLIB子类，提高了运行性能，降低了启动时间
 * 可以该配置类当作一个普通类使用喽：也就是说@Bean方法 可以是private、可以是final
 * 缺点：
 * 不能声明@Bean之间的依赖，也就是说不能通过方法调用来依赖其它Bean
 * （其实这个缺点还好，很容易用其它方式“弥补”，比如：把依赖Bean放进方法入参里即可）
 *
 *
 * Lite小总结
 * 该模式下，配置类就是一普通类,本身不会被CGLIB增强，放进IoC容器内的就是本尊
 * 该模式下，配置类内部不能通过方法调用来处理依赖，否则每次生成的都是一个新实例而并非IoC容器内的单例
 *
 *
 * Full优缺点
 * 优点：
 * 可以支持通过常规Java调用相同类的@Bean方法而保证是容器内的Bean，
 *
 * 缺点：
 * 运行时会给该类生成一个CGLIB子类放进容器，有一定的时间开销（这个开销在Spring Boot这种拥有大量配置类的情况下是不容忽视的，
 * 这也是为何Spring 5.2新增了proxyBeanMethods属性的最直接原因）
 *
 * Full小总结
 * 该模式下，配置类会被CGLIB增强(生成代理对象)，放进IoC容器内的是代理
 * 该模式下，配置类内部可以通过方法调用来处理依赖，并且能够保证是同一个实例，都指向IoC内的那个单例
 */

@Configuration(proxyBeanMethods = true)
public class MyConfig {
    @Bean
    public UserAnotherWay userAnotherWay01() {
        return new UserAnotherWay("zhangsan", petAnotherWay01());
    }

    // 默认情况下，bean的名字为为方法名petAnotherWay01,可以通过在bean中设置自己想要的名字
    @Bean("tom")
    public PetAnotherWay petAnotherWay01() {
        return new PetAnotherWay("tomcat", 15);
    }
}
