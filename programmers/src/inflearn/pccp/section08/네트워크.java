package inflearn.pccp.section08;

public class 네트워크 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    private static boolean visited[];
    private static int total;

    private static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        total = computers.length;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i, computers);
            answer++;
        }
        return answer;
    }

    private static void dfs(int start, int[][] computers) {
        visited[start] = true;

        for (int i = 0; i < total; i++) {
            if(!visited[i] && computers[start][i] > 0){
                dfs(i, computers);
            }
        }
    }

}
