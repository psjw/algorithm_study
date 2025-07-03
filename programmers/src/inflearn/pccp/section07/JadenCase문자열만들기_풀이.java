package inflearn.pccp.section07;

public class JadenCase문자열만들기_풀이 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution(" 3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution(" "));
        System.out.println(solution("  "));
    }

    private static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String s2 = s.toLowerCase();
        char last = ' ';
        for(char c: s2.toCharArray()) {
            if(last == ' ') c = Character.toUpperCase(c);
            answer.append(c);
            last = c;
        }

        return answer.toString();
    }
}
