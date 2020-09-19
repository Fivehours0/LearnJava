package DesignModel.MediatorPattern;

public abstract class AbstractMediator {
    // 中介者需要知道各个人员的情况，所以在这里创建对象。
    protected Purchase purchase = null;
    protected Sale sale = null;
    protected Stock stock = null;

    AbstractMediator () {
        Purchase purchase = new Purchase(this);
        Sale sale = new Sale(this);
        Stock stock = new Stock(this);
    }

    public abstract void execute (String s, Object... objects);
}
