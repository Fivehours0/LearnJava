package LearnJVM;

// 观察字节码
public class ByteCodeTest {
    static class Father {
        public static int A = 1;
        static {
            A = 2;
        }
 
        private int test = 1;
    }

    static class Son extends Father {
        public static int B = A;
    }
    // init是instance实例构造器，对非静态变量解析初始化，而clinit是class类构造器对静态变量，静态代码块进行初始化。
    static {
        number = 2;
    }
    // 在连接的准备阶段为number分配了内存空间，并初始化了值0，随后在初始化阶段，静态代码块和赋值按顺序进行
    // linking之prepare: number -> 0 ---> initial 2 -> 10(覆盖2)
    private static int number = 10;
    private int a = 8;
    private static Father f = new Father();
    public static void main(String[] args) {
        Father father = new Father();
        int aa = 0;
        System.out.println(number);
        System.out.println(Son.B);
    }
}
