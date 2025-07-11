package book.DoIt_알고리즘.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1940 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int start = 0;
            int end = arr.length - 1;

            int count = 0;
            while (start <= end) {
                int sum = arr[start] + arr[end];
                if (sum < M) {
                    start++;
                } else if (sum > M) {
                    end--;
                } else {
                    count++;
                    start++;
                }
            }

            bw.write(String.valueOf(count));
            bw.flush();
        }

    }
}
