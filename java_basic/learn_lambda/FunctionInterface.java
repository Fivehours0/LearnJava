package java_basic.learn_lambda;

/**
 * 函数式接口，只有一个抽象方法的接口，可以使用注解@FunctionalInterface
 * 他会检查该接口是否为函数式接口
 */
@FunctionalInterface
public interface FunctionInterface<T> {
    boolean filter(T o);
}
