package book.DoIt_알고리즘.prefixsum;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);


            int count = 0;
            for (int i = 0; i < N; i++) {
                int K = arr[i];
                int start = 0;
                int end = N - 1;
                while (start < end) {
                    int sum = arr[start] + arr[end];
                    if (sum == K) {
                        if (start != i && end != i) {
                            count++;
                            break;
                        } else if (start == i) {
                            start++;
                        } else if (end == i) {
                            end--;
                        }
                    } else if (sum < K) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }

            bw.write(String.valueOf(count));
            bw.flush();
        }
    }
}
