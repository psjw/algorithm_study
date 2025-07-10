package book.Doit알고리즘.twopointer;

import java.io.*;

public class Main_2018 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int start = 1;
            int end = 1;
            int count = 1;
            int sum = 1;
            while (end != N) {
                if (sum < N) {
                    end++;
                    sum += end;
                } else if (sum > N) {
                    sum -= start;
                    start++;
                } else {
                    end++;
                    sum += end;
                    count++;
                }
            }

            bw.write(String.valueOf(count));
            bw.flush();
        }
    }
}
