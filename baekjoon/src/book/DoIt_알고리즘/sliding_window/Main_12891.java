package book.DoIt_알고리즘.sliding_window;

import java.io.*;
import java.util.StringTokenizer;

public class Main_12891 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            //‘A’, ‘C’, ‘G’, ‘T’}
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int[] password = new int[4];
            int[] chars = new int[S];
            String str = br.readLine();
            int check[] = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                check[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < str.length(); i++) {
                chars[i] = str.charAt(i);
            }


            for (int i = 0; i < P; i++) {
                int cur = chars[i];
                if (cur == 'A') {
                    password[0]++;
                } else if (cur == 'C') {
                    password[1]++;
                } else if (cur == 'G') {
                    password[2]++;
                } else if (cur == 'T') {
                    password[3]++;
                }
            }

            int start = 0;
            int end = P - 1;
            int result = 0;
            while (end != S) {
                int eqCount = 0;
                for (int i = 0; i < 4; i++) {
                    if (password[i] >= check[i]) {
                        eqCount++;
                    }
                    if (eqCount == 4) {
                        result++;
                    }
                }

                if (chars[start] == 'A') {
                    password[0]--;
                } else if (chars[start] == 'C') {
                    password[1]--;
                } else if (chars[start] == 'G') {
                    password[2]--;
                } else if (chars[start] == 'T') {
                    password[3]--;
                }
                start++;
                end++;
                if (end == S) {
                    break;
                }

                if (chars[end] == 'A') {
                    password[0]++;
                } else if (chars[end] == 'C') {
                    password[1]++;
                } else if (chars[end] == 'G') {
                    password[2]++;
                } else if (chars[end] == 'T') {
                    password[3]++;
                }


            }

            bw.write(String.valueOf(result));
            bw.flush();
        }
    }
}
