package inflearn.pccp.section04;

import java.util.Arrays;
import java.util.HashSet;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }

    private static int[] solution(int n, String[] words) {
        int[] answer = {};
        HashSet<String> set = new HashSet<>();

        int result = 0;
        int count = 0;
        String postfix = "";
        for (int i = 0; i < words.length; i++) {
            int curIdx = i + 1;
            count = curIdx / n + (curIdx % n == 0 ? 0 : 1);
            if (i == 0) {
                set.add(words[i]);
                postfix = Character.toString(words[i].charAt(words[i].length() - 1));
                continue;
            }
            if (set.contains(words[i])) {
                result = curIdx % n == 0 ? n : curIdx % n;
                break;
            }

            if (!postfix.equals(Character.toString(words[i].charAt(0)))) {
                result = curIdx % n == 0 ? n : curIdx % n;
                break;
            }
            postfix = Character.toString(words[i].charAt(words[i].length() - 1));
            set.add(words[i]);
        }

        answer = new int[]{result, result == 0 ?  0 : count};
        return answer;
    }
}
