package inflearn.pccp.section04;

import java.util.HashSet;
import java.util.Set;

public class 로또번호검출기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 32, 43, 22, 19}));
        System.out.println(solution(new int[]{3, 19, 34, 39, 39, 20}));
    }

    private static boolean solution(int[] lotto) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < lotto.length; i++) {
            set.add(lotto[i]);
        }

        if(set.size() != lotto.length) {
            return false;
        }
        return true;
    }
}
