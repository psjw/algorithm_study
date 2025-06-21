package inflearn.pccp.section05;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 기능개발 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
//        System.out.println(Arrays.toString(solution(new int[]{85, 80, 90, 85}, new int[]{5, 5, 5, 5})));
//        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{95, 95, 95, 95}, new int[]{4, 3, 2, 1})));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int maxDay = (int)Math.ceil((100 - progresses[0]) / (double) speeds[0]);
        int count = 1;
        for (int i = 1; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int remainsDay =  (int)Math.ceil((100 - progress) / (double) speed);
            if (maxDay >= remainsDay) {
                count++;
            } else {
                maxDay = remainsDay;
                queue.add(count);
                count = 1;
            }

        }
        if (count > 0) {
            queue.add(count);
        }

        return queue.stream().mapToInt(i -> i).toArray();
    }
}
