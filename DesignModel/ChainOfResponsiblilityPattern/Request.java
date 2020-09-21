package DesignModel.ChainOfResponsiblilityPattern;

public class Request {
    private Level level = null;
    private String request = "";

    // 需求暂时用String表示，level表示该需求的等级
    Request (Level level, String  request) {
        this.level = level;
        this.request = request;
    }

    public Level getLevel() {
        return level;
    }

    public String getRequest() {
        return request;
    }
}
