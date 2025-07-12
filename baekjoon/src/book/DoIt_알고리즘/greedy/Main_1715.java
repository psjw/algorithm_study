package book.DoIt_알고리즘.greedy;

import java.io.*;
import java.util.PriorityQueue;

public class Main_1715 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 1; i <= N; i++) {
                pq.add(Integer.parseInt(br.readLine()));
            }

            int[] sum = new int[N];
            int index = 0;
            while (pq.size() > 1) {
                int min1 = pq.poll();
                int min2 = pq.poll();
                sum[index] = min1 + min2;
                pq.add(sum[index]);
                index++;
            }

            int result = 0;
            for(int i =0; i < N; i++) {
                result+=sum[i];
            }

            bw.write(String.valueOf(result));
            bw.flush();
        }
    }
}

