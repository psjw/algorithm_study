package inflearn.pccp.section04;

import java.util.HashSet;
import java.util.Set;

public class 끝말잇기_풀이 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"tank", "kick", "know", "wheel", "land", "dream"}));
        System.out.println(solution(new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
    }

    public static boolean solution(String[] words) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        String prevWord =  words[0];
        set.add(prevWord);
        for (int i = 1; i < words.length; i++) {
            String nowWord = words[i];
            if(nowWord.charAt(0) != prevWord.charAt(prevWord.length() - 1)) {
                return false;
            }
            set.add(nowWord);
            prevWord = nowWord;
        }
        if(set.size() != words.length) {
            return false;
        }
        return answer;
    }
}
