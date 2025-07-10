package book.DoIt_알고리즘.graph;

import java.io.*;
import java.util.*;

public class Main_18352 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String condition = br.readLine();
            String[] conditions = condition.split(" ");
            int N = Integer.parseInt(conditions[0]);
            int M = Integer.parseInt(conditions[1]);
            int K = Integer.parseInt(conditions[2]);
            int X = Integer.parseInt(conditions[3]);
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            boolean[] visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                String v = br.readLine();
                String[] vs = v.split(" ");
                int s = Integer.parseInt(vs[0]);
                int e = Integer.parseInt(vs[1]);

                graph[s].add(e);
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(X, 0));
            visited[X] = true;

            List<Integer> result = new ArrayList<>();

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.depth == K) {
                    result.add(cur.end);
                }
                for (int i = 0; i < graph[cur.end].size(); i++) {
                    int next = graph[cur.end].get(i);
                    if (visited[next]) continue;
                    queue.add(new Node(next, cur.depth + 1));
                    visited[next] = true;
                }
            }

            Collections.sort(result);
            if (result.size() > 0) {
                for (int i = 0; i < result.size(); i++) {
                    bw.write(String.valueOf(result.get(i)));
                    bw.newLine();
                }
            } else {
                bw.write(String.valueOf(-1));
            }

            bw.flush();

        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int depth;

        public Node(int end, int depth) {
            this.end = end;
            this.depth = depth;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(end, o.end);
        }
    }
}
