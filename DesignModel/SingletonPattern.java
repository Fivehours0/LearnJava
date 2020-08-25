// 存在一些问题：单例模式继承接口是否有违规范。单例模式内的方法，是否尽量为静态方法
package DesignModel;
/**
 * 饿汉
 *  是线程安全的
 *
 *  缺陷1：如果类中还定义了一个静态的变量，那么静态变量被调用时也会加载类，而不是当getInstance被调用的时候（即我们要求加载）
 */
public class SingletonPattern {
    private SingletonPattern () {

    }

    private static final SingletonPattern test = new SingletonPattern();

    public static SingletonPattern getInstance() { // 因为该方法必须是static的，所以在申明test时，定义test为静态
        return test;
    }

    public void say () {
        System.out.println("this is a Singleton");
    }
}

/**
 * 懒汉
 *  懒汉是线程不安全的，在if判断时候有可能出错，导致创建多个实例。加上synchronized即可，这样在高并发的时候性能会降低
 */
class LazySingleton {
    private LazySingleton() {

    }

    private static LazySingleton test = null;

    public static synchronized LazySingleton getInstance() {
        if (test == null) {
            test = new LazySingleton();
        }
        return test;
    }
}

/**
 * 结合饿汉和懒汉
 */

class CombineTwo {
    private CombineTwo() {

    }

    // 内部类的使用，巧妙的解决了饿汉的缺点1：当别的静态变量初始化时，并不会初始化静态内部类，只有当getInstance被调用时会进行初始
    private static class SingletonHold {
        private static final CombineTwo test = new CombineTwo();
    }

    // 线程安全：因为没有判断语句
    public static CombineTwo getInstance () {
        return SingletonHold.test;
    }

    public static void main(String[] args) {
        CombineTwo c = CombineTwo.getInstance();
    }
}
