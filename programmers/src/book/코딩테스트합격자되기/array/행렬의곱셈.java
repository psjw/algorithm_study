package book.코딩테스트합격자되기.array;

public class 행렬의곱셈 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}}));
        ;
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) { //0
            for (int j = 0; j < arr2[0].length; j++) { // 0, 1
                for (int k = 0; k < arr1[0].length; k++) { // 0, 1
                    answer[i][j] += (arr1[i][k] * arr2[k][j]); //0,0 = (0,0)*(0,0) + (0,1)*(1,0)
                }
            }
        }

        return answer;
    }
}
