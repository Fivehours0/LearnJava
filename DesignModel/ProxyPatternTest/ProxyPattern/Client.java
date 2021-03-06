package DesignModel.ProxyPatternTest.ProxyPattern;

/**
 * 我以为，要使用代理模式，得有个像IGamePlayer一样的接口
 *
 * 代理模式的优点
 * ● 职责清晰
 * 真实的角色就是实现实际的业务逻辑， 不用关心其他非本职责的事务， 通过后期的代理
 * 完成一件事务， 附带的结果就是编程简洁清晰。
 * ● 高扩展性(这个特点由Proxy中的player变量体现)
 * 具体主题角色是随时都会发生变化的， 只要它实现了接口， 甭管它如何变化， 都逃不脱
 * 如来佛的手掌（接口） ， 那我们的代理类完全就可以在不做任何修改的情况下使用。
 * ● 智能化
 * 这在我们以上的讲解中还没有体现出来， 不过在我们以下的动态代理章节中你就会看到
 * 代理的智能化有兴趣的读者也可以看看Struts是如何把表单元素映射到对象上的。
 *
 *
 * 代理模式的使用场景
 * 我相信第一次接触到代理模式的读者肯定很郁闷， 为什么要用代理呀？ 想想现实世界
 * 吧， 打官司为什么要找个律师？ 因为你不想参与中间过程的是是非非， 只要完成自己的答辩
 * 就成， 其他的比如事前调查、 事后追查都由律师来搞定， 这就是为了减轻你的负担。 代理模
 * 式的使用场景非常多， 大家可以看看Spring AOP， 这是一个非常典型的动态代理。
 *
 * 代理本身也是有个性的
 * 例如可以添加一个IProxy类，然后Proxy继承接口，实现代理的个性化功能。例如每升一级，进行收费等等
 */
public class Client {
    public static void main(String[] args) {
        GamePlayer gp = new GamePlayer();
        Proxy proxy = new Proxy(gp);
        proxy.login("duzhihui", "202");
        proxy.killBoss();
        proxy.upgrade();
    }
}
