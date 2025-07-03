package inflearn.pccp.section07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 문자열내마음대로정렬하기_풀이 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }

    static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
            return s1.charAt(n) - s2.charAt(n);
        });

        return strings;
    }

}
