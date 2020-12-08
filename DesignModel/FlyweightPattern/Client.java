package DesignModel.FlyweightPattern;

/**
 * 享元模式（Flyweight Pattern） 是池技术的重要实现方式， 其定义如下： Use sharing to
 * support large numbers of fine-grained objects efficiently.（使用共享对象可有效地支持大量的细
 * 粒度的对象。 ）
 *
 * 抽象出对象的共有特性，比如这里的key，是由科目和考试地点组成的，科目总共只有4个科目，考试地点30个，所以根据这个信息，组成120个对象，放入
 * 对象池中(可以类比线程池)，这样就避免了大量的对象创建，减小了垃圾回收器的负担，以及创建对象销毁对象的负担。
 *
 * 享元模式的优点和缺点
 * 享元模式是一个非常简单的模式， 它可以大大减少应用程序创建的对象， 降低程序内存
 * 的占用， 增强程序的性能， 但它同时也提高了系统复杂性， 需要分离出外部状态和内部状
 * 态， 而且外部状态具有固化特性， 不应该随内部状态改变而改变， 否则导致系统的逻辑混
 * 乱。
 *
 *
 * 享元模式的使用场景
 * 在如下场景中则可以选择使用享元模式。
 * ● 系统中存在大量的相似对象。
 * ● 细粒度的对象都具备较接近的外部状态， 而且内部状态与环境无关， 也就是说对象没
 * 有特定身份。
 * ● 需要缓冲池的场景。
 *
 * 外部状态最好以Java的基本
 * 类型作为标志， 如String、 int等， 可以大幅地提升效率。
 */
public class Client {
    public static void main(String[] args) {
        //初始化对象池
        for(int i=0;i<4;i++){
            String subject = "科目" + i;
            //初始化地址
            for(int j=0;j<30;j++){
                String key = subject + "考试地点"+j;
                SignInfoFactory.getSignInfo(key);
            }
        }
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");
    }
}