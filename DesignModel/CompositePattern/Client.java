package DesignModel.CompositePattern;

/**
 * 组合模式的优点
 * ● 高层模块调用简单
 * 一棵树形机构中的所有节点都是Component， 局部和整体对调用者来说没有任何区别，
 * 也就是说， 高层模块不必关心自己处理的是单个对象还是整个组合结构， 简化了高层模块的
 * 代码。
 * ● 节点自由增加
 * 使用了组合模式后， 我们可以看看， 如果想增加一个树枝节点、 树叶节点是不是都很容
 * 易， 只要找到它的父节点就成， 非常容易扩展， 符合开闭原则， 对以后的维护非常有利。
 *
 * 组合模式的缺点
 * 组合模式有一个非常明显的缺点， 看到我们在场景类中的定义， 提到树叶和树枝使用时
 * 的定义了吗？ 直接使用了实现类！ 这在面向接口编程上是很不恰当的， 与依赖倒置原则冲
 * 突， 读者在使用的时候要考虑清楚， 它限制了你接口的影响范围。
 *
 * 组合模式的使用场景
 * ● 维护和展示部分-整体关系的场景， 如树形菜单、 文件和文件夹管理。
 * ● 从一个整体中能够独立出部分模块或功能的场景。
 *
 * 组合模式的注意事项
 * 只要是树形结构， 就要考虑使用组合模式， 这个一定要记住， 只要是要体现局部和整体
 * 的关系的时候， 而且这种关系还可能比较深， 考虑一下组合模式吧。
 */
public class Client {
    public static void main(String[] args) {
        //创建一个根节点
        Composite root = new Composite();
        root.doSomething();
        //创建一个树枝构件
        Composite branch = new Composite();
        //创建一个叶子节点
        Leaf leaf = new Leaf();
        //建立整体
        root.add(branch);
        branch.add(leaf);
    }

    public void display (Composite root) {
        for (Component c: root.getChildren()) {
            if (c instanceof Leaf) {
                c.doSomething();
            } else {
                display((Composite) c);
            }
        }
    }
}
