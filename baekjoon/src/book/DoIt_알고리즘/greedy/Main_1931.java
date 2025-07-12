package book.DoIt_알고리즘.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arr[i][0] = start;
                arr[i][1] = end;
            }

            Arrays.sort(arr, (s1, s2) -> {
                if (s1[1] == s2[1]) {
                    return s1[0] - s2[0];
                }
                return s1[1] - s2[1];
            });
            int endTime = -1;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i][0] >= endTime) {
                    endTime = arr[i][1];
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.flush();
        }
    }
}
