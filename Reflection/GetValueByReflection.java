package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetValueByReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person("duzhihui", 18); // create a object
        Class<Person> c1 = Person.class; // get object's class
        Field f = c1.getDeclaredField("name"); // 获得域，指定了name变量的域
        f.setAccessible(true); // 因为name变量是私有的，所有设置为true
        Object val = f.get(person); // 获得person对象中的name变量域的值
        System.out.println(val);

        /*
         * 这种程序设计风格并不太简便，出错的可能性也比较大。如果在调用方法
         * 的时候提供了一个错误的参数，那么invoke方法将会抛出一个异常。
         * 另外， invoke的参数和返回值必须是Object类型的。这就意味着必须进行多次的类型转换。
         * 这样做将会使编译器错过检查代码的机会。因此，等到测试阶段才会发现这些错误，找到并改
         * 正它们将会更加困难。不仅如此，使用反射获得方法指针的代码要比仅仅直接调用方法明显慢
         * 一些。
         * 有鉴于此，建议仅在必要的时候才使用Method对象，而最好使用接口和内部类（第6章中
         * 介绍）。特别要重申：建议Java开发者不要使用Method对象的回调功能。使用接口进行回调
         * 会使得代码的执行速度更快，更易于维护。
         */
        Method m = c1.getDeclaredMethod("resetParam", String.class, int.class); // 方法指针
        m.invoke(person, "duzhihui", 18);
    }
}
