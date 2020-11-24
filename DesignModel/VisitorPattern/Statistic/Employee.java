package DesignModel.VisitorPattern.Statistic;

public abstract class Employee {
    private int salary;
    private String job;

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}

class CommonEmployee extends Employee {

}

class Manage extends Employee {

}
