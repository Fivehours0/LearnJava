package DesignModel.DecoratorPattern;

public abstract class Component {
    public abstract void operate ();
}

/**
 * ConcreteComponent是最核心、 最原始、 最基本的接口或抽象类的实现， 你要装饰的就是它
 */
class ConcreteComponent extends Component {

    @Override
    public void operate() {
        System.out.println("do something");
    }
}
