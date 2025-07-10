package book.DoIt_알고리즘.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1707 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int K = Integer.parseInt(br.readLine());
            for (int testCase = 0; testCase < K; testCase++) {
                String[] conditions = br.readLine().split(" ");
                int V = Integer.parseInt(conditions[0]);
                int E = Integer.parseInt(conditions[1]);
                ArrayList<Integer>[] graph = new ArrayList[V + 1];
                for (int i = 1; i <= V; i++) {
                    graph[i] = new ArrayList<>();
                }

                for (int i = 0; i < E; i++) {
                    String[] vertexes = br.readLine().split(" ");
                    int s = Integer.parseInt(vertexes[0]);
                    int e = Integer.parseInt(vertexes[1]);
                    graph[s].add(e);
                    graph[e].add(s);
                }

                boolean isCheck = true;
                int[] visited = new int[V + 1];
                Queue<Integer> queue = new LinkedList<>();
                for (int i = 1; i <= V; i++) {
                    if (visited[i] == 0) {
                        if (!bfs(queue, i, visited, graph)) {
                            isCheck = false;
                            break;
                        }

                    }
                }

                if(isCheck){
                    bw.write("YES");
                }else {
                    bw.write("NO");
                }
                bw.newLine();
                bw.flush();

            }
        }
    }

    private static boolean bfs(Queue<Integer> queue, int i, int[] visited, ArrayList<Integer>[] graph) throws IOException {
        queue.add(i);
        if (visited[i] == 0) {
            visited[i] = 1;
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int j = 0; j < graph[cur].size(); j++) {
                int next = graph[cur].get(j);
                if (visited[next] == 0) {
                    queue.add(next);

                    if (visited[cur] == 1) {
                        visited[next] = 2;
                    } else if (visited[cur] == 2) {
                        visited[next] = 1;
                    }

                } else if (visited[cur] == (visited[next])) {
                    return false;
                }
            }
        }
        return true;
    }
}
