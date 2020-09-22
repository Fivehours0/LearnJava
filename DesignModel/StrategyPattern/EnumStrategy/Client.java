package DesignModel.StrategyPattern.EnumStrategy;

/**
 * 策略枚举是一个非常优秀和方便的模式， 但是它受枚举类型的限制， 每个枚举项
 * 都是public、 final、 static的， 扩展性受到了一定的约束， 因此在系统开发中， 策略枚举一般
 * 担当不经常发生变化的角色。
 *
 * 有一个显著的优点： 真实地面向对象， 看看这条语句：Calculator.ADD.exec(a, b)
 * “拿出计算器（Calculator） ， 对a和b进行加法运算（ADD） ， 并立刻执行
 * (exec)”， 这与我们日常接触逻辑是不是非常相似， 这也正是我们架构师要担当的职责！
 */
public class Client {
    public static void main(String[] args) {
        int a = 1, b = 2;
        String symbol = "+";
        System.out.println("运行结果为： "+a+symbol+b+"="+Calculator.ADD.exec(a, b));
    }
}
