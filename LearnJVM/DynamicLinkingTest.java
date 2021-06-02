package LearnJVM;

// 编译好之后，在out文件夹相应的目录下执行javap -v DynamicLinkingTest.class 可以查看字节码文件内容
// 在run - edit configurations中的 VM options中输入
// -Xms200m -Xmx200m -XX:MetaspaceSize=300m -XX:MaxMetaspaceSize=300m -XX:+PrintGCDetails可以输出垃圾回收的具体信息

public class DynamicLinkingTest {
    int num = 10;
    String s1 = "av";
    String s2 = s1 + "sd";

    public void methodA() {
        System.out.println("methodA()....");
    }

    public void methodB() {
        System.out.println("methodB()....");
        methodA();
        num++;
    }
}
