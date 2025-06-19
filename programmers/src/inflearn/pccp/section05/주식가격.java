package inflearn.pccp.section05;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i];
            while (!stack.isEmpty() && temp < prices[stack.peek()]) {
                Integer index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            answer[index] = (prices.length) - index - 1;
        }
        return answer;
    }
}
