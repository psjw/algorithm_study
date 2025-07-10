package book.Doit알고리즘.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11660 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int graph[][] = new int[N + 1][N + 1];
            int d[][] = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    d[i][j] = d[i - 1][j] + d[i][j - 1] + graph[i][j] - d[i - 1][j - 1];
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int sum = d[x2][y2] - d[x1-1][y2] - d[x2][y1-1] + d[x1-1][y1-1];
                bw.write(String.valueOf(sum));
                bw.newLine();
            }

            bw.flush();
        }
    }
}
