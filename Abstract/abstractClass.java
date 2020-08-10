package Abstract;
/**
 * 抽象类
 * 一个抽象类中可以定义构造器，但是抽象类不可被实例化，可以在子类中使用方法进行初始化
 */
public abstract class abstractClass{
    int weight;
    int length;
    String name;
    public abstract void test(); // 只要有一个抽象类方法，类就必须是一个抽象类
    public abstract void move(); // 不同种动物的运动方式，进行抽象，在子类中对其进行重写具体化

    // 如果定义了构造器，则每个子类都需要进行构造，有点麻烦
    // abstractClass(int weight, int length, String name){
    //     this.weight = weight;
    //     this.length = length;
    //     this.name = name;
    // }

    public static void main(String[] args) {
        Dog dog = new Dog(18, 18, "dog");
        dog.move();
        dog.getInfo();
    }
}

class Dog extends abstractClass{
    Dog(int weight, int length, String name){
        super.weight = weight;
        super.length = length;
        super.name = name;
    }

    public void getInfo(){
        System.out.println("weight: "+super.weight);
    }

    @Override
    public void test() {
        System.out.println("just for fun");        
    }

    @Override
    public void move() {
        System.out.println("狗的行动方式是跑步");
    }
    
}

// 抽象类可以继承抽象类
abstract class Bird extends abstractClass{
    public void move(){

    }

    public abstract void test();
}

/**
 * 接口，用来抽象方法的
 * 子类继承父类，只能继承一个父类
 * 类可以实现多个接口，多个接口用，分隔
 * 
 * 如果父类经常发生变化，基于这个父类的子类，子类的子类，这些子类都有收到影响
 * 有时我们又确实需要给父类增加一些方法，那么就不能直接在父类上下手，只能新建
 * 一个接口，在接口上拓展方法，其他需要的子类自行去实现接口
 */
interface Interface1{
    int ID = 1; // 等同于public static final int ID = 1;
    void test(); // 等同于public abstract void test();
}

interface Interface2{
    String name = "duzhihui";
    void test1();
}

class TestInterface implements Interface1, Interface2{

    @Override
    public void test1() {

    }

    @Override
    public void test() {

    }
}
// 一个类既可以继承，也可以实现接口
class Test2 extends TestInterface implements Interface1{

    @Override
    public void test() {

    }
}

/**
 * 可以使用内部类变相的实现多重继承
 */
class A{
    public void show(){
        System.out.println("A");
    }
}
class B{
    public void show(){
        System.out.println("B");
    }
}
class All{
    public void showA(){ // 这样All类同时继承了AB两个类
        new InnerA().show();
        new InnerB().show();
    }
    class InnerA extends A{

    }
    class InnerB extends B{

    }
}
