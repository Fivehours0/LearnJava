package KeyWord;

/**
 * final修饰的类不能被继承public final class
 * final修饰的方法不能被重写
 * final修饰的变量是常量，必须进行赋值，只能赋值一次 final String NAME = ""; final static 全局常量
 * 域也可以被声明为final。对于final域来说，构造对象之后就不允许改变它们的值了。不过，如果将一个类声明为final，只有其中的方法自动地成为final，而不包括域。
 */
final class FinalClass {
    public int a = 0;

    public static void main(String[] args) {
        FinalClass f = new FinalClass();
        f.a = 199;
    }
}

