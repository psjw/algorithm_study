package inflearn.pccp.section05;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class 프로세스_풀이 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }


    private static int solution(int[] priorities, int location) {
        // [2, 1, (3), 2]
        // 2 [1, (3), 2]
        // [1, (3), 2, 2]
        // 1 [(3), 2, 2]
        // [(3), 2, 2, 1]
        // (3) [2, 2, 1] : 1번째 출력  ==> 1

        // [(1), 1, 9, 1, 1, 1]
        // (1) [1, 9, 1, 1, 1]
        // [1, 9, 1, 1, 1, (1)]
        // 1 [9, 1, 1, 1, (1)]
        // [9, 1, 1, 1, (1), 1]
        // 9 [1, 1, 1, (1), 1] : 1번째 출력
        // 1 [1, 1, (1), 1] : 2번째 출력
        // 1 [1, (1), 1] : 3번째 출력
        // 1 [(1), 1] : 4번째 출력
        // (1) [1] : 5번째 출력 ==> 5

        List<Paper> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Paper(priorities[i], i == location));
        }

        int answer = 0;
        while(!queue.isEmpty()){
            Paper now = queue.remove(0);
            boolean printable = true;
            for(Paper p : queue) {
                if(now.priority < p.priority){
                    printable = false;
                    break;
                }
            }

            if(!printable){
                queue.add(now);
                continue;
            }

            answer++;
            if(now.isMine) return answer;

        }

        return answer;
    }

    static class Paper{
        int priority;
        boolean isMine;

        public Paper(int priority, boolean isMine) {
            this.priority = priority;
            this.isMine = isMine;
        }
    }
}
