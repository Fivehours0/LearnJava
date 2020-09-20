package DesignModel.CommandPattern;

// 命令类
public abstract class Command {
    public abstract void execute();
}

// 具体的命令类
class ConcreteCommand1 extends Command {
    private Receiver receiver = null;
    public ConcreteCommand1 (Receiver _receiver) {
        this.receiver = _receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}

// 具体的命令类
class ConcreteCommand2 extends Command {
    private Receiver receiver = null;
    public ConcreteCommand2 (Receiver _receiver) {
        this.receiver = _receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}