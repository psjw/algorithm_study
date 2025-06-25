package inflearn.pccp.section05;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격_풀이 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int seconds = 0;
            for (int j = i + 1; j < prices.length; j++) {
                seconds++;
                if (price > prices[j]) break;
            }
            answer[i] = seconds;
        }
        return answer;
    }
}
