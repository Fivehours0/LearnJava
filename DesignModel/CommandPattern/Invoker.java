package DesignModel.CommandPattern;

public class Invoker {
    private Command command = null;
    public void setCommand (Command _command) {
        this.command = _command;
    }

    public void action () {
        this.command.execute();
    }
}
