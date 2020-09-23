package DesignModel.AdaptorPattern.ObjectAdaptor;

/**
 * 对象适配器的通用代码也比较简单， 把原有的继承关系变更为关联关系就可以了， 不再赘
 * 述。 对象适配器和类适配器的区别是： 类适配器是类间继承， 对象适配器是对象的合成关
 * 系， 也可以说是类的关联关系， 这是两者的根本区别。 二者在实际项目中都会经常用到， 由
 * 于对象适配器是通过类间的关联关系进行耦合的， 因此在设计时就可以做到比较灵活， 比如
 * 修补源角色的隐形缺陷， 关联其他对象等， 而类适配器就只能通过覆写源角色的方法进行扩
 * 展， 在实际项目中， 对象适配器使用到场景相对较多。
 */
public class Adaptor {
    private Info1 info1 = null;
    private Info2 info2 = null;
    private Info3 info3 = null;

    Adaptor (Info1 info1, Info2 info2, Info3 info3) {
        this.info1 = info1;
        this.info2 = info2;
        this.info3 = info3;
    }

    public String getInfo1 () {
        return new String(info1.doSomething());
    }

    public String getInfo2 () {
        return new String(info2.doSomething());
    }

    public String getInfo3 () {
        return new String(info3.doSomething());
    }
}
