package DesignModel.ProxyPatternTest.DynamicProxy;

import DesignModel.ProxyPatternTest.ProxyPattern.IGamePlayer;

/**
 * 具体化玩家的登录，打boss，升级等操作，这些操作的执行由代理类来完成
 */
public class GamePlayer implements IGamePlayer {
    private String name = "";
    @Override
    public void login(String name, String password) {
        this.name = name;
        System.out.println(name + "login successful");
    }

    @Override
    public void killBoss() {
        System.out.println(name + "is killing Boss");
    }

    @Override
    public void upgrade() {
        System.out.println(name + "is upgrading");
    }
}
