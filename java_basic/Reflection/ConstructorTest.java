package java_basic.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Person person = new Person();
        // 使用反射机制构造一个新的类的方法
        // 1.Class类的getConstructor()方法,无论是否设置setAccessible(),都不可获取到类的私有构造器.
        // 2.Class类的getDeclaredConstructor()方法,可获取到类的私有构造器(包括带有其他修饰符的构造器），但在使用时private的构造器时，必须设置setAccessible()为true,才可以获取并操作该Constructor对象。
        Constructor<Person> con = Person.class.getDeclaredConstructor(String.class);
        con.setAccessible(true); // 设置为true后可以获得私有构造器
        Person t = con.newInstance("name");
        System.out.println(t.age);

        Person t1 = (Person) Class.forName(person.getClass().getName()).getDeclaredConstructor(String.class, int.class).newInstance("name", 2);
        System.out.println(t1.age);

        Person t2 = person.getClass().getConstructor(String.class, int.class).newInstance("name", 2);
        System.out.println(t2.age);
    }
}

