package java_basic.unusual;

// 自己建的异常类
class MyException extends Exception {
    MyException() {
        super();
    }

    MyException(String mess) {
        super(mess);
    }
}

// throw 和 throws的作用
public class ThrowAndThrows {
    static void func() throws Exception {
        throw new Exception("func 有错！");
    }

    public static void main(String[] args) {
        try {
            func();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}