package DesignModel.ObserverPattern;

/**
 * ConcreteObserver具体的观察者
 * 每个观察在接收到消息后的处理反应是不同， 各个观察者有自己的处理逻辑。
 */
public class ConcreteObserver implements Observer{
    //实现更新方法
    public void update() {
        System.out.println("监视者接受到被监视者的行动，并进行处理！ ");
    }
}
