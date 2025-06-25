package inflearn.pccp.section06;

public class 문자열내p와y의개수 {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    private static boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        for (int i = 0; i <s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if(c == 'y') yCount++;
            else if(c == 'p') pCount++;
        }
        if(pCount == yCount) return true;
        return false;
    }
}
