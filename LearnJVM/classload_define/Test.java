package LearnJVM.classload_define;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 破坏双亲委派，并用不同的类加载器加载同包名同类名的包
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
    {
        // 自定义类加载器的加载路径
        ClassLoadDefine myClassLoader = new ClassLoadDefine("D:\\lib");
        ClassLoadDefine1 myClassLoader1 = new ClassLoadDefine1("D:\\lib1");


        // 包名+类名
        Class c = myClassLoader.loadClass("test.Test");
        if (c != null)
        {
            Object obj = c.newInstance();
            Method method = c.getMethod("test", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }

        // 包名+类名
        Class c1 = myClassLoader1.loadClass("test.Test");
        if (c1 != null)
        {
            Object obj = c1.newInstance();
            Method method = c1.getMethod("test", null);
            method.invoke(obj, null);
            System.out.println(c1.getClassLoader().toString());
        }
    }
}

