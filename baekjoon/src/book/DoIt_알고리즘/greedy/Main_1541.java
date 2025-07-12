package book.DoIt_알고리즘.greedy;

import java.io.*;

public class Main_1541 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String tempStr = br.readLine();
            String minus[] = tempStr.split("-");

            int result = 0;
            for (int i = 0; i < minus.length; i++) {
                int temp = 0;
                String adds[] = minus[i].split("\\+");
                for (int j = 0; j < adds.length; j++) {
                    temp += Integer.parseInt(adds[j]);
                }
                if(i ==0){
                    result += temp;
                }else {
                    result -= temp;
                }
            }



            bw.write(String.valueOf(result));
            bw.flush();

        }
    }

}
