package DataStructure;

import java.util.*;

public class Test {
    public void test(String data) {
        Deque<Integer> save = new LinkedList<>();
        String newData = data.substring(0, data.length()-1);
        System.out.println("null".equals(newData));
//        Integer.parseInt()
    }
    public static void main(String[] args) {
        new Test().test("adadad");
//        SortedSet<Integer> sortedByDes = new TreeSet<Integer>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return a.compareTo(b);
//            }
//        });
    }
}
