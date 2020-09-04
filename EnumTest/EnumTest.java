package EnumTest;

/**
 * 枚举类
 * 有的类只有4个对象就可以描述完成，比如季节只有春夏秋冬
 * 枚举类也可以拓展接口
 */
enum Season{
    SPRING("春天", "鸟语花香"), // 调用的是Season构造方法
    SUMMER("夏天", "烈日炎炎"),
    AUTUMN("秋天", "落叶缤纷"),
    WINTER("冬天", "银装素裹");

    private final String NAME;
    private final String DESCRIBE;

    private Season(String name, String describe){
        this.NAME = name;
        this.DESCRIBE = describe;
    }

    public void showInfo(){
        System.out.println(this.NAME + "  " + this.DESCRIBE);
    }
}

public class EnumTest{
    public static void main(String[] args) {
        Season spring = Season.SPRING; // 调用枚举构造，返回一个枚举对象
        Season autumn = Enum.valueOf(Season.class, "AUTUMN"); // 创建枚举对象的另一种方法

        spring.showInfo();
        autumn.showInfo();

        Season spring1 = Season.SPRING;
        System.out.println(spring.toString()); // 输出 SPRING

        // 返回的是True，每次执行Season.SPRING获得的是相同的对象，枚举类中的每个枚举都是单例模式的
        System.out.println(spring.equals(spring1));
    }
}
