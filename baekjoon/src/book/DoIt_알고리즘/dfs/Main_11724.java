package book.DoIt_알고리즘.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11724 {

    private static int N, M;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList();
            }

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    dfs(i);
                    count++;
                }
            }

            bw.write(String.valueOf(count));
            bw.flush();
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        for(int v : graph[start]) {
            if(!visited[v]) {
                dfs(v);
            }
        }
    }
}
