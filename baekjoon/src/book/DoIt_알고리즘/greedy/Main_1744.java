package book.DoIt_알고리즘.greedy;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1744 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
            int sum[] = new int[N];
            int minus[] = new int[N];
            int oneCheck = 0;
            int zeroCheck = 0;
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(br.readLine());
                if (temp > 1) {
                    plusQueue.add(temp);
                } else if (temp == 1) {
                    oneCheck++;
                } else if (temp == 0) {
                    zeroCheck++;
                } else {
                    minusQueue.add(temp);
                }
            }
            int index = 0;
            while (plusQueue.size() > 1) {
                int a = plusQueue.poll();
                int b = plusQueue.poll();
                sum[index] = a * b;
                index++;
            }

            while (!plusQueue.isEmpty()) {
                sum[index] = plusQueue.poll();
            }

            index = 0;
            while (minusQueue.size() > 1) {
                int a = minusQueue.poll();
                int b = minusQueue.poll();
                minus[index] = a * b;
                index++;
            }


            while (!minusQueue.isEmpty()) {
                minus[index] = minusQueue.poll();
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                if (minus[i] < 0 && zeroCheck > 0) {
                    minus[i] = 0;
                    zeroCheck--;
                }
                result += (sum[i] + minus[i]);
            }

            if (oneCheck > 0) {
                result += oneCheck;
            }

            bw.write(String.valueOf(result));
            bw.flush();

        }
    }
}

