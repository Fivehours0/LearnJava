package DesignModel.ChainOfResponsiblilityPattern;

public abstract class Handler {
    private Handler nextHandler = null; // 若无法处理该等级的需求，则移交下一个等级更高的处理者

    public final Respond handleMessage (Request request) {
        Respond respond = null;
        if (request.getLevel() == this.getLevel()) {
            respond = this.echo(request);
        } else {
            if (this.nextHandler != null)
                respond = this.nextHandler.echo(request);
            else {
                // 没有下一级的处理者，拒绝request
            }
        }
        return respond;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract Level getLevel();
    protected abstract Respond echo (Request request);
}

class ConcreteHandler1 extends Handler {

    // 定义自己的处理逻辑
    @Override
    protected Level getLevel() {
        return null;
    }

    // 定义自己的处理级别
    @Override
    protected Respond echo(Request request) {
        return null;
    }
}

class ConcreteHandler2 extends Handler {

    // 定义自己的处理逻辑
    @Override
    protected Level getLevel() {
        return null;
    }

    // 定义自己的处理级别
    @Override
    protected Respond echo(Request request) {
        return null;
    }
}

class ConcreteHandler3 extends Handler {

    // 定义自己的处理逻辑
    @Override
    protected Level getLevel() {
        return null;
    }

    // 定义自己的处理级别
    @Override
    protected Respond echo(Request request) {
        return null;
    }
}