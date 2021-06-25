package AOPXml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

public class Advisor {
    public void before() {
        System.out.println("before method");
    }

    public void afterReturning() {
        System.out.println("afterReturning。。。。。。。。。。。。");
    }

    public void after() {
        System.out.println("after最终通知。。。。。。。。。。。。");
    }

    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before。。。。。。。。。。。。");
        jp.proceed();
        System.out.println("around after。。。。。。。。。。。。");
    }

    public void afterThrowing() {
        System.out.println("afterThrowing。。。。。。。。。。。。");
    }
}
