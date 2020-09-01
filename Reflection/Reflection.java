package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 通过Class类来获取某一个类的信息
 * java能够反射的前提：已经加载过这个类
 * 可以通过类名称来寻找这个类的所有相关信息(反射机制)
 */

class Person {
    private String name;
    int age;
    public  Person () {

    }

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person (String name) {
        this.name = name;
    }
}

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = new Person();
        // method 1: 类名.class
        Class<?> clazz1 = Person.class;

        // method 2: 实例化对象.getClass()
        Class<?> clazz2 = person.getClass();

        // 常用方法, method 3: Class类的类方法forName("包名.类名")
        try {
            // 有在className是类名或接口名时才能够执行。否则， forName方法将抛出一个checked exception（已检查异常）。
            String className = "Reflection.Person";
            Class<?> clazz3 = Class.forName(className);
            // 获取Person类继承的接口
            Class<?>[] personInterface = clazz3.getInterfaces();
            for(Class<?> c: personInterface)
                System.out.println(c.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}