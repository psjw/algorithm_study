package inflearn.pccp.section08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 단어변환풀이 {

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
//        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
//        System.out.println(solution("AAAA", "AABB", new String[]{"AABA", "AABB"}));
//        System.out.println(solution("hit", "cog", new String[]{"dot", "dog", "cog"}));
//        System.out.println(solution("aab", "aba", new String[]{"abb", "aba"}));
//        System.out.println(solution("hha", "hih", new String[]{"hhf", "hih"}));
//        System.out.println(solution("hit", "hot", new String[]{"hot", "dot", "dog", "lot", "log"}));
//        System.out.println(solution("1234567000", "1234567899", new String[]{"1234567800", "1234567890", "1234567899"}));
//        System.out.println(solution("hit", "hot", new String[]{"cog", "log", "lot", "dog", "hot"}));
//        System.out.println(solution("hot", "lot", new String[]{"hot", "dot", "dog", "lot", "log"}));
        System.out.println(solution("hot", "hot", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    private static int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(target).contains(target)) return 0;

        Set<String> used = new HashSet<>();

        //DFS
        Stack<Word> stack = new Stack<>();
        stack.add(new Word(begin, 0));
        while (!stack.isEmpty()) {
            Word now = stack.pop();

            if(now.word.equals(target)) {
                return now.depth;
            }

            for (String w : words) {
                //바꿀 수 있는 단어들만 Stack에 넣음(한글자만 다른 단어, 사용하지 않은 단어)
                //한글자만 다른 단어
                if (!changable(now.word, w)) continue;
                if (used.contains(w)) continue;
                used.add(w);
                stack.push(new Word(w, now.depth + 1));
            }
        }

        return 0;
    }

    private static boolean changable(String w1, String w2) {
        int len = Math.max(w1.length(), w2.length());
        int count = 0;
        for (int i = 0; i < len && count < 2; i++) {
            if (w1.charAt(i) != w2.charAt(i)) count++;
        }
        return count == 1;
    }

    private static class Word {
        String word;
        int depth;

        public Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }


}
