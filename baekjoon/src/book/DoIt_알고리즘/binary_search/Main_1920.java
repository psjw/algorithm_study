package book.DoIt_알고리즘.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int find[] = new int[M];
            for (int i = 0; i < M; i++) {
                find[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            for (int i = 0; i < M; i++) {
                boolean isCheck = false;
                int start = 0;
                int end = arr.length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (arr[mid] > find[i]) {
                        end = mid - 1;
                    } else if (arr[mid] < find[i]) {
                        start = mid + 1;
                    } else {
                        isCheck = true;
                        break;
                    }
                }

                if (!isCheck) {
                    bw.write("0");
                } else {
                    bw.write("1");
                }
                bw.newLine();

            }

            bw.flush();

        }
    }
}
