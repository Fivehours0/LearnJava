package DesignModel.PrototypePattern;

import java.util.Random;

/**
 * 原型模式先产生出一个包含大量共有信息的类， 然后可以拷贝出副本， 修正细节信息，
 * 建立了一个完整的个性对象。 不知道大家有没有看过施瓦辛格演的《第六日》 这部电影， 电
 * 影的主线也就是一个人被复制， 然后正本和副本对掐。 我们今天讲的原型模式也就是由一个
 * 正本可以创建多个副本的概念。 可以这样理解： 一个对象的产生可以不由零起步， 直接从一
 * 个已经具备一定雏形的对象克隆， 然后再修改为生产需要的对象。 也就是说， 产生一个人，
 * 可以不从1岁长到2岁， 再到3岁……也可以直接找一个人， 从其身上获得DNA， 然后克隆一
 * 个， 直接修改一下就是30岁了！ 我们讲的原型模式也就是这样的功能。
 *
 * 原型模式的使用场景
 * ● 资源优化场景
 * 类初始化需要消化非常多的资源， 这个资源包括数据、 硬件资源等。
 * ● 性能和安全要求的场景
 * 通过new产生一个对象需要非常繁琐的数据准备或访问权限， 则可以使用原型模式。
 * ● 一个对象多个修改者的场景
 * 一个对象需要提供给其他对象访问， 而且各个调用者可能都需要修改其值时， 可以考虑
 * 使用原型模式拷贝多个对象供调用者使用。
 * <p>
 * 在实际项目中， 原型模式很少单独出现， 一般是和工厂方法模式一起出现， 通过clone的
 * 方法创建一个对象， 然后由工厂方法提供给调用者。 原型模式已经与Java融为一体， 大家可以随手拿来使用。
 *
 *
 * 原型模式的优点
 * ● 性能优良
 * 原型模式是在内存二进制流的拷贝， 要比直接new一个对象性能好很多， 特别是要在一
 * 个循环体内产生大量的对象时， 原型模式可以更好地体现其优点。
 * ● 逃避构造函数的约束
 * 这既是它的优点也是缺点， 直接在内存中拷贝， 构造函数是不会执行的
 * 优点就是减少了约束， 缺点也是减少了约束(我理解这个约束可以有对变量的约束，比如限制类变量的范围，
 * 类变量不能为负，为负就赋值0)， 需要大家在实际应用时考虑。
 */
public class Client {
    public static void main(String[] args) {
        int count = 6;
        Mail mail = new Mail(new AdvTemplate());
        mail.setTitle("xx银行版权所有");
        while (count-- > 0) {
            // 克隆一个对象，克隆则要注意深浅拷贝的问题
            /*
             * 对象克隆
             *
             * 对每个类，都需要做出下列判断：
             * 1）默认的clone方法是否满足要求
             * 2）默认的clone方法是否能够通过调用可变子对象的clone得到修补
             * 3）是否不应该使用clone
             *
             * 实际上，选项3是默认的。如果选择1或2，类必须：
             * 1）实现Cloneable接口
             * 2）使用public访问修饰符重新定义clone方法。
             *
             * 即使clone的默认实现（浅拷贝）能够满足需求，也应该实现Cloneable接口，将clone重定义为public，并调用super.clone()
             *
             * 最好不要使用clone操作，因为申明为public后，其子类也可以使用父类的clone，如果子类没有重写父类的方法，并且类的调用者在不知情的
             * 情况下调用了clone方法，则调用的是父类的clone方法，如果子类中也定义了对象引用变量，则不会进行深拷贝，因为父类中的clone没有写子
             * 类中的对象引用的clone。容易导致出错。
             */
            Mail cloneMail = mail.clone();
            cloneMail.setName(getRandomString(3));
            cloneMail.setEmail(getRandomString(5) + "@" + getRandomString(7));
            sendEmail(cloneMail);
        }
    }

    public static void sendEmail(Mail mail) {
        System.out.println(mail.getTitle() + "  发送至" + mail.getName() + "  email: " + mail.getEmail() + "...发送成功");
    }

    public static String getRandomString(int len) {
        String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();
    }
}
