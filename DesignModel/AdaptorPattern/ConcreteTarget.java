package DesignModel.AdaptorPattern;

public class ConcreteTarget implements Target {
    @Override
    public String request() {
        return new String("request");
    }
}
