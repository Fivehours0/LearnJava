package DesignModel.FactoryPattern;

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
