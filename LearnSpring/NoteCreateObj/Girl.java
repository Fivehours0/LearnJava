package LearnSpring.NoteCreateObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 在注解里面value属性值可以省略不写
// 默认值是类名称，首字母的小写。比如这个Girl类，value的默认值即为girl
// @Service @Controller @Repository都可以用，注意他们的异同
@Component(value = "girl") // 与<bean id="" class""/>是一致的
@Scope(value = "prototype") // 多例模式
public class Girl {

    @Value(value = "dd")
    private String name;

    // 类似于外部bean注入 不需要添加set方法
    //@Resource: 可以根据名称注入，也可以根据类型注入
    @Autowired // 根据类型进行注入
    @Qualifier(value = "service") // 根据名称进行注入，需要与Autowired一起使用
    private Service service;

    public void test() {
        System.out.println("girl test ..... ");
        service.add();
        System.out.println("name value: " + this.name);
    }
}
