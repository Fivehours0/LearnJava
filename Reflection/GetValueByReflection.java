package Reflection;

import java.lang.reflect.Field;

public class GetValueByReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("duzhihui", 18); // create a object
        Class<Person> c1 = Person.class; // get object's class
        Field f = c1.getDeclaredField("name"); // 获得域，指定了name变量的域
        f.setAccessible(true); // 因为name变量是私有的，所有设置为true
        Object val = f.get(person); // 获得person对象中的name变量域的值
        System.out.println(val);
    }
}
