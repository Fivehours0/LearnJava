package DesignModel.FacadePattern;

/**
 * 注意事项：
 *  可以有多个门面
 *      1.门面已经庞大到不能忍受的程度
 *      比如一个纯洁的门面对象已经超过了200行的代码， 虽然都是非常简单的委托操作， 也
 *      建议拆分成多个门面， 否则会给以后的维护和扩展带来不必要的麻烦。 那怎么拆分呢？ 按照
 *      功能拆分是一个非常好的原则， 比如一个数据库操作的门面可以拆分为查询门面、 删除门
 *      面、 更新门面等。
 *
 *  门面不参与子系统内的业务逻辑，当涉及业务逻辑时，处理方法如下的Context
 *
 *
 */
public class Facade {
    //被委托的对象
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private Context context = new Context();

    //提供给外部访问的方法
    public void methodA() {
        this.a.doSomethingA();
    }

    public void methodB() {
        this.b.doSomethingB();
    }

    public void methodC() { this.context.methodContext(); }
}

class Context {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    public void methodContext() {
        a.doSomethingA();
        b.doSomethingB();
    }
}