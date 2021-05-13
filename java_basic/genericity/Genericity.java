package java_basic.genericity;
import java.util.ArrayList;
// 泛型不可以在静态方法中使用，因为泛型需要进行实例化确定类型

public class Genericity{
    public static void main(String[] args) {

    }
}
/**
 * 泛型类，此处的T可以是A，B都行，
 * 一般使用T，type
 * @param <T>
 */
class A<T>{
    private T var;
    public void setVar(T var){
        this.var = var;
    }
    public T getVar(){
        return this.var;
    }
    public static void main(String[] args) {
        A<String> a = new A<String> ();
        a.setVar("xxxx");
        System.out.println(a.getVar());
    }
}

/**
 * 泛型接口
 * @param <T>
 */
interface IA<T>{
    T test(T t);
}
// 指定了泛型接口T的类型，不需要在初始化的时候指定
class B implements IA<String>{
	@Override
	public String test(String t) { 
		return null;
    }
    public static void main(String[] args) {
        B b = new B();
    }
}
// 需要在初始化的时候指定
class B1<T> implements IA<T> {
    @Override
    public T test(T t) {
        return null;
    }
    public static void main(String[] args) {
        B1<String> b1 = new B1<String>();
    }
}

/**
 * 泛型方法
 */
class FuncGenerity{
    public <T> void test(){ // 无返回值

    }

    public <T> T test1(T t){ // 有返回值
        return t;
    }

    public <T> void test2(T... t){
        for(T t1: t){
            System.out.println(t1);
        }
    }

    public <T extends Comparable<T>> void min (T a, T b) { // 限定了参数a，b必须为实现了Comparable接口的变量

    }
    
    public static void main(String[] args) {
        System.out.println(new FuncGenerity().test1("du")); // 会根据参数自动确定泛型类型
        new FuncGenerity().<String>test(); // 需要指定泛型类型
    }
}

/**
 * 泛型通配符，集合的泛化
 */
class SetGenerity{
    public void test(ArrayList<?> arrayList){
        for(Object value : arrayList) {
            System.out.println(value);
        }
    }
    public void test1(ArrayList<? extends C> arrayList){}// ArrayList参数元素数据类型为C以及C的子类
    public void test3(ArrayList<? super D> arrayList){} // ArrayList参数元素数据类型为D以及D的父类
    public void test2(ArrayList<? extends IB> arrayList){} // ArrayList参数元素数据类型为IB的实现类，IB为接口 
    
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<C> arrayList1 = new ArrayList<>();
        ArrayList<D> arrayList2 = new ArrayList<>();
        ArrayList<CB> arrayList3 = new ArrayList<>();
        SetGenerity setGenerity = new SetGenerity();
        setGenerity.test(arrayList); // 各种基本类型
        setGenerity.test1(arrayList1);
        setGenerity.test1(arrayList2); // 类及其子类
        setGenerity.test2(arrayList3); // 接口的实现类
        setGenerity.test3(arrayList2); // 类及其父类
    }
}

interface IB{

}

class CB implements IB{

}

class C{

}

class D extends C{

}
