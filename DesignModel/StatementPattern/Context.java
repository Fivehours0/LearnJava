package DesignModel.StatementPattern;

/**
 * Context是一个环境角色， 它的作用是串联各个状
 * 态的过渡， 在LiftSate抽象类中我们定义并把这个环境角色聚合进来， 并传递到子类， 也就是
 * 4个具体的实现类中自己根据环境来决定如何进行状态的过渡。
 *
 * 环境角色有两个不成文的约束：
 * ● 把状态对象声明为静态常量， 有几个状态对象就声明几个静态常量。
 * ● 环境角色具有状态抽象角色定义的所有行为， 具体执行使用委托方式。
 */
public class Context {
    // 定义出所有的电梯状态
    public final static OpenningState openningState = new OpenningState();
    public final static ClosingState closeingState = new ClosingState();
    public final static RunningState runningState = new RunningState();
    public final static StoppingState stoppingState = new StoppingState();

    // 定义一个电梯的状态
    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open(){
        this.liftState.open();
    }

    public void close(){
        this.liftState.close();
    }

    public void run(){
        this.liftState.run();
    }

    public void stop(){
        this.liftState.stop();
    }
}
