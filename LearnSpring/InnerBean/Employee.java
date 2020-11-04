package LearnSpring.InnerBean;

public class Employee {
    private String name;
    private Department department;

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department name=" + department.getName() +
                '}';
    }
}
