package inflearn.pccp.section09;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class 더맵게 {
    public static void main(String[] args) {
//        섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[]{5,5,5,5,5}, 4));
    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            minHeap.offer(scoville[i]);
        }
        int currentK = 0;
        while(!minHeap.isEmpty()){
            int first = minHeap.poll();
            if(first >= K){
                break;
            }
            if(minHeap.isEmpty()){
                return -1;
            }
            if(first <  K){
                int second = minHeap.poll();
                currentK = first + (second * 2);
                answer++;
                minHeap.offer(currentK);
            }
            System.out.println(minHeap);
        }

        return answer;
    }
}
