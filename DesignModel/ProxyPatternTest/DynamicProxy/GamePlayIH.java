package DesignModel.ProxyPatternTest.DynamicProxy;

import javax.xml.transform.Result;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {
    Object target;

    GamePlayIH(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前........");
        Object result = method.invoke(target, args);
        System.out.println("方法执行后........");
        return result;
    }
}
