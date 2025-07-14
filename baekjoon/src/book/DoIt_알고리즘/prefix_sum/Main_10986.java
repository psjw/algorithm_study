package book.DoIt_알고리즘.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class Main_10986 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long sum[] = new long[N + 1];
            long cnt[] = new long[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int now = Integer.parseInt(st.nextToken());
                sum[i] = now + sum[i - 1];
            }
            long count = 0;
            for (int i = 1; i <= N; i++) {
                int reminder= (int)(sum[i] % M);
                if(reminder == 0) {
                    count++;
                }
                cnt[reminder]++;
            }

            for (int i = 0; i < cnt.length; i++) {
                if(cnt[i] > 1) {
                    long c = (cnt[i] * (cnt[i] - 1)) / 2;
                    count += c;
                }
            }

            bw.write(String.valueOf(count));
            bw.flush();
        }
    }
}
