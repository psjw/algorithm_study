package book.Doit알고리즘.unionfind;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1976 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            parents = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    int dest = Integer.parseInt(st.nextToken());
                    if (dest == 1) {
                        union(i, j);
                    }
                }
            }


            StringTokenizer st = new StringTokenizer(br.readLine());
            int possible = find(Integer.parseInt(st.nextToken()));
            boolean isCheck = true;
            for (int i = 1; i < M; i++) {
                int dest = Integer.parseInt(st.nextToken());
                if (possible != find(dest)) {
                    isCheck = false;
                }
            }

            if (isCheck) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            bw.newLine();
            bw.flush();
        }
    }

    private static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA != parB) {
            parents[parA] = parB;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        int parent = find(parents[a]);
        parents[a] = parent;
        return parent;
    }
}
