package inflearn.pccp.section04;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어_풀이 {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        solution(new int[]{4, 4, 4, 3, 3});
    }

    public static int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int last = -1;
        for (int j : arr) {
            if (last == j) continue;
            last = j;
            list.add(j);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
