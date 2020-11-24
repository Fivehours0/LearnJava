package DesignModel.VisitorPattern;

public abstract class Element {
    public abstract void doSomething();
    public abstract void accept(IVisitor visitor);
}

class ConcreteElement1 extends Element {

    @Override
    public void doSomething() {
        System.out.println("1");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class  ConcreteElement2 extends Element {

    @Override
    public void doSomething() {
        System.out.println(2);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}