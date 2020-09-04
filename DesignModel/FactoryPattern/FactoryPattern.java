package DesignModel.FactoryPattern;
// 模仿书中女娲造人的故事。该例子算是一个比较标准的工厂类模板，之后可以进行套用
// 工厂模式的拓展：
// 1.简单工厂,使用静态的类方法方式替换了原先的抽象工厂生成实例的过程
// 2.多工厂：一个产品一个工厂，减少了耦合但也更加难维护
// 3.单例工厂：使用工厂方法也可以产生单例，而且也可以利用反射机制来制造单例工厂
// 4.延迟初始化：使用一个Map来维护，在Map中已经有这个对象了，则返回，没有则创建并返回，省去了频繁的对象创建和销毁（因为有些对象创建一次就可以频繁
//     使用了，例如硬件访问等，某种角度来说算是单例工厂）

// 女娲使用工厂创建人类
public class FactoryPattern {
    public static void main(String[] args) {
        HumanFactor factor = new HumanFactor();
        Human human1 = factor.createHuman(YellowHuman.class);
        Human human2 = factor.createHuman(BlackHuman.class);
        Human human3 = factor.createHuman(WhiteHuman.class);
        human1.getColor();
        human2.getColor();
        human3.getColor();
    }
}






