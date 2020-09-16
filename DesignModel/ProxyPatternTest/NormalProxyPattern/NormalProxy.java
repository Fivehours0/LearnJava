package DesignModel.ProxyPatternTest.NormalProxyPattern;

import DesignModel.ProxyPatternTest.ProxyPattern.IGamePlayer;

public class NormalProxy implements IGamePlayer {
    private IGamePlayer player = null;

    public NormalProxy (String name) {
        try {
            player = new GamePlayer(this, "duzhihui");
        } catch (Exception e) {
            // 异常处理
        }
    }

    @Override
    public void login(String name, String password) {
        player.login(name, password);
    }

    @Override
    public void killBoss() {
        player.killBoss();
    }

    @Override
    public void upgrade() {
        player.upgrade();
    }
}
