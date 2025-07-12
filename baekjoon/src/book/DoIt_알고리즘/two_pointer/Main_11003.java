package book.DoIt_알고리즘.two_pointer;

import java.io.*;
import java.util.*;

public class Main_11003 {
    //1 5 2 3 6 2 3 7 3 5 2 6
    //1 1 1 2 2 2 2 2 3 3 2 2
    //1 5 2 / 1 1 1
    //5 2 3 -> 2 3 6 -> 3 6 2 / 2 2 2
    //6 2 3 -> 2 3 7 / 2 2
    //3 7 3 -> 7 3 5  / 3 3
    //3 5 2 -> 5 2 6  // 2 2
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            Deque<Node> queue = new LinkedList<Node>();
            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                while (!queue.isEmpty() && queue.getLast().value > arr[i]) {
                    queue.removeLast();
                }
                queue.add(new Node(i, arr[i]));
                if(queue.getFirst().index <= i - L){
                    queue.removeFirst();
                }

                bw.write(queue.getFirst().value +" ");
            }

            bw.flush();
        }
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
