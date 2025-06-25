package inflearn.pccp.section06;

import java.util.HashMap;

public class 전화번호목록 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }

    private static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                String temp = phone_book[i].substring(0, j+1);
                if(map.containsKey(temp) && map.get(temp) != i) {
                    return false;
                }
            }  

        }
        return answer;
    }
}
