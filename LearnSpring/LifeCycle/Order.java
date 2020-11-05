package LearnSpring.LifeCycle;

public class Order {
    String name;

    Order() {
        System.out.println("Order的构造器被调用");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("属性注入");
    }

    public void initMethod() {
        System.out.println("Order被初始化" + "属性name的值" + this.name);
    }

    public void destroy() {
        System.out.println("Order被销毁");
    }
}
