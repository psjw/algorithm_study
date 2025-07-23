package inflearn.pccp.section03;

import java.util.HashMap;

public class 포켓몬 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
    }

    private static int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if(map.size() < N){
            N = map.size();
        }
        return N;
    }
}
