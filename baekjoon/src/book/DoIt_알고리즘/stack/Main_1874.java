package book.DoIt_알고리즘.stack;

import java.io.*;
import java.util.Stack;

public class Main_1874 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<Integer>();
            StringBuilder sb = new StringBuilder();
            int index = 1;
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(br.readLine());
                for (int j = index; j <= temp; j++) {
                    stack.push(j);
                    sb.append("+");
                    sb.append("\n");
                    if(j == temp){
                        index = temp + 1;
                    }
                }

                if(stack.peek() == temp){
                    stack.pop();
                    sb.append("-");
                    sb.append("\n");
                }
            }

            if (stack.isEmpty()) {
                bw.write(sb.toString());
            }else {
                bw.write("NO");
            }
            bw.newLine();
            bw.flush();
        }
    }
}
