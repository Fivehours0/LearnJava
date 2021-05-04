package AopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect // 将增强类用aspect标记
@Order(1) // order内的数字越小，优先级越高。从0开始
public class Advisor {

    // 抽取相同的切入点，如果需要改execution的表达式，只需要改这一个地方就可以了
    @Pointcut(value = "execution(* AopAnno.User.add(..))")
    public void addPoint() {}

    // 前置通知
    @Before(value = "addPoint()") // 这里使用了抽取的公共切入点
    public void before() {
        System.out.println("before。。。。。。。。。。。。。。");
    }

    // 后置通知
    @AfterReturning(value = "execution(* AopAnno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning。。。。。。。。。。。。");
    }

    // 最终通知 与后置通知的区别：当发生异常时，他仍然会发送通知，而AfterReturning不会
    @After(value = "execution(* AopAnno.User.add(..))")
    public void after() {
        System.out.println("after最终通知。。。。。。。。。。。。");
    }

    // 环绕通知
    @Around(value = "execution(* AopAnno.User.add(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before。。。。。。。。。。。。");
        jp.proceed();
        System.out.println("around after。。。。。。。。。。。。");
    }

    // 异常通知
    @AfterThrowing(value = "execution(* AopAnno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing。。。。。。。。。。。。");
    }
}
