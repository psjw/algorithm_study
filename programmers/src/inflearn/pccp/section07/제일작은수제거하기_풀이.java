package inflearn.pccp.section07;

import java.util.Arrays;

public class 제일작은수제거하기_풀이 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(solution(new int[]{10})));
        System.out.println(Arrays.toString(solution1(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(solution1(new int[]{10})));
    }
    private static int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        //최소값 구하기
        int min = Integer.MAX_VALUE;

        for (int a : arr) {
            if(a < min) min = a;
        }

        //최소값 뺴고 나머지 배열 만들기
        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int a : arr) {
            if(a == min) continue;
            answer[index] = a;
            index++;
        }


        return answer;
    }


    private static int[] solution1(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        //최소값 구하기

        int min = Arrays.stream(arr).min().getAsInt();
        //최소값 뺴고 나머지 배열 만들기
        int[] answer = Arrays.stream(arr).filter(a -> a != min).toArray();


        return answer;
    }
}
