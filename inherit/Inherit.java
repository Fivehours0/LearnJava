package inherit;
// 如果子类和父类在同一个包下，那么对于父类的成员修饰符只要不是私有的private，那子类就可以使用
// 如果不在同一个包下，子类只能使用父类中protected和public修饰的成员
// 多层继承，子类可以调用子类之上的所有父类层级

class Circle {

    double radius = 1;

    Circle(int radius) { // 构造函数
        this.radius = radius;
        System.out.print("int");
    }

    Circle(double radius) { // 构造函数
        this.radius = radius;
        System.out.print("double");
    }

    public double getRadius() { // JavaBean
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return 3.14 * this.radius * this.radius;
    }
}

class Cylinder extends Circle{ // 继承Circle类
    double length = 1;
    Cylinder(double length, double radius) {
        // 当父类中有两个只有1个形参的构造函数时， 他会根据super括号中的数据类型选择调用哪个构造函数
        // 当父类有两个形参的构造函数，子类也必须有
        super(300); // this是调用本类的构造函数，super调用的是父类的，必须写第一行
        this.length = length;
    }

    // 子类重写父类的方法，只是重写编写方法体的代码，即不能修改形参，返回类型等
    // 重写方法不能使用比被重写方法更严格的访问权限(指的是public)

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolumn() {
        return findArea() * this.length;
    }

}

/**
 * 关键词static修饰的成员具有一下特点：
 * 随着类的加载而加载，不需要创建对象
 * 优先于对象存在
 * 修饰的成员，被所有对象所共享
 * 访问权限允许时，可不创建对象，直接被类调用
 */
class staticUsing{
    // static为静态变量，不需要进行实例化。直接使用类名.属性名就可以使用，所有类的实例化对象都共享。
    static String circleNation;
    // 在未来的开发中，可能会多次使用这一判断，那么从大量次数的基础上看，就发现代码的重复次数很多了，所以我们把代码做成工具类做成一个方法
    // 因为不需要实例就可以访问static方法，因此static方法内部不能有this，也不能有super
    public static boolean isEmpty(String str) {
        boolean flag = false;
        if (str == null || str == "") {
            flag = true;
        }
        return flag;
    }

    // 用于对创建对象的个数计数
    public static int count = 0;
    // 无参数构造函数中计数相加
    staticUsing(){
        staticUsing.count += 1;
    }
    // 计数显示
    public static void showCount(){
        System.out.println(count);
    }

    public static void main(String[] args) {
        staticUsing sta1 = new staticUsing();
        staticUsing sta2 = new staticUsing();
        System.out.println(staticUsing.count);
    }
}

public class Inherit {
    public static void main(String[] arg){
        double area;
        double volumn;

        Cylinder cylinder = new Cylinder(20, 20);
        area = cylinder.findArea();
        volumn = cylinder.findVolumn();
        System.out.println(area);
        System.out.println(volumn);

        Circle circle = cylinder; // 从子类到父类的类型转换可以自动进行
        cylinder = (Cylinder) circle; // 从父类到子类的类型转换需要强制类型转换实现
        // 包装类
        float f = Float.intBitsToFloat(1092616192);
        System.out.println(f);
        // String name = "duzhihui";
        // System.out.println();
        /* 对于对象来说，特殊的类，如String，File。Data，使用==比较的是对象(对象的地址)，equals比较的是内容
        除了特殊的类之外的其它普通的类的对象，==和equals比较的都是对象(对象的内存地址)
        如果你想改变某一个类的equals，不想用equals来比较对象的内存地址，就需要重写equals*/
         
    }
}