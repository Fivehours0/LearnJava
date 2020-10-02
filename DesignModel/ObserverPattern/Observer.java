package DesignModel.ObserverPattern;

/**
 * Observer观察者
 * 观察者接收到消息后， 即进行update（更新方法） 操作， 对接收到的信息进行处理
 * 其实在观察者模式中，update观察者的方式是：当被观察者的状态发生变化时，调用观察者的函数
 *
 * 观察者一般是一个接口， 每一个实现该接口的实现类都是具体观察者，
 */
public interface Observer {
    void update ();
}
