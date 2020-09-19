package DesignModel.MediatorPattern;

/**
 * 中介者模式也叫做调停者模式， 是什么意思呢？ 一个对象要和N多个对象交流， 就像对
 * 象间的战争， 很混乱。 这时， 需要加入一个中心， 所有的类都和中心交流， 中心说怎么处理
 * 就怎么处理， 例如机场调度中心，网关，中介服务
 *
 * 中介者模式的优点
 * 中介者模式的优点就是减少类间的依赖， 把原有的一对多的依赖变成了一对一的依赖，
 * 同事类只依赖中介者， 减少了依赖， 当然同时也降低了类间的耦合。
 *
 * 中介者模式的缺点
 * 中介者模式的缺点就是中介者会膨胀得很大， 而且逻辑复杂， 原本N个对象直接的相互
 * 依赖关系转换为中介者和同事类的依赖关系， 同事类越多， 中介者的逻辑就越复杂。
 *
 * 中介者模式适用于多个对象之间紧密耦合的情况， 紧密耦合的标准是： 在类图中出现了蜘蛛网状结构。 在
 * 这种情况下一定要考虑使用中介者模式， 这有利于把蜘蛛网梳理为星型结构， 使原本复杂混
 * 乱的关系变得清晰简单。
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        //这里有个问题，Purchase对象不管新建多少个，用的都是mediator里的同一个
        Purchase purchase = new Purchase(mediator);
        purchase.buyIBMComputer(100);
        // 也可以像下面这么干
        // mediator.purchase.buyIBMComputer(100);
    }
}
