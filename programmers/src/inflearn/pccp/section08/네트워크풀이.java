package inflearn.pccp.section08;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 네트워크풀이 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) continue;
            answer++;
            visitAllConnectedComputers2(computers, visited, i);
        }
        return answer;
    }

    private static void visitAllConnectedComputers(final int[][] computers, boolean[] visited, int c) {
        //BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);
        while (!q.isEmpty()) {
            int i = q.poll();
            visited[i] = true;
            for (int j = 0; j < computers[i].length; j++) {
                if(visited[j]) continue;
                if(computers[i][j] == 1) q.offer(j);
            }
        }
    }


    private static void visitAllConnectedComputers2(final int[][] computers, boolean[] visited, int c) {
        //BFS
        Stack<Integer> q = new Stack<>();
        q.push(c);
        while (!q.isEmpty()) {
            int i = q.pop();
            visited[i] = true;
            for (int j = 0; j < computers[i].length; j++) {
                if(visited[j]) continue;
                if(computers[i][j] == 1) q.push(j);
            }
        }
    }

}
