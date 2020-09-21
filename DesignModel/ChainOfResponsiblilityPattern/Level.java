package DesignModel.ChainOfResponsiblilityPattern;

// 制定需求等级
public enum  Level {
    DIFF ("Diff", "difficult problem"),
    NORMAL ("Normal", "normal problem"),
    EASY ("Easy", "easy problem");

    private String name = "";
    private String describe = "";

    Level (String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    public void showInfo(){
        System.out.println(this.name + "  " + this.describe);
    }
}
