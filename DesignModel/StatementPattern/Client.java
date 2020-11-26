package DesignModel.StatementPattern;

/**
 * 状态模式
 * 当一个对象内在状态改变时允许其改变行为， 这个对象看起来像改变了其类。
 *
 * 状态模式的优点
 * ● 结构清晰
 * 避免了过多的switch...case或者if...else语句的使用， 避免了程序的复杂性,提高系统的可
 * 维护性。
 * ● 遵循设计原则
 * 很好地体现了开闭原则和单一职责原则， 每个状态都是一个子类， 你要增加状态就要增
 * 加子类， 你要修改状态， 你只修改一个子类就可以了。
 * ● 封装性非常好
 * 这也是状态模式的基本要求， 状态变换放置到类的内部来实现， 外部的调用不用知道类
 * 内部如何实现状态和行为的变换。
 *
 *
 * 状态模式的缺点
 * 状态模式既然有优点， 那当然有缺点了。 但只有一个缺点， 子类会太多， 也就是类膨
 * 胀。 如果一个事物有很多个状态也不稀奇， 如果完全使用状态模式就会有太多的子类， 不好
 * 管理， 这个需要大家在项目中自己衡量。 其实有很多方式可以解决这个状态问题， 如在数据
 * 库中建立一个状态表， 然后根据状态执行相应的操作， 这个也不复杂， 看大家的习惯和嗜好
 * 了。
 *
 * 状态模式的使用场景
 * ● 行为随状态改变而改变的场景
 * 这也是状态模式的根本出发点， 例如权限设计， 人员的状态不同即使执行相同的行为结
 * 果也会不同， 在这种情况下需要考虑使用状态模式。
 * ● 条件、 分支判断语句的替代者
 * 在程序中大量使用switch语句或者if判断语句会导致程序结构不清晰， 逻辑混乱， 使用
 * 状态模式可以很好地避免这一问题， 它通过扩展子类实现了条件的判断处理。
 *
 * 状态模式的注意事项
 * 状态模式适用于当某个对象在它的状态发生改变时， 它的行为也随着发生比较大的变
 * 化， 也就是说在行为受状态约束的情况下可以使用状态模式， 而且使用时对象的状态最好不
 * 要超过5个。
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}