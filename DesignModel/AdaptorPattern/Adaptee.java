package DesignModel.AdaptorPattern;

/**
 * Adaptee源角色
 * 你想把谁转换成目标角色， 这个“谁”就是源角色， 它是已经存在的、 运行良好的类或对
 * 象， 经过适配器角色的包装， 它会成为一个崭新、 靓丽的角色。
 */
public class Adaptee {
    public char[] doSomething () {
        return new char[] {'d','o','s','o','m','e','t','h','i','n','g'};
    }
}
