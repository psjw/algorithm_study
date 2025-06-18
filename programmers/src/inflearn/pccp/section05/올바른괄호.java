package inflearn.pccp.section05;

import java.util.Stack;

public class 올바른괄호 {

    public static void main(String[] args) {
        System.out.println(solution("(())()"));
        System.out.println(solution("()()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    private static boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '(' && currentChar == ')') {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        if (stack.isEmpty()) {
            answer = true;
        }
        return answer;
    }

}
