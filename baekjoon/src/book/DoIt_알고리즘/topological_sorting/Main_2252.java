package book.DoIt_알고리즘.topological_sorting;

import java.io.*;
import java.util.*;

public class Main_2252 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            int indegree[] = new int[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                indegree[b]++;
            }


            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) queue.add(i);
            }

            List<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                result.add(cur);
                for (int i = 0; i < graph[cur].size(); i++) {
                    int next = graph[cur].get(i);
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            for(int i = 0; i < result.size(); i++) {
                bw.write(result.get(i)+" ");
            }
            bw.flush();

        }
    }
}
