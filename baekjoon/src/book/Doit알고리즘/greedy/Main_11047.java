package book.Doit알고리즘.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11047 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            int sum = K;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] <= sum) {
                    count += (sum / arr[i]);
                    sum = sum % arr[i];
                }

                if (sum == 0) {
                    break;
                }
            }

            bw.write(String.valueOf(count));
            bw.flush();
        }
    }
}
