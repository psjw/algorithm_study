package inflearn.pccp.section06;

import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= 100; i++) list.add(i);
        System.out.println("list = " + list);

        int index = list.indexOf(63);
        System.out.println(index);

        List<Mydata> list1 = new LinkedList<>();
        for (int i = 1; i <= 100; i++) list1.add(new Mydata(i));
        int index1  = list1.indexOf(new Mydata(63));
        System.out.println(index1);


        List<Mydata> list2 = new LinkedList<>();
        Random r= new Random();
        for (int i = 1; i <= 100; i++) list2.add(new Mydata(r.nextInt(100)));

        int index2 = Collections.binarySearch(list2, new Mydata(63));
        System.out.println(index2); //정렬이 되지 않아서


        List<Mydata> list3 = new LinkedList<>();
        for (int i = 1; i <= 100; i++) list3.add(new Mydata(i));
        //정렬을 해놓다 => sort한다
        int index3 = Collections.binarySearch(list3, new Mydata(63));
        System.out.println(index3);
        System.out.println(list.get(index3));
    }


}

//search는 indexOf, contains, remove 같은 곳에 이미 구현되어 있음
//equals 가 제공될 필요가 있음
//
// 이진탐색 : Collections.binarySearch
// Comparable가 구현되어 있어야한다.
// 순서대로 정렬되어 있어야 한다.
//
//
class Mydata implements Comparable<Mydata> {
    int v;

    public Mydata(int v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Mydata mydata = (Mydata) object;
        return v == mydata.v;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(v);
    }

    @Override
    public int compareTo(Mydata o) {
        // 1 == 1 : 1 - 1 == 0 : 같다
        // 1 ? 2 : 1 - 2 == 0 : 같디
        //               < 0 : 오른쪽이 크다
        //               > 0 : 왼쪽이 크다
        return v - o.v;
    }
}

