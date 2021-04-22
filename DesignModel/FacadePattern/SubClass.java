package DesignModel.FacadePattern;

/**
 * 这3个类属于近邻， 处理相关的业务， 因此应该被认为是一个子系统的不同逻
 * 辑处理模块，(比如在书中，作者记录了邮件系统，A系统可以表示邮件公司，公司承包邮件编辑以及发送工作，
 * B系统表示警察检查系统，警察需要对邮件内容进行检查。AB均为邮件系统的子系统) 对于此子系统的访问需要通过门面进行，
 */
class ClassA {
    public void doSomethingA(){
        //业务逻辑
    }
}

class ClassB {
    public void doSomethingB(){
        //业务逻辑
    }
}

class ClassC {
    public void doSomethingC(){
        //业务逻辑
    }
}
