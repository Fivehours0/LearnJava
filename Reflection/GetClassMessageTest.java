package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetClassMessageTest {
    public static void main(String[] args) {
        Person p = new Person();
        Class<?> c = p.getClass();
        String name = c.getName();
        Class<?> superClass = c.getSuperclass(); // 获得类的父类信息
        String modifier = Modifier.toString(c.getModifiers()); // 获取类的修饰符信息，例如public private等
        if (modifier.length() > 0) System.out.print(modifier + " ");
        System.out.println("class " + name);
        if (superClass != null && superClass != Object.class) System.out.println(" extends " + superClass.getName());

//        printConstructors(p.getClass()); // 获取类的所有构造函数信息
//        printMethods(p.getClass()); // 获取类的所有方法信息
        printFields(p.getClass()); // 获取类的所有域信息
    }

    /**
     * print all constructors of a class
     * @param c1 a class
     */
    public static void printConstructors (Class<?> c1) {
        Constructor<?>[] constructors = c1.getDeclaredConstructors();

        for (Constructor<?> c: constructors) {
            String name = c.getName();
            System.out.print("    ");
            String modifier = Modifier.toString(c.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.println(name + "(");

            // print parameter types
            Class<?>[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.println(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all methods of a class
     * @param c1 a class
     */
    public static void printMethods (Class<?> c1) {
        Method[] methods = c1.getDeclaredMethods();

        for (Method m: methods) {
            Class<?> retType = m.getReturnType();
            String name = m.getName();
            System.out.print("    ");
            String modifier = Modifier.toString(m.getModifiers());
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.println(retType.getName() + " " + name + "(");

            // print parameter types
            Class<?>[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.println(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all fields of a class
     * @param c1 a class
     */
    public static void printFields (Class<?> c1) {
        Field[] fields = c1.getDeclaredFields();

        for (Field f: fields) {
            String name = f.getName();
            Class<?> type = f.getType();
            String modifier = Modifier.toString(f.getModifiers());
            System.out.print("    ");
            if (modifier.length() > 0) System.out.print(modifier + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
