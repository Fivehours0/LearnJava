package DesignModel.ProxyPatternTest.NormalProxyPattern;

import DesignModel.ProxyPatternTest.ProxyPattern.IGamePlayer;

public class GamePlayer implements IGamePlayer {
    private String name;

    public GamePlayer (IGamePlayer proxy, String name) throws Exception {
        if (proxy == null) {
            throw new Exception ("不能创建真实角色");
        } else {
            this.name = name;
        }
    }

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
