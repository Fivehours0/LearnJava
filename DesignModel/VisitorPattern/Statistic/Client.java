package DesignModel.VisitorPattern.Statistic;

// 增加统计的功能
public class Client {
    public static void main(String[] args) {
        IVisitor visitor = new Visitor();
        for (Employee emp : mockEmployee()) {
            emp.accept(visitor);
        }
        System.out.println("本公司的月工资总额是： " + visitor.getTotalSalary());
    }
}
