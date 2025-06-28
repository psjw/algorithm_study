package inflearn.pccp.section06;

public class 문자열내p와y의개수_풀이 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution1("pPoooyY"));
        System.out.println(solution("Pyy"));
        System.out.println(solution1("Pyy"));
    }


    private static boolean solution1(String s) {

        int p = s.replaceAll("[^pP]", "").length(); //정규 표현식
        int y = s.replaceAll("[^yY]", "").length();

        return p == y;
    }

    private static boolean solution(String s) {
        String s2 = s.toLowerCase();
        int p = 0;
        for (char c : s2.toCharArray()) {
            if(c == 'p') p++;
            if(c == 'y') p--;
        }
        return p == 0;
    }
}
