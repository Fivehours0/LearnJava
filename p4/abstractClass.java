package p4;
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
 * 模板方法设计模式
 * 例如：去银行办业务，银行给我们提供了一个模板就是：先取号，排对，办理业务（核心部分我们子类完成），给客服人员评分，完毕。
 这里办理业务是属于子类来完成的，其他的取号，排队，评分则是一个模板。
 */
abstract class Template{
    public final void getTime(){
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    public abstract void code();
}

class SubTemplate extends Template {
    @Override
    public void code() {
        for(int i=0; i<10000; i++){
            if(i>9990){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        SubTemplate subTemplate = new SubTemplate();
        subTemplate.getTime();
    }
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
class Test2 extends Template implements Interface1{

    @Override
    public void test() {

    }

    @Override
    public void code() {

    }
}

/**
 * 工厂模式
 * 通过工厂把new对象给隔离，通过产品的接口可以接受不同实际产品的实现类实例的
 * 类名的改变不影响其他合作开发人员的编程
 */

 /**
  * 内部类
  */
class InClass{
    private int age = 10;
    private String name = "duzhihui";
    class In{ // 相当于是一个类变量了
        private int height = 100;
        private void showInfo(){
            System.out.println(InClass.this.age); //访问外部类的数据
            System.out.println(this.height); // 访问内部类自己的数据
        }
    }
    public void showInClassInfo(){
        In in = new In();
        in.showInfo(); // 访问类变量的方法
    }

    public static void main(String[] args) {
        InClass inClass = new InClass();
        inClass.showInClassInfo();
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
