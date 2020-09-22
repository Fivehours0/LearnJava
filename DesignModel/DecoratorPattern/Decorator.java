package DesignModel.DecoratorPattern;

/**
 * 将装饰类一个个拆分开来，例如这里的装饰1和装饰2，如果全部塞到Decorator中，随着所要装饰的内容增多，或者因为需求而改变装饰的顺序，这会使得
 * Decorator变得非常的复杂。
 *
 * 一般是一个抽象类， 做什么用呢？ 实现接口或者抽象方法， 它里面可不一定有抽象的方
 * 法呀， 在它的属性里必然有一个private变量指向Component抽象构件。
 *
 * 装饰类从另一个角度来讲，也可以理解为代理模式，代理component运行
 */
public abstract class Decorator extends Component{
    private Component component = null;

    Decorator (Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        this.component.operate();
    }
}

class ConcreteDecorator1 extends Decorator {

    ConcreteDecorator1(Component component) {
        super(component);
    }

    private void method1 () {
        System.out.println("method1 装饰");
    }

    @Override
    public void operate() {
        method1();
        super.operate();
    }
}

class ConcreteDecorator2 extends Decorator {

    ConcreteDecorator2(Component component) {
        super(component);
    }

    private void method2 () {
        System.out.println("method2 装饰");
    }

    @Override
    public void operate() {
        method2();
        super.operate();
    }
}