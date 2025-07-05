package inflearn.pccp.section09;

import java.util.*;

class MyData implements Comparable<MyData> {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.valueOf(v);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MyData myData = (MyData) object;
        return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(v);
    }

    @Override
    public int compareTo(MyData o) {
        return Integer.compare(this.v, o.v);
    }
}

class MyData2 implements Comparable<MyData2> {
    int  a;
    int  b;

    public MyData2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(MyData2 o) {
        return Integer.compare(this.b, o.b);
    }

    @Override
    public String toString() {
        return "MyData2{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

public class Tree {
    public static void main(String[] args) {
        // BST /Heap
        Set<Integer> set = new HashSet<>();  //hashtable -> Binary Search Tree
        set.add(1);
        set.add(2);
        set.add(3);

        set.add(1); // 값이 존재하는 빠르게 확인하고 있기 때문s
        set.add(2);
        set.add(3);

        System.out.println("set1 = " + set);


        // BST /Heap
        Set<MyData> set1 = new HashSet<>();  //hashCode 구현
        set1.add(new MyData(1));
        set1.add(new MyData(2));
        set1.add(new MyData(3));

        set1.add(new MyData(1));
        set1.add(new MyData(2));
        set1.add(new MyData(3));

        System.out.println("set1 = " + set1);


        // BST /Heap
        Set<MyData> set2 = new TreeSet<>();  //대소 관계를 이용해서 값을 찾아내므로 Comparable
        set2.add(new MyData(1));
        set2.add(new MyData(2));
        set2.add(new MyData(3));

        set2.add(new MyData(1));
        set2.add(new MyData(2));
        set2.add(new MyData(3));

        System.out.println("set1 = " + set2);

        //Heap
        Queue<Integer> pq = new PriorityQueue<>(); //min Heap
        pq.offer(100);
        pq.offer(60);
        pq.offer(1);
        pq.offer(30);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());


        Queue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder()); //max Heap
        pq1.offer(100);
        pq1.offer(60);
        pq1.offer(1);
        pq1.offer(30);

        System.out.println(pq1.poll());
        System.out.println(pq1.poll());
        System.out.println(pq1.poll());
        System.out.println(pq1.poll());


        // Sort(NlogN) / O(longN)
        Queue<Integer> pq2 = new PriorityQueue<>(); //max Heap 최대값(최소값)유지
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            pq2.offer(r.nextInt(50));
        }
        System.out.println("pq2 = " + pq2);

        List<Integer> sorted = new LinkedList<>();
        while (!pq2.isEmpty()) {
            sorted.add(pq2.poll()); //Heap 정렬
        }
        System.out.println("sorted = " + sorted);


        // Sort(NlogN) / O(longN)
        Queue<MyData> pq3 = new PriorityQueue<>(); //max Heap 최대값(최소값)유지
        Random r2 = new Random();
        for (int i = 0; i < 20; i++) {
            pq3.offer(new MyData(r2.nextInt(50)));
        }
        System.out.println("pq2 = " + pq3);

        List<MyData> sorted1 = new LinkedList<>();
        while (!pq3.isEmpty()) {
            sorted1.add(pq3.poll()); //Heap 정렬
        }
        System.out.println("sorted = " + sorted1);

        TreeSet<MyData2>treeSet = new TreeSet<>();
        treeSet.add(new MyData2(1, 2));
        treeSet.add(new MyData2(2, 2));
        System.out.println("treeSet = " + treeSet);
    }
}
