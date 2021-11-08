package java_basic;

public class InitTest {
    static {
        System.out.println("sta");
    }
    // 初始化块和域初始化按照顺序进行，初始化块可以在域定义之前进行，但是不能使用sout 去显示a
    {
//        System.out.println(a);
        a = 1;
//        System.out.println(a);
    }
    private int a = initA();

    // 还能用如下方式初始化
    public int initA() {
        System.out.println(this.a);
        return 12;
    }

    public InitTest() {
        System.out.println(a);
        a = 2;
        System.out.println(a);
    }

    public static void main(String[] args) {
        InitTest initTest = new InitTest();
    }
}

abstract class AbstractTest {
    private int i = 0;
    private void show() {
        System.out.println(i);
    }
    public abstract int add();
}