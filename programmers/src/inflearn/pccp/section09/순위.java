package inflearn.pccp.section09;

public class 순위 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    private static int solution(int n, int[][] results) {
        int answer = 0;
        int fight[][] = new int[n+1][n+1];
        for (int i = 0; i < results.length; i++) {
            int x = results[i][0];
            int y = results[i][1];
            fight[x][y] = 1; //승리
            fight[y][x] = -1; //패배
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (fight[s][k] == 1 && fight[k][e] == 1) { //승리
                        fight[s][e] = 1;
                        fight[e][s] = -1;
                    }
                    if(fight[s][k] == -1 && fight[k][e] == -1) { //패배
                        fight[s][e] = -1;
                        fight[e][s] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if(fight[i][j] != 0) {
                    count++;
                }
            }
            if(count == n-1) {
                answer++;
            }
        }
        return answer;
    }
}
