package DesignModel;
// 模仿书中女娲造人的故事。该例子算是一个比较标准的工厂类模板，之后可以进行套用
// 工厂模式的拓展：1.简单工厂 2.多工厂 3.单例工厂 4.延迟初始化

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

interface Human {
    public abstract void getColor();
    public abstract void talk();
}

class YellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("yellow");
    }

    @Override
    public void talk() {
        System.out.println("我是黄种人");
    }
}

class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("black");
    }

    @Override
    public void talk() {
        System.out.println("我是黑人");
    }
}

class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("white");
    }

    @Override
    public void talk() {

    }
}

// 生产人类的工厂
abstract class AbstractHumanFactor {
    public abstract <T extends Human> T createHuman (Class<T> c); // c必须是Class类型，必须是Human的实现类
}

class HumanFactor extends AbstractHumanFactor {

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        T human = null;
        try {
            // 利用反射机制创建一个类
            human = c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("人种生成错误");
        }
        return human;
    }
}



