package inflearn.pccp.section07;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//왜 종류별로 알고리즘을 학습해야 하나?
//
// 1. 다양한 알고리즘을 학습하면서 : 문제풀이의 접근방식을 학습할 수 있습니다.
// 2. 문제를 해결하는 알고리즘은 한가지가 아니구나! 효율성이 달라지는 구나! 절대적인 것은 없구나!


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
    public int compareTo(MyData o) {
        return Integer.compare(this.v, o.v);
    }
}

public class Sort {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(r.nextInt(50));
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list); //오름차순
        list.sort(Comparator.reverseOrder());
        System.out.println(list); //내림차순

        //오름차순
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }
        });
        System.out.println(list);

        //내림차순
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });
        System.out.println(list);

        //내림차순
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);

        //내림차순
        list.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(list);

        List<MyData> list1 = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            list1.add(new MyData(r.nextInt(50)));
        }

        //오름차순
        list1.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o1.v - o2.v;
            }
        });
        System.out.println(list1);

        //내림차순
        list1.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o2.v - o1.v;
            }
        });
        System.out.println(list1);

        //내림차순 -> Comparable implements 해주면 됨
        list1.sort(Comparator.reverseOrder());
        System.out.println(list1);

        System.out.println("####");
        list1 = quickSort(list1);
        System.out.println("list1 = " + list1);
    }

    static List<MyData> quickSort(List<MyData> list) {
        //[5,3,8,1]
        if (list.size() <= 1) return list;
        System.out.println("in : " + list);
        MyData pivot = list.remove(0);

        List<MyData> lesser = new LinkedList<>();
        List<MyData> greater = new LinkedList<>();

        for (MyData m : list) {
            if (pivot.compareTo(m) > 0) {
                lesser.add(m);
            } else {
                greater.add(m);
            }
        }

        List<MyData> merged = new LinkedList<>();
        //오름차순
//         merged.addAll(quickSort(lesser));
//         merged.add(pivot);
//         merged.addAll(quickSort(greater));

        //내림차순
        // 최초 pivot : 5, lesser = [3,1], greater = [8]
        // lesser -> pivot : 3, lesser = [1], greater = []
        // greater -> pivot : 8 , lesser =[], greater = []

        merged.addAll(quickSort(greater));
        merged.add(pivot);
        merged.addAll(quickSort(lesser));

        return merged;
    }
}
