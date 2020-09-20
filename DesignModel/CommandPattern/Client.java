package DesignModel.CommandPattern;

/**
 * 命令模式的优点
 * ● 类间解耦
 * 调用者角色与接收者角色之间没有任何依赖关系， 调用者实现功能时只需调用Command
 * 抽象类的execute方法就可以， 不需要了解到底是哪个接收者执行。
 * ● 可扩展性
 * Command的子类可以非常容易地扩展， 而调用者Invoker和高层次的模块Client不产生严
 * 重的代码耦合。
 * ● 命令模式结合其他模式会更优秀
 * 命令模式可以结合责任链模式， 实现命令族解析任务； 结合模板方法模式， 则可以减少
 * Command子类的膨胀问题。
 *
 * 命令模式的缺点
 * 命令模式也是有缺点的， 请看Command的子类： 如果有N个命令， 问题就出来
 * 了， Command的子类就可不是几个， 而是N个， 这个类膨胀得非常大， 这个就需要读者在项
 * 目中慎重考虑使用。
 */
public class Client {
    /**
     * 命令者模式
     * 举个例子：
     *  Receiver，即命令的接收者有：小王，小杜，小夏
     *  Command。 即命令的类型有：跑，蹲下，跳
     *  Invoker. 负责命令的执行
     *
     *  在Command的初始化时，设置了该命令的接收者
     */
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver pig = new ConcreteReceiver1();
        Command command = new ConcreteCommand1(pig);

        invoker.setCommand(command);
        invoker.action();
    }
}
