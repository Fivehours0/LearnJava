package Reflection;

import java.util.Arrays;

/**
 * 通过Class类来获取某一个类的信息
 * java能够反射的前提：已经加载过这个类
 * 可以通过类名称来寻找这个类的所有相关信息(反射机制)
 */

class Person {
    String name;
    int age;
}

public class Reflection {
    public static void main(String[] args) {
        Person person = new Person();
        // method 1: 类名.class
        Class<?> clazz1 = Person.class;

        // method 2: 实例化对象.getClass()
        Class<?> clazz2 = person.getClass();

        // 常用方法, method 3: Class类的类方法forName("包名.类名")
        try {
            Class<?> clazz3 = Class.forName("Reflection.Person");
            // 获取Person类继承的接口
            Class<?>[] personInterface = clazz3.getInterfaces();
            for(Class<?> c: personInterface)
                System.out.println(c.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}