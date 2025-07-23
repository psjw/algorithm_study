package inflearn.pccp.section04;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SetMain {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        if(!list.contains(1))  list.add(1);
        if(!list.contains(2))  list.add(2);
        if(!list.contains(3))  list.add(3);

        System.out.println(list);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set);

        HashSet<MyData> set1 = new HashSet<>(); //set은 순서를 보장하지 않는다.
        set1.add(new MyData(1));
        set1.add(new MyData(2));
        set1.add(new MyData(3));


        set1.add(new MyData(1));
        set1.add(new MyData(2));
        set1.add(new MyData(3));

        System.out.println("set1 = " + set1);

        HashSet<MyData> setA = new HashSet<>(); //set은 순서를 보장하지 않는다.
        HashSet<MyData> setB = new HashSet<>(); //set은 순서를 보장하지 않는다.

        setA.add(new MyData(1));
        setA.add(new MyData(2));
        setA.add(new MyData(3));


        setB.add(new MyData(2));
        setB.add(new MyData(3));
        setB.add(new MyData(4));

        // A+B
//        setA.addAll(setB);
//        System.out.println("setA = " + setA);

        //A-B
//        setA.removeAll(setB);
//        System.out.println("setA = " + setA);

        //A교집합B
        setA.retainAll(setB);
        System.out.println("setA = " + setA);


    }
}

class MyData{
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "v=" + v +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyData)) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(v);
    }
}
