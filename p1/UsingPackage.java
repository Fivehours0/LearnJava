package p1;
//一个类可 以创建多个重载构造器
//父类的构造器不可被子类继承
class ConstructFunction{
    private int age;
    private String name = new String("duzhihui");
    ConstructFunction(int age, String name){
        this.age = age;
        this.name = name;
    }
    void showAgeName(){
        System.out.println(this.age);
        System.out.println(this.name);
    }

    void showInfo(){
        this.showAgeName();// 这里添加this，增加了程序的可读性，说明该函数是类方法
    }
}

public class UsingPackage{
    public int age;
    public String name; 
    public static void main(String[] args) {
        ConstructFunction construct = new ConstructFunction(18, "duzhihui");
        construct.showAgeName();
    }
}