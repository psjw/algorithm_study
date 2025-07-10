package book.Doit알고리즘.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11659 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N + 1];
            int[] sum = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sum[1] = arr[1];
            for (int i = 2; i < arr.length; i++) {
                sum[i] = sum[i - 1] + arr[i];
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf((sum[e] -sum[s-1])));
                bw.newLine();
            }

            bw.flush();
        }
    }
}
