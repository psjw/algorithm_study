package book.DoIt_알고리즘.union_find;

import java.io.*;

public class Main_1717 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] conditions = br.readLine().split(" ");
            int N = Integer.parseInt(conditions[0]);
            int M = Integer.parseInt(conditions[1]);
            parents = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < M; i++) {
                String[] infos = br.readLine().split(" ");
                int command = Integer.parseInt(infos[0]);
                int s = Integer.parseInt(infos[1]);
                int e = Integer.parseInt(infos[2]);
                if (command == 0) {
                    union(s, e);
                } else if (command == 1) {
                    boolean isUnion = checkUnion(s, e);
                    if (isUnion) {
                        bw.write("YES");
                    } else {
                        bw.write("NO");
                    }
                    bw.newLine();
                }
            }
            bw.flush();
        }
    }

    private static boolean checkUnion(int s, int e) {
        return find(s) == find(e);
    }

    private static void union(int s, int e) {
        int parentA = find(s);
        int parentB = find(e);
        if (parentA != parentB) {
            parents[parentA] = parentB;
        }
    }

    private static int find(int i) {
        if (parents[i] == i) {
            return i;
        }

        int parent = find(parents[i]);
        parents[i] = parent;
        return parent;
    }
}
