package book.Doit알고리즘.topologicalsorting;

import java.io.*;
import java.util.*;

public class Main_1516 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] inDegree = new int[N + 1];
            int[] times = new int[N + 1];
            ArrayList<Integer>[] graph = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                times[i] = Integer.parseInt(st.nextToken());
                while (st.hasMoreTokens()) {
                    int b = Integer.parseInt(st.nextToken());
                    if (b == -1) break;
                    graph[b].add(i);
                    inDegree[i]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0)
                    queue.offer(i);
            }

            int result[] = new int[N + 1];
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                //1 (2,3) // 2 // 3(4,5)
                for (int i = 0; i < graph[cur].size(); i++) {
                    int next = graph[cur].get(i); //2 3
                    inDegree[next]--; //0
                    result[next] = Math.max(result[next], result[cur] + times[cur]);

                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                bw.write(String.valueOf((result[i] + times[i])));
                bw.newLine();
            }
            bw.flush();
        }
    }
}
