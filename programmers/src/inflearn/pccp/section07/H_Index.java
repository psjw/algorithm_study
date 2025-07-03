package inflearn.pccp.section07;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{5, 5, 6, 5, 5, 6}));
        System.out.println(solution(new int[]{5, 6, 7, 8}));
    }

    private static int solution(int[] citations) {
        // >= 0 논문 개수 5개 -> h=0 5>=0
        // >= 1 논문 개수 4개 -> h=1 4>=1
        // >= 2 논문 개수 3개 -> 3>=2
        // >= 3 논문 개수 3개 -> 3>=3
        // >= 4 논문 개수 2개 -> 4<2 불만족
        // >= 5 논문 개수 2개

        // [5,6,7,8]
        // n = 0 -> 4개, h = 4
        // n = 1 -> 4개, 1>=4  h=1
        // n = 2 -> 4개, 2>=4 h=2
        // n = 3 -> 4개, 3>=4 h=3
        // n = 4 -> 4개, 4>=4 h=4

        Arrays.sort(citations);
        int answer = 0;
        int count = 0;

        for (int i = 0; i <= citations.length; i++) {
            count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    count++;
                }
            }
            if (count >= i) {
                answer = Math.max(answer, i);
            }
        }


        return answer;
    }
}
