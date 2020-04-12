package set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.Collections;


/**
 * 1.集合只能存放对象，比如你存一个int型数据放入集合中。其实它是自动转换成Interger类后存放入的，Java中每一种基本类型都有对应的引用类型
 * 2.集合存放的是多个对象的引用，对象本身还是放在堆内存中
 * 3.集合可以存放不同类型，不限数量的数据类型
 * java集合可分为set，List，Map三种大体系
 *  Set：无序。不可重复的集合
 *  List：有序，可重复的集合
 *  Map：具有映射关系的集合
 */
public class SET{

}

class HashSET{
    public static void main(String[] args) {
        HashSet<String> hashset = new HashSet<String>();
        hashset.add("dy"); // 添加元素
        hashset.add("1");
        // System.out.println(hashset);
        // hashset.remove("1"); // 移除元素
        // hashset.contains("1"); // 包含1则输出True，否则为False
        // hashset.clear(); // 清空
        Iterator<String> it = hashset.iterator();
        while(it.hasNext()){ // 如果next有值则返回True
            System.out.println(it.next());
        }
        for(Object obj: hashset){ // 把set的每一个值取出来，赋值给obj，直到循环完hashset中的所有值
            System.out.println(obj);
        }
        System.out.println(hashset.size());
    }
}

// TreeSet可以进行自然排序
class TreeSET{
    public static void main(String[] args) {
        Person p1 = new Person("dd", 18);
        Person p2 = new Person("sd", 9);
        Person p3 = new Person("qw", 1);
        Person p4 = new Person("gg", 10);
        TreeSet<Person> treeset = new TreeSet<Person>(new Person()); // 这里是有一个疑问的，为什么要new Person 
        treeset.add(p1);
        treeset.add(p2);
        treeset.add(p3);
        treeset.add(p4);
        for(Person p: treeset){
            System.out.println(p.name);
        }
    }
}

class Person implements Comparator<Person>{
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

class ArrayLIST{
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("du");
        arrayList.add("e");
        arrayList.add("d");
        arrayList.add("e");
        for(Object obj: arrayList){
            System.out.println(obj);
        }
        System.out.println(arrayList.get(2)); // 输出第二个元素
        arrayList.add(2, "a"); // 在指定位置的索引插入元素
        // arrayList.addAll(1, arrayList); // 在指定的位置插入集合而不是值
        System.out.println(arrayList.indexOf("e")); // 获取指定元素第一次出现的下标
        System.out.println(arrayList.lastIndexOf("e")); // 获取指定元素最后一次出现的下标
        arrayList.remove("du"); // 内部进行了重写，可以选择根据内容或者下标进行数据的移除
        arrayList.set(2, "u"); // 修改指定下标位置的元素值
        List<String> arrayList2 = arrayList.subList(1, 3); // 切片
        System.out.println(arrayList2);
        arrayList.size(); // 返回大小
    }
}

/**
 * 也有TreeMap，根据key值进行排序
 */
class HashMAP{
    public static void main(String[] args) {
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        hashmap.put("a", 2);
        hashmap.put("e", 1);
        hashmap.put("h", 5);
        System.out.println(hashmap);
        System.out.println(hashmap.get("e")); // 根据key得出value
        hashmap.remove("e"); // 根据键值移除元素
        hashmap.size(); // 容器大小
        hashmap.containsKey("e"); // 是否包含这个key
        hashmap.containsValue(2); // 是否包含这个value
        // hashmap.clear(); // 清空map
        Set<String> keys = hashmap.keySet(); // key集合
        hashmap.values(); // 返回值
        
        /**
         * 遍历map的两种方式
         */
        for(String key: keys){
            System.out.println(key + "=" + hashmap.get(key));
        }
        Set<Entry<String, Integer>> entry = hashmap.entrySet();
        for(Entry<String, Integer> en: entry){
            System.out.println(en.getKey() + "=" + en.getValue());
        }
    }
}

class CollectionUsing{
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(2);
        arrayList.add(1);
        System.out.println(arrayList);
        // Collections.reverse(arrayList); // 反转
        // Collections.shuffle(arrayList); // 随机排列
        // Collections.sort(arrayList); // 自然排序升序
        // Collections.swap(arrayList, 0, 1); // 交换0，1两个元素
        // System.out.println(Collections.max(arrayList)); // 返回最大值
        // System.out.println(Collections.min(arrayList)); // 返回最小值
        // System.out.println(Collections.frequency(arrayList, 1)); // 统计出现的次数

        System.out.println(arrayList);

        /**
         * sort还可以传入comparator达成自然排序的目的
         */
        Person p1 = new Person("du", 18);
        Person p2 = new Person("li", 19);
        ArrayList<Person> arrayList2 = new ArrayList<>();
        arrayList2.add(p1);
        arrayList2.add(p2);
        Collections.sort(arrayList2, new Person());
        for(Person p: arrayList2){
            System.out.println(p.name + p.age);
        }
        Person pmax = Collections.max(arrayList2, new Person());
        System.out.println(pmax.name + pmax.age); // 对对象进行操作的max


    }
}