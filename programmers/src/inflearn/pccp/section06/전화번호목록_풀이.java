package inflearn.pccp.section06;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호목록_풀이 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }

    private static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i =1 ; i<phone_book.length ; i++) {
            if(phone_book[i].equals(phone_book[i-1])) return false;
        }
        return true;
    }
}
