package book.Doit알고리즘.graph;

import java.io.*;
import java.util.*;

public class Main_1325 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] conditions = br.readLine().split(" ");
            int N = Integer.parseInt(conditions[0]);
            int M = Integer.parseInt(conditions[1]);

            int answer[] = new int[N + 1];
            int max = 0;
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();

            }

            for (int i = 0; i < M; i++) {
                String[] info = br.readLine().split(" ");
                int s = Integer.parseInt(info[0]);
                int e = Integer.parseInt(info[1]);
                graph[s].add(e);
            }


            Queue<Integer> queue = new LinkedList<>();
            for (int k = 1; k <= N; k++) {
                queue.clear();
                boolean[] visited = new boolean[N + 1];
                visited[k] = true;
                queue.add(k);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();

                    for (int i = 0; i < graph[cur].size(); i++) {
                        int next = graph[cur].get(i);
                        if (!visited[next]){
                            queue.add(next);
                            visited[next] = true;
                            answer[next]++;
                            if(answer[next] > max){
                                max = Math.max(max, answer[next]);
                            }
                        }
                    }
                }
            }


            for(int i = 1; i <= N; i++) {
                if(answer[i] == max) {
                    bw.write(i + " ");
                }
            }

            bw.flush();
        }
    }

}
