package DesignModel.StrategyPattern;

public abstract class Strategy {
    public abstract void doSomething ();
}

// 策略1
class ConcreteStrategy1 extends Strategy {

    @Override
    public void doSomething() {
        System.out.println("Strategy1");
    }
}

// 策略2
class ConcreteStrategy2 extends Strategy {

    @Override
    public void doSomething() {
        System.out.println("Strategy2");
    }
}
