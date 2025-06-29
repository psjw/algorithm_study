package inflearn.pccp.section07;

import java.util.ArrayList;
import java.util.Arrays;

public class 제일작은수제거하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(solution(new int[]{10})));
    }
    static int[] solution(int[] arr) {
        int[] answer = {};
        int min = Integer.MAX_VALUE;
        if(arr.length == 1) {
            answer = new int[]{-1};
            return answer;
        }

        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
        }
        answer = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(min < arr[i]){
                answer[index] = arr[i];
                index++;
            }
        }


        return answer;
    }
}
