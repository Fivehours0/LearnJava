package DesignModel.StrategyPattern;

/**
 * 策略模式的重点就是封装角色， 它是借用了代理模式的思路， 大家可以想想， 它和代理
 * 模式有什么差别， 差别就是策略模式的封装角色和被封装的策略类不用是同一个接口， 如果
 * 是同一个接口那就成为了代理模式。 封装角色代码如下
 */
public class Context {
    private Strategy strategy = null;
    Context (Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAnything () {
        this.strategy.doSomething();
    }
}
