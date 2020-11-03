package LearnSpring.demo;

public class User {
    private String name;
    private String address;

    public void add() {
        System.out.println("add......");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public User() {

    }

    public User(String name) {
        this.name = name;
    }
}
