package DesignModel.CommandPattern;

// 命令的接受者
public abstract class Receiver {
    public abstract void doSomething();
}

class ConcreteReceiver1 extends Receiver {

    @Override
    public void doSomething() {

    }
}

class ConcreteReceiver2 extends Receiver {

    @Override
    public void doSomething() {

    }
}


