package set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Person implements Comparator<Person> {
    String name;
    int age;
    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        // TODO Auto-generated method stub
        if(o1.age > o2.age) {
            return 1;
        } else if(o1.age < o2.age) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class CollectionUsing{
    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.add(2);
//        arrayList.add(1);
//        System.out.println(arrayList);
//        Collections.reverse(arrayList); // 反转
//        Collections.shuffle(arrayList); // 随机排列
//        Collections.sort(arrayList); // 自然排序升序
//        Collections.swap(arrayList, 0, 1); // 交换0，1两个元素
//        System.out.println(Collections.max(arrayList)); // 返回最大值
//        System.out.println(Collections.min(arrayList)); // 返回最小值
//        System.out.println(Collections.frequency(arrayList, 1)); // 统计出现的次数

//        System.out.println(arrayList);

        /**
         * sort还可以传入comparator达成自然排序的目的
         */
        Person p1 = new Person("du", 18);
        Person p2 = new Person("li", 19);
        ArrayList<Person> arrayList2 = new ArrayList<>();
        arrayList2.add(p1);
        arrayList2.add(p2);

        arrayList2.sort(new Person());
        for(Person p: arrayList2){
            System.out.println(p.name + p.age);
        }
        Person pmax = Collections.max(arrayList2, new Person());
        System.out.println(pmax.name + pmax.age); // 对对象进行操作的max

        // 倒序排序
        arrayList2.sort(Collections.reverseOrder(new Person()));
        for(Person p: arrayList2){
            System.out.println(p.name + p.age);
        }

        // 第三种方法
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age > o2.age) {
                    return 1;
                } else if(o1.age < o2.age) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        arrayList2.sort(comparator);
        for(Person p: arrayList2){
            System.out.println(p.name + p.age);
        }
    }
}