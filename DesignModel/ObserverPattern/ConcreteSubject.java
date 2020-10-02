package DesignModel.ObserverPattern;

/**
 * ConcreteSubject具体的被观察者
 * 定义被观察者自己的业务逻辑， 同时定义对哪些事件进行通知
 */
public class ConcreteSubject extends Subject {
    public void doSomething () {
        System.out.println("ConcreteSubject 开始行动");
        // 处理完成被观察者自身的事务，比如吃饭，睡觉，通知所有监视着
        super.notifyObservers();
    }
}
