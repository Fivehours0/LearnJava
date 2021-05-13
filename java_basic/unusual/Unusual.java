package java_basic.unusual;


/**
 * java处理异常的机制有捕获和抛出
 */
public class Unusual {
    int i;

    public void catchError() {
        try {
            int a = 1 / 0;
        } catch (Exception e) {// 当不知道捕获的是什么类型的异常时，可以直接使用所有异常的父类Exception
            // e.printStackTrace(); // 输出捕捉到的错误信息
            // System.out.println(e.getMessage()); // 另一种: 输出捕捉到的错误信息
        } // 一个try可以有多个catch，以捕捉不同的异常，进行不同的处理
        finally {
            // 无条件执行的语句
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        Unusual unusual = new Unusual();
        unusual.catchError();
    }
}

class ThrowFunc {
    int i;

    public void test() throws Exception {
        System.out.println("空指针异常");
        System.out.println(this.i); // 将会抛出空指针异常
    }

    public void test1(int number) throws Exception {
        if (number < 50 && number > 10) {
            System.out.println(number);
        } else {
            throw new Exception("number error"); // 可以主动抛出错误
        }
    }

    public static void main(String[] args) {
        ThrowFunc throwFunc = null;
        ThrowFunc throwFunc1 = new ThrowFunc();
        // try { // 空指针异常
        //     throwFunc.test();
        // } catch (Exception e) {
        //     e.getStackTrace();
        //     System.out.println(e.getMessage());
        // }

        try { // 自定义异常
            throwFunc1.test1(-100);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

/**
 * 自定义类, 一般不会用
 */
// class MyException extends Exception{
//     public MyException(String msg){
//         super(msg);
//     }
// }


// 子类重写父类的方法时，子类不能抛出比父类方法范围更大的异常
