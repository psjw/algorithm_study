package inflearn.pccp.section05;

import java.util.Stack;

public class 올바른괄호_풀이 {
    public static void main(String[] args) {
        System.out.println(solution("(())()"));
        System.out.println(solution("()()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static boolean solution1(String s) {
        int stack =0 ;
        for (Character c : s.toCharArray()) {
            if (c == '(') stack++;
            else {
                if (stack == 0) return false;
                stack--;
            }
        }
        return stack == 0;
    }
}
