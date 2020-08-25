/**
 * 对象克隆
 *
 * 对每个类，都需要做出下列判断：
 * 1）默认的clone方法是否满足要求
 * 2）默认的clone方法是否能够通过调用可变子对象的clone得到修补
 * 3）是否不应该使用clone
 *
 * 实际上，选项3是默认的。如果选择1或2，类必须：
 * 1）实现Cloneable接口
 * 2）使用public访问修饰符重新定义clone方法。
 *
 * 即使clone的默认实现（浅拷贝）能够满足需求，也应该实现Cloneable接口，将clone重定义为public，并调用super.clone()
 *
 * 最好不要使用clone操作，因为申明为public后，其子类也可以使用父类的clone，如果子类没有重写父类的方法，并且类的调用者在不知情的情况下调用了
 * clone方法，则调用的是父类的clone方法，如果子类中也定义了对象引用变量，则不会进行深拷贝，因为父类中的clone没有写子类中的对象引用的clone。容易导致出错。
 */
class Person implements Cloneable {
    int number;
    String teamName;
    Info info;

    public Person (int number, String teamName, String name, int age) {
        this.info = new Info(name, age);
        this.number = number;
        this.teamName = teamName;
    }

    private class Info implements Cloneable {
        String name;
        int age;

        private Info (String name, int age) {
            this.name = name;
            this.age = age;
        }

        // 即使clone的默认实现（浅拷贝）能够满足需求，也应该实现Cloneable接口，将clone重定义为public，并调用super.clone()
        public Info clone () throws CloneNotSupportedException {
            return (Info) super.clone();
        }
    }

    // 即使clone的默认实现（浅拷贝）能够满足需求，也应该实现Cloneable接口，将clone重定义为public，并调用super.clone()
    public Person clone () throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.info = (Info) info.clone(); // 如果不对clone进行拷贝，则默认拷贝的是info的地址
        return person;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person(1, "ball", "d", 18);
        Person p2 = (Person) p1.clone();
        System.out.println(p2.info.equals(p1.info));
    }
}

class BadPerson extends Person {
    int height;
    InBadPerson inBadPerson;

    private class InBadPerson {
        int inHeight;

        public InBadPerson (int inHeight) {
            this.inHeight = inHeight;
        }
    }

    public BadPerson(int number, String teamName, String name, int age, int height) {
        super(number, teamName, name, age);
        this.height = height;
        this.inBadPerson = new InBadPerson(height);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        BadPerson b = new BadPerson(1, "a", "a", 18, 199);
        BadPerson b1 = (BadPerson) b.clone();
        System.out.println(b1.inBadPerson.equals(b.inBadPerson));
    }
}