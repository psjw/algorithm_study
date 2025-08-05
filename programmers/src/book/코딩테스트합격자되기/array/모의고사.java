package book.코딩테스트합격자되기.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalInt;

public class 모의고사 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    private static int[] solution(int[] answers) {
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) {
                map.put(1, map.getOrDefault(1, 0) + 1);
            }
            if (two[i % two.length] == answers[i]) {
                map.put(2, map.getOrDefault(2, 0) + 1);
            }

            if (three[i % three.length] == answers[i]) {
                map.put(3, map.getOrDefault(3, 0) + 1);
            }
        }
        int max = map.values().stream().mapToInt(x -> x).max().getAsInt();
        return map.entrySet().stream().filter(x -> x.getValue() == max).mapToInt(x -> x.getKey()).toArray();
    }
}
