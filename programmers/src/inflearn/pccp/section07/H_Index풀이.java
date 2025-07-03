package inflearn.pccp.section07;

import java.util.Arrays;

public class H_Index풀이 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{5, 5, 6, 5, 5, 6}));
        System.out.println(solution(new int[]{5, 6, 7, 8}));
    }

    private static int solution(int[] citations) {
        // [3, 0, 6, 1, 5]
        // [0, 1, 3, 5, 6]

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if(citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
