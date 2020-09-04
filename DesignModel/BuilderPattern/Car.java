package DesignModel.BuilderPattern;

import java.util.ArrayList;

/**
 * 实现汽车的特性
 */
abstract class CarModel {
    protected abstract void start ();
    protected abstract void alarm ();
    protected abstract void stop ();

    public final void run () {
        for (String actionName : sequence) {
            switch (actionName) {
                case "start":
                    start();
                    break;
                case "alarm":
                    alarm();
                    break;
                case "stop":
                    stop();
                    break;
            }
        }
    }

    public void setSequence (ArrayList<String> sequence) {
        this.sequence = sequence;
    }

    private ArrayList<String> sequence = new ArrayList<>();
}

/**
 * 具体类实现个性功能（即实现模板类中的抽象方法）
 */
class BWM extends CarModel {
    private final String name = "BWM";

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
}

/**
 * 具体类实现个性功能（即实现模板类中的抽象方法）
 */
class BenZ extends CarModel {
    private final String name = "BenZ";

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
}