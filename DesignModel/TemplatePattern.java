package DesignModel;

/**
 * 模板方法：
 *  首先搭建一套公共的框架，这里举的例子是关于车的，启动，鸣笛，停止
 * 模板完成共性功能，由具体类实现个性功能（即实现模板类中的抽象方法）
 *
 * 缺点
 *  按照我们的设计习惯， 抽象类负责声明最抽象、 最一般的事物属性和方法， 实现类完成
 *  具体的事物属性和方法。 但是模板方法模式却颠倒了， 抽象类定义了部分抽象方法， 由子类
 *  实现， 子类执行的结果影响了父类的结果， 也就是子类对父类产生了影响， 这在复杂的项目
 *  中， 会带来代码阅读的难度， 而且也会让新手产生不适感。
 */
abstract class Common {
    protected abstract void start ();
    protected abstract void alarm ();
    protected abstract void stop ();

    public final void run () {
        start();
        if (setIsAlarm())
            alarm();
        stop();
    }

    // Hook Method  钩子方法，由子类重写来决定是否鸣笛
    protected boolean setIsAlarm () {
        return false;
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.run();
        Taxi t = new Taxi();
        t.run();
    }
}

/**
 * 具体类实现个性功能（即实现模板类中的抽象方法）
 */
class Car extends Common {
    private final String name = "car";

    @Override
    protected void start() {
        System.out.println(name+"start");
    }

    @Override
    protected void alarm() {
        System.out.println(name+"alarm");
    }

    @Override
    protected void stop() {
        System.out.println(name+"stop");
    }

    @Override
    protected boolean setIsAlarm() {
        return true;
    }
}

/**
 * 具体类实现个性功能（即实现模板类中的抽象方法）
 */
class Taxi extends Common {
    private final String name = "Taxi";

    @Override
    protected void start() {
        System.out.println(name+"start");
    }

    @Override
    protected void alarm() {
        System.out.println(name+"alarm");
    }

    @Override
    protected void stop() {
        System.out.println(name+"stop");
    }

    @Override
    protected boolean setIsAlarm() {
        return false;
    }
}