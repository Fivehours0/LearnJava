package DesignModel.ProxyPatternTest.DynamicProxy;

import DesignModel.ProxyPatternTest.ProxyPattern.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IGamePlayer gp = new GamePlayer();
        InvocationHandler gpIH = new GamePlayIH(gp);
        ClassLoader cl = gp.getClass().getClassLoader();
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, gp.getClass().getInterfaces(), gpIH);
        proxy.login("张三", "7758258");
        proxy.killBoss();
        proxy.upgrade();
    }
}
