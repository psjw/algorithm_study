package book.DoIt_알고리즘.floyd_warshall;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11403 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (dist[i][k] == 1 && dist[k][j] == 1) {
                            dist[i][j] = 1;
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bw.write(String.valueOf(dist[i][j]));
                    bw.write(" ");
                }
                bw.newLine();
            }

            bw.flush();

        }
    }
}
