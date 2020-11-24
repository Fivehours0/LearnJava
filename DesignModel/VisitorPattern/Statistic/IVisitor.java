package DesignModel.VisitorPattern.Statistic;

interface IVisitor {
    public void visit(CommonEmployee commonEmployee);
    public void visit(Manage manage);
    public int getTatolSalary();
}

class Visitor implements IVisitor {
    private int manageTotalSalary = 0;
    private int commonTotalSalary = 0;
    private final int MANAGE_COEFFICIENT = 5;
    private final int COMMONEMPLOYEE_COEFFICIENT = 2;

    @Override
    public void visit(CommonEmployee commonEmployee) {

    }

    @Override
    public void visit(Manage manage) {

    }

    private void calManageSalary(int salary) {
        this.manageTotalSalary += MANAGE_COEFFICIENT * salary;
    }

    private void calEmployeeSalary(int salary) {
        this.commonTotalSalary += COMMONEMPLOYEE_COEFFICIENT * salary;
    }

    @Override
    public int getTatolSalary() {
        return commonTotalSalary + manageTotalSalary;
    }
}