package inflearn.pccp.section05;

import java.util.ArrayDeque;

public class 프로세스 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }


    private static int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < priorities.length; i++) {
            if(priorities[i] > max) {
                max = priorities[i];
            }
        }
        for (int i = 0; i < priorities.length; i++) {
            queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            int priority = priorities[idx];
            if (max > priority) {
                queue.addLast(idx);
            } else {
                answer++;
                max = 0;

                if (location == idx) {
                    break;
                }
                priorities[idx] = -1;
                for (int j = 0; j < priorities.length; j++) {
                    if(priorities[j] > max) {
                        max = priorities[j];
                    }
                }
            }
        }
        return answer;
    }

}
