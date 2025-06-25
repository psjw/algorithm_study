package inflearn.pccp.section05;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발_풀이 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
//        System.out.println(Arrays.toString(solution(new int[]{85, 80, 90, 85}, new int[]{5, 5, 5, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
//        System.out.println(Arrays.toString(solution(new int[]{95, 95, 95, 95}, new int[]{4, 3, 2, 1})));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        // [93,30,55], [1,30,5]
        // [7, 3, 9]
        // [2, 1]
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            float p = progresses[i];
            float s = speeds[i];
            int days = (int) Math.ceil((100 - p) / s);
            queue.offer(days);
        }
        // [7, 3, 9]
        Queue<Integer> answer = new LinkedList<>();
        int d = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            Integer n = queue.poll();
            if (d > n) {
                count++;
                continue;
            }
            answer.offer(count);
            count = 1;
            d = n;
        }


        answer.offer(count);
        // [2, 1]
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}
