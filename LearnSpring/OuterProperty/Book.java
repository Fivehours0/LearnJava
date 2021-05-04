package OuterProperty;

public class Book {
    String name;
    int ID;

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
