package inflearn.pccp.section08;

public class 타겟넘버풀이 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }


    private static int solution(int[] numbers, int target) {
        return sumCount(numbers, target, 0, 0);
    }

    private static int sumCount(final int[] numbers, final int target, int index, int sum) {
        if(index == numbers.length) {
            if( sum == target){
                return 1;
            }
            return 0;
        }
        return sumCount(numbers, target, index + 1, sum + numbers[index])
                + sumCount(numbers, target, index + 1, sum - numbers[index]);
    }

}
