package book.DoIt_알고리즘.bfs;

import java.io.*;
import java.util.*;


public class Main_1260 {
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;
    private static int N, M, V;
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            for (int i = 1; i <= N; i++) {
                Collections.sort(graph[i]);
            }

            visited = new boolean[N + 1];
            dfs(V);

            for (int i = 0; i < result.size(); i++) {
                bw.write(String.valueOf(result.get(i)));
                bw.write(" ");
            }

            bw.newLine();

            result.clear();
            visited = new boolean[N + 1];
            bfs(V);


            for (int i = 0; i < result.size(); i++) {
                bw.write(String.valueOf(result.get(i)));
                bw.write(" ");
            }

        }
    }


    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        visited[v] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }


    private static void dfs(int v) {
        result.add(v);
        visited[v] = true;
        for (int i = 0; i < graph[v].size(); i++) {
            int cur = graph[v].get(i);
            if (!visited[cur]) {
                dfs(cur);
            }
        }
    }
}


