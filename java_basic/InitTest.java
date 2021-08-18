package java_basic;

public class InitTest {
    static {
        System.out.println("sta");
    }
    private int a = 3;
    {
        System.out.println(a);
        a = 1;
        System.out.println(a);
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