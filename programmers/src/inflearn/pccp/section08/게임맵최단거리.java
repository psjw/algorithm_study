package inflearn.pccp.section08;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }



    private static int solution(int[][] maps) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int curX = currentNode.x;
            int curY = currentNode.y;
            int curCount = currentNode.count;
            if (curX == maps.length - 1 && curY == maps[0].length - 1) {
                answer = curCount;
                break;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (maps[nextX][nextY] == 0) {
                    continue;
                }
                visited[nextX][nextY] = true;
                queue.offer(new Node(nextX, nextY, curCount + 1));
            }

        }


        return answer;
    }

    private static class Node {
        int x;
        int y;
        int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
