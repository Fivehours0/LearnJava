package DesignModel.AbstractFactory;

public interface AbstractHuman {
    void getColor ();
    void say ();
    void getSex();
}

// 创建人类，按肤色分，分为黄黑白，按性别分，分为男女
abstract class AbstractYellowAbstractHuman implements AbstractHuman {
    public void getColor () {
        System.out.println("i am yellow");
    }

    public void say () {
        System.out.println("yellow say hi");
    }
}

abstract class AbstractBlackAbstractHuman implements AbstractHuman {
    public void getColor () {
        System.out.println("i am yellow");
    }

    public void say () {
        System.out.println("yellow say hi");
    }
}

abstract class AbstractWhiteAbstractHuman implements AbstractHuman {
    public void getColor () {
        System.out.println("i am yellow");
    }

    public void say () {
        System.out.println("yellow say hi");
    }
}
