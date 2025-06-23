package book.프로그래머스코딩테스트문제풀이전략;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 교점에별만들기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{
                {2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
        })));
    }

    private static String[] solution(int[][] line) {
        String[] answer = {};
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                double moleculeX = (double) line[i][1] * line[j][2] - (double) line[i][2] * line[j][1];
                double moleculeY = (double) line[i][2] * line[j][0] - (double) line[i][0] * line[j][2];
                double denominator = (double) line[i][0] * line[j][1] - (double) line[i][1] * line[j][0];
                if(denominator ==0)
                    continue;

                double x = moleculeX / denominator;
                double y = moleculeY / denominator;
                if (x % 1 != 0 || y % 1 != 0) {
                    continue;
                }

                points.add(new Point((long) x, (long) y));
            }
        }

        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        for (Point point : points) {
            if (point.x > maxX) {
                maxX = point.x;
            }
            if (point.y > maxY) {
                maxY = point.y;
            }
        }

        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for (Point point : points) {
            if (point.x < minX) {
                minX = point.x;
            }
            if (point.y < minY) {
                minY = point.y;
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        String[][] all = new String[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(all[i], ".");
        }

        for (Point point : points) {
            System.out.println(point);
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);
            all[y][x] = "*";
        }

        answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = Arrays.stream(all[i]).collect(Collectors.joining());
        }

        return answer;
    }

    private static class Point {
        public long x;
        public long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
