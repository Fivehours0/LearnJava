package java_basic.KeyWord;
// instanceof的用法以及getClass与instanceof的区别

class Person implements IPerson {

}

class Son extends Person {

}

interface IPerson {

}

class Client {
    public static void main(String[] args) {
        Son son = new Son();
        Person person = new Person();
        System.out.println(son instanceof Person); // true
        System.out.println(person instanceof Son); // false
        System.out.println(son instanceof IPerson); // true

        System.out.println(son.getClass().equals(person.getClass())); // false
        System.out.println(son.getClass().equals(Person.class)); // false
        System.out.println(son.getClass().equals(IPerson.class)); // false
        System.out.println(person.getClass().equals(IPerson.class)); // false
    }
}