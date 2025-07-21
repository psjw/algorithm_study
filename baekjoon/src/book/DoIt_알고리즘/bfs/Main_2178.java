package book.DoIt_알고리즘.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N + 1][M + 1];
            int x[] = {1, -1, 0, 0};
            int y[] = {0, 0, 1, -1};
            boolean[][] visited = new boolean[N + 1][M + 1];
            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = Character.getNumericValue(temp.charAt(j));
                }
            }
            queue.add(new Node(0, 0, 1));
            visited[0][0] = true;
            int count = 0;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if(node.x == (N-1) && node.y == (M-1)) {
                    count = node.count;
                    break;
                }
                for (int i = 0; i < x.length; i++) {
                    int nextX = x[i] + node.x;
                    int nextY = y[i] + node.y;

                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                        if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                            System.out.println("nextX = " + nextX + ", nextY = " + nextY);
                            queue.add(new Node(nextX, nextY, node.count+1));
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }

            bw.write(String.valueOf(count));
            bw.flush();

        }
    }

    private static class Node{
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }
}
