package java_basic.learn_lambda;

import java.util.ArrayList;

public class LambdaTest {
    public static <T> ArrayList<T> filterArray(ArrayList<T> list, FunctionInterface<T> f) {
        ArrayList<T> ans = new ArrayList<>();
        for (T t : list) {
            if (f.filter(t)) {
                ans.add(t);
            }
        }
        return ans;
    }

    // 无参数无返回值：类似 ()->System.out.println("hello")
    // 有参数无返回值：类似 (x)->System.out.println(x)，x是随便起的参数名称，函数的功能是打印x
    // 两个参数，多条语句 (x, y) -> {
    //                    System.out.println(x);
    //                    return y;
    //                 }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(10);
        list.add(8);
        // 括号内的是参数，右边是接口的功能
        System.out.println(filterArray(list, (i) -> {
            i = i * 2;
            return i > 2;
        }));
        // 只有一条语句，花括号和return都可以省略不写
        System.out.println(filterArray(list, (i) -> i > 2));
    }
}
