package Abstract;

/**
 * 接口，用来抽象方法的
 * 子类继承父类，只能继承一个父类
 * 类可以实现多个接口，多个接口用，分隔
 *
 * 如果父类经常发生变化，基于这个父类的子类，子类的子类，这些子类都有收到影响
 * 有时我们又确实需要给父类增加一些方法，那么就不能直接在父类上下手，只能新建
 * 一个接口，在接口上拓展方法，其他需要的子类自行去实现接口
 */
interface Interface1{
    int ID = 1; // 等同于public static final int ID = 1;
    void test(); // 等同于public abstract void test();
}

interface Interface2{
    String name = "duzhihui";
    void test1();
}

class TestInterface implements Interface1, Interface2{

    @Override
    public void test1() {

    }

    @Override
    public void test() {

    }
}