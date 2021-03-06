package DesignModel.VisitorPattern;

public interface IVisitor {
    public void visit(ConcreteElement1 element);
    public void visit(ConcreteElement2 element);
}

class Visitor implements IVisitor {

    @Override
    public void visit(ConcreteElement1 element) {
        element.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 element) {
        element.doSomething();
    }
}
