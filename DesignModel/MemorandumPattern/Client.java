package DesignModel.MemorandumPattern;

/**
 * 在不破坏封装性的前提下， 捕获一个对象的内部状
 * 态， 并在该对象之外保存这个状态。 这样以后就可将该对象恢复到原先保存的状态。
 *
 *
 * 备忘录模式的使用场景
 * 需要保存和恢复数据的相关状态场景。
 * ● 提供一个可回滚（rollback） 的操作； 比如Word中的CTRL+Z组合键， IE浏览器中的后
 * 退按钮， 文件管理器上的backspace键等。
 * ● 需要监控的副本场景中。 例如要监控一个对象的属性， 但是监控又不应该作为系统的
 * 主业务来调用， 它只是边缘应用， 即使出现监控不准、 错误报警也影响不大， 因此一般的做
 * 法是备份一个主线程中的对象， 然后由分析程序来分析。
 * ● 数据库连接的事务管理就是用的备忘录模式， 想想看， 如果你要实现一个JDBC驱
 * 动， 你怎么来实现事务？ 还不是用备忘录模式嘛！
 *
 *
 * 备忘录模式的注意事项
 * ● 备忘录的生命期
 * 备忘录创建出来就要在“最近”的代码中使用， 要主动管理它的生命周期， 建立就要使
 * 用， 不使用就要立刻删除其引用， 等待垃圾回收器对它的回收处理。
 * ● 备忘录的性能
 * 不要在频繁建立备份的场景中使用备忘录模式（比如一个for循环中） ，
 * 原因有二： 一是控制不了备忘录建立的对象数量； 二是大对象的建立是要消耗资源的， 系统的性能需要考
 * 虑。 因此， 如果出现这样的代码， 设计师就应该好好想想怎么修改架构了。
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("fighting");
        System.out.println("最初状态"+originator.getState());
        caretaker.setMemento(originator.createMemento());

        originator.setState("breaking");
        System.out.println("状态发生变化"+originator.getState());

        originator.setState(caretaker.getMemento().getState());
        System.out.println("状态复原"+originator.getState());
    }
}
