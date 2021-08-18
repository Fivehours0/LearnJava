package LearnJVM;

import java.util.ArrayList;

/**
 * @author duzhihui
 * @date 7.8
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8
 * 总共是60m，新生代：老年代   2：8    这个比例用newRatio控制。默认为2，老年代占2份。  幸存者01和eden为1：1：8  则分别为2m, 2m, 16m
 * 对调优参数的测试  jstat -gc id
 */
public class GCTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            byte[] arr = new byte[1024 * 100]; // 100kb
            list.add(arr);
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
