package DesignModel.ObserverPattern;

import java.util.ArrayList;

/**
 * Subject被观察者定义被观察者必须实现的职责， 它必须能够动态地增加、 取消观察者。 它一般是抽象类
 * 或者是实现类， 仅仅完成作为被观察者必须实现的职责： 管理观察者并通知观察者。
 */
public abstract class Subject {
    // 定义一个观察者数组
    private ArrayList<Observer> observers = new ArrayList<>();

    // 增加一个观察者
    public void addObserver (Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver (Observer observer) {
        observers.remove(observer);
    }

    //通知所有观察者
    public void notifyObservers(){
        for(Observer o:this.observers){
            o.update();
        }
    }
}
