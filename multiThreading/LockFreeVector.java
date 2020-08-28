package multiThreading;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class LockFreeVector<E> {
    private static final boolean debug = false;
    private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;
    private final AtomicReference<Descriptor<E>> descriptor;
    // 第一个桶的大小
    private final int FIRST_BUCKET_SIZE = 8;
    public LockFreeVector () {
        // 桶的数量
        int n_BUCKETS = 30;
        this.buckets = new AtomicReferenceArray<AtomicReferenceArray<E>>(n_BUCKETS);

        this.buckets.set(0, new AtomicReferenceArray<E>(FIRST_BUCKET_SIZE));
        this.descriptor = new AtomicReference<Descriptor<E>>(new Descriptor<E>(0, null));
    }

    public void push_back (E e) {
        Descriptor<E> desc;
        Descriptor<E> newDesc;

        do {
            desc = descriptor.get();
            desc.completeWrite();

            int pos = desc.size + FIRST_BUCKET_SIZE;
            int zeroNumPos = Integer.numberOfLeadingZeros(pos);
            int zeroNumFirst = Integer.numberOfLeadingZeros(FIRST_BUCKET_SIZE);
            int bucketInd = zeroNumFirst - zeroNumPos;
            if (buckets.get(bucketInd) == null) {
                int len = 2 * buckets.get(bucketInd - 1).length();
                if (debug) System.out.println("new len: " + len);
                buckets.compareAndSet(bucketInd, null, new AtomicReferenceArray<>(len));
            }
            int idx = (0x80000000>>>zeroNumPos) ^ pos;// 元素插入的位置
            newDesc = new Descriptor<E>(desc.size + 1, new WriteDescriptor<>(buckets.get(bucketInd), idx, null, e));
        } while (!descriptor.compareAndSet(desc, newDesc));
        descriptor.get().completeWrite();
    }

    public E get (int index) {
        Descriptor<E> desc = descriptor.get();
        int pos = index + FIRST_BUCKET_SIZE;
        int zeroNumGet =Integer.numberOfLeadingZeros(pos);
        int zeroNumFirst = Integer.numberOfLeadingZeros(FIRST_BUCKET_SIZE);

        int bucketInd = zeroNumGet - zeroNumFirst;
        int idx = (0x80000000>>>zeroNumGet) ^ pos;

        return buckets.get(bucketInd).get(idx);
    }

    public void insert (int index, E value) {

    }

    private static  class Descriptor<E> {
        private int size = 0;
        volatile WriteDescriptor<E> writer;

        public Descriptor (int size, WriteDescriptor<E> writer) {
            this.size = size;
            this.writer = writer;
        }

        public void completeWrite () {
            WriteDescriptor<E> tmp = writer;
            if (tmp != null) {
                tmp.doIt();
                writer = null;
            }
        }
    }

    private static class WriteDescriptor<E> {
        private AtomicReferenceArray<E> addr;
        private E oldV;
        private E newV;
        private int addrInt; // 使用的是第几个桶

        public WriteDescriptor (AtomicReferenceArray<E> addr, int addrInt, E oldV, E newV) {
            this.addr = addr;
            this.addrInt = addrInt;
            this.oldV = oldV;
            this.newV = newV;
        }

        public void doIt () {
            addr.compareAndSet(addrInt, oldV, newV);
        }
    }

    public static void main(String[] args) {
        LockFreeVector<Integer> v = new LockFreeVector<>();
        for (int i = 0; i < 9; i++) {
            v.push_back(i);
        }
        System.out.println(v.buckets);
        System.out.println(v.get(1));
//        Vector<Integer> vector = new Vector<>();
//        System.out.println(vector.capacity());
//        for (int i = 0; i < 10; i++) {
//            vector.add(i);
//        }
//        System.out.println(vector.capacity());
//        for (int i = 0; i < 11; i++) {
//            vector.add(i);
//        }
//        System.out.println(vector);
    }
}

