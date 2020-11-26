package DesignModel.StatementPattern;

public abstract class LiftState {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}


class OpenningState extends LiftState {
    //开启当然可以关闭了， 我就想测试一下电梯门开关功能
    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.closeingState);
        //动作委托为CloseState来执行
        super.context.getLiftState().close();
    }

    //打开电梯门
    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    //门开着时电梯就运行跑， 这电梯， 吓死你！
    @Override
    public void run() {
        //do nothing;
    }

    //开门还不停止？
    public void stop() {
        //do nothing;
    }
}

class ClosingState extends LiftState {
    //电梯门关闭， 这是关闭状态要实现的动作
    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }

    //电梯门关了再打开
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState); //置为敞门状态
        super.context.getLiftState().open();
    }

    //电梯门关了就运行， 这是再正常不过了
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState); //设置为运行状态
        super.context.getLiftState().run();
    }

    //电梯门关着， 我就不按楼层
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState); //设置为停止状态
        super.context.getLiftState().stop();
    }
}


class RunningState extends LiftState {
    //电梯门关闭？ 这是肯定的
    @Override
    public void close() {
        //do nothing
    }

    //运行的时候开电梯门？ 你疯了！ 电梯不会给你开的
    @Override
    public void open() {
        //do nothing
    }

    //这是在运行状态下要实现的方法
    @Override
    public void run() {
        System.out.println("电梯上下运行...");
    }

    //这绝对是合理的， 只运行不停止还有谁敢坐这个电梯？ ！ 估计只有上帝了
    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);//环境设置为停止状态
        super.context.getLiftState().stop();
    }
}

class StoppingState extends LiftState {
    //停止状态关门？ 电梯门本来就是关着的！
    @Override
    public void close() {
        //do nothing;
    }

    //停止状态， 开门， 那是要的！
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.getLiftState().open();
    }

    //停止状态再运行起来， 正常得很
    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    //停止状态是怎么发生的呢？ 当然是停止方法执行了
    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}