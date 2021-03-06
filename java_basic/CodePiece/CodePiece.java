package java_basic.CodePiece;
/**
 * 代码块执行顺序：
 * 静态代码块 -> 非静态代码块 -> 构造函数
 * 非静态代码块每次new对象都有重新执行，静态代码块只执行一次
 */
public class CodePiece{
    public String name;
    static int height;
    CodePiece(){ // 构造函数
        this.name = "ddd";
        System.out.println("执行的是构造函数");
    }

    {
        System.out.println("执行的是非静态代码块");
    }

    static{
        // 只能使用静态变量和方法, 在这里也可以对静态类进行初始化
        height = 180;
        showHeight(); // 静态方法
        System.out.println("执行的是静态代码块");
    }

    static public void showHeight(){
        System.out.println(height);
    }
    
    public void overRide(){

    }
}

class InnerClass{

    public static void main(String[] args) {
        // 匿名内部类，是codePiece的一个子类
        CodePiece codepiece = new CodePiece() {
            {// 由于匿名内部类没有类名，不能使用构造函数，可以使用代码块对父类属性进行初始化
                super.name = "ddd";
            }
            @Override
            public void overRide() {

            }
        };
    }
}