package DesignModel.ProxyPatternTest.ProxyPattern;

/**
 * 代理类，帮玩家完成打游戏这个动作
 */
public class Proxy implements IGamePlayer {
    // 注意，这里的变量类型为IGamePlayer接口类型，想代理啥就代理啥，只要实现了IGamePlayer接口即可
    private IGamePlayer player = null;

    Proxy (IGamePlayer player) {
        this.player = player;
    }

    @Override
    public void login(String name, String password) {
        player.login(name, password);
    }

    private void before () {

    }

    /**
     *
     */
    @Override
    public void killBoss() {
        // 这里也是一个特别的地方，可以加一些自己相加的。
        before();
        player.killBoss();
        after();
    }

    private void after () {

    }

    @Override
    public void upgrade() {
        player.upgrade();
    }
}
