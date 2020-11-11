package DesignModel.ProxyPatternTest.NormalProxyPattern;

/**
 * 普通代理， 它的要求就是客户端只能访问代理角色， 而不能访问真实角色， 这是
 * 比较简单的。 我们以上面的例子作为扩展， 我自己作为一个游戏玩家， 我肯定自己不练级
 * 了， 也就是场景类不能再直接new一个GamePlayer对象了， 它必须由GamePlayerProxy来进行
 * 模拟场景，
 *
 * 缺点是 增加了耦合度
 *
 * 其实在Client中也是可以new一个GamePlayer的，例如
 * GamePlayer gp = new GamePlayer(proxy, "dd")
 * 在实际的项目中， 一般都是通过约定来禁止new一个真实的角色， 这也是一个
 * 非常好的方案。但使用技术约束的方式对系统维护是一种非常不利的因素。
 *
 * 还有一种代理模式的扩展为强制代理
 * 与普通代理相反，他是在GamePlayer里面创建属于玩家自己的代理，即只能通过玩家来get代理。
 */
public class Client {
    public static void main(String[] args) throws Exception {
        NormalProxy proxy = new NormalProxy("duzhihui");
        proxy.login("duzhihui", "s");
    }
}
