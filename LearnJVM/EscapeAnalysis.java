package LearnJVM;

/**
 * 逃逸分析
 * 如何快速判断是否发生了逃逸分析，就看new的对象是否有可能在方法外被调用
 *
 */
public class EscapeAnalysis {

    public EscapeAnalysis obj;

    /*
     方法返回EscapeAnalysis对象，发生逃逸
     */
    public EscapeAnalysis getInstance () {
        return obj==null ? new EscapeAnalysis() : obj;
    }

    /*
    为成员属性赋值
    思考：如果当前的obj引用申明为static，还会发生逃逸吗？仍然会发生逃逸(会被其他方法调用)
     */
    public void setObj () {
        this.obj = new EscapeAnalysis(); // 成员属性当然有可能被其他方法中被调用，所以会发生逃逸。
    }

    /*
    对象的作用域仅在当前方法中有效，没有发生逃逸
     */
    public void useEscapeAnalysis () {
        EscapeAnalysis e = new EscapeAnalysis();
    }

    /*
    引用成员变量的值，发生逃逸
     */
    public void useEscapeAnalysis1 () {
        EscapeAnalysis e = getInstance(); // 获得的实例对象本身就是外边的，这个实例对象可能被其他方法调用
    }
}
