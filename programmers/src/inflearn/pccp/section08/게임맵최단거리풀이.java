package inflearn.pccp.section08;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리풀이 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }


    private static int solution(int[][] maps) {
        final int maxSizeX = maps.length;
        final int maxSizeY = maps[0].length;
        final Location target = new Location(maxSizeX - 1, maxSizeY - 1);
        boolean[][] visited = new boolean[maxSizeX][maxSizeY];

        Queue<Position> queue = new LinkedList();
        queue.add(new Position(1, new Location(0,0)));

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            if(now.location.x < 0) continue; //맵 밖
            if(now.location.x >= maxSizeX) continue; //맵 밖
            if(now.location.y < 0) continue; //맵 밖
            if(now.location.y >= maxSizeY) continue; //맵 밖

            if(maps[now.location.x][now.location.y] == 0) continue; //벽

            if(visited[now.location.x][now.location.y]) continue;

            visited[now.location.x][now.location.y] = true;
            //최종인지 확인
            if (now.location.equals(target)) {
                return now.steps;
            }

            queue.offer(new Position(now.steps + 1, now.location.left()));
            queue.offer(new Position(now.steps + 1, now.location.right()));
            queue.offer(new Position(now.steps + 1, now.location.up()));
            queue.offer(new Position(now.steps + 1, now.location.down()));
        }
        return -1;
    }

    private static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Location other) {
            return this.x == other.x && this.y == other.y;
        }

        Location left() {
            return new Location(x - 1, y);
        }

        Location right() {
            return new Location(x + 1, y);
        }

        Location up() {
            return new Location(x, y + 1);
        }

        Location down() {
            return new Location(x, y - 1);
        }
    }

    private static class Position {
        int steps;
        Location location;

        public Position(int steps, Location location) {
            this.steps = steps;
            this.location = location;
        }
    }
}
