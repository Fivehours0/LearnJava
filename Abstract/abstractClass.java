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
