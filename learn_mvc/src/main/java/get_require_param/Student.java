package get_require_param;

// 使用类的方式，保存请求参数

public class Student {

    //属性名和请求中参数名一样
    private String msg;
    private Integer fun;

    public Student() {
        System.out.println("无参构造方法");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        System.out.println("setMsg:" + msg);
        this.msg = msg;
    }

    public Integer getFun() {
        return fun;
    }

    public void setFun(Integer fun) {
        System.out.println("setFun:" + fun);
        this.fun = fun;
    }

    @Override
    public String toString() {
        return "Student{" +
                "msg='" + msg + '\'' +
                ", fun=" + fun +
                '}';
    }
}
