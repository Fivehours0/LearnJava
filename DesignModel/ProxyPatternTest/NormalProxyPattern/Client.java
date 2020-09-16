package DesignModel.ProxyPatternTest.NormalProxyPattern;

import DesignModel.ProxyPatternTest.ProxyPattern.Proxy;

public class Client {
    public static void main(String[] args) throws Exception {
        NormalProxy proxy = new NormalProxy("duzhihui");
        GamePlayer player = new GamePlayer(proxy, "du");
        proxy.login("duzhihui", "s");
        player.killBoss();
    }
}
