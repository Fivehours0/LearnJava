package p2;

import java.util.Scanner;
import p1.UsingPackage;
// 函数重载参数个数不一样或者是参数类型不一样, 返回类型不同但是参数一致是不被接受的

class A {
       public static void main(String[] args){
              double value_max = Double.MAX_VALUE;
              double value_min = Double.MIN_VALUE;
              System.out.println(value_max);
              System.out.println(value_min);
              System.out.println("this is A");
       }
}
/**
 * 数组的使用
 */
class Array_using{
       public static void main(String[] args) {
              int a[] = new int [6]; //动态初始化
              int[] s = new int [6]; // 写法不同
              int static_init[] = new int [] {1, 2, 3, 4}; //静态初始化
              String str[] = new String[] {"duz", "hui"}; //创建string类数组
              System.out.println(str.length); //str返回长度
              System.out.println(str[1]);

              //二维数组
              int arr_two_dimen[][] = new int [][] { //静态初始化
                     {1, 2, 3},
                     {2, 3, 4}};
              int arr_two_dimen_static [][] = new int [2][3]; //动态初始化

              int arr1[] = new int [7];
              int arr2[] = arr1;  //arr2的地址也是arr1的地址,赋值为浅拷贝
              System.out.println(arr1+"  "+arr2);
       }
}

/**
 * 类的使用
 */
class ClassUsing{
       public int age = 18; //默认初始化为0, 实例化对象后，可以直接访问public变量， 不能直接访问private变量
       private String name; //默认初始化为null
       // 以上两个为实例化变量, 是指在类实例化为对象之后才能使用
       // 将变量设置为private的意义（封装和隐藏）：
       //     如果调用者赋值给age=-100程序可以运行，但不符合逻辑，所以需要将age设置为private，在类函数中进行判断和赋值
       static String s_name = "duzhihui"; //类变量,不用实例化即可调用

       public static void main(String[] args) {
              // main方法中只能直接调用static方法
              // static方法不能调用类中定义的方法
              ClassUsing class1 = new ClassUsing();
              class1.showArea();

              // 如果只使用一次,可以整一个匿名类对象
              int area = new ClassUsing().getArea(2, 3);
              System.out.println(area); 
       }

       /**
        * 传入数量可变的形参的两种方式，还有一种是Java特有的String... args，使用方式和下面的一样
        * 可变的形参要放在最后
        * @param args
        */
       public void showInfo(String[] args){
              for(int i=0; i<args.length; i++)
                     System.out.println(args[i]);
       }

       public void showArea(){
              System.out.println(getArea(2, 3));// 处于同一个类的方法可以直接调用,但是调用的方法需要在位置下方定义
       }

       public int getArea(int x, int y){
              return x * y;
       }
}

class SonClass extends ClassUsing{ // 继承，SonClass是子类，ClassUsing是父类
       public static void main(String[] args){
              SonClass sonClass = new SonClass();
              sonClass.showFatherAge();
       }
       public void showFatherAge(){
              System.out.println(age);
       }       
}

public class Hello {
       public static void main(String[] args) {
              System.out.println("我的第一个Java程序：Hello World。");
              Scanner scanner = new Scanner(System.in);
              /*
              要求用户输入一个值
              int n = scanner.nextInt();
              System.out.println(n);
              scanner.close();*/
              System.out.println(ClassUsing.s_name);
       }
}
