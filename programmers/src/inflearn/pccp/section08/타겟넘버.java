package inflearn.pccp.section08;

public class 타겟넘버 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }

    private static int count = 0;

    private static int solution(int[] numbers, int target) {
        int answer = 0;
        count = 0;
        dfs(target, numbers, numbers[0], 0);
        dfs(target, numbers, (-1) * numbers[0], 0);
        answer = count;
        return answer;
    }

    private static void dfs(int target, int[] numbers, int sum, int index) {

        // 4 -> 4+1 -> 5+2 -> 7+1 =8
        //                    7-1 =6
        //             5-2  -> 3+1 =4
        //                  -> 3-1 =2
        //      4-1 -> 3+2 -> 5+1 = 6
        //                 -> 5-1 = 4
        //             3-2 -> 1+1 =2
        //                 -> 1-1 =0


        if (sum == target && index == numbers.length - 1) {
            count++;
            return;
        }
        if(index == numbers.length - 1) {
            return;
        }
        index++;
        dfs(target, numbers, sum + numbers[index], index);
        dfs(target, numbers, sum + ((-1) * numbers[index]), index);
    }
}
