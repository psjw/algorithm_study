package inflearn.pccp.section07;

public class JadenCase문자열만들기 {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution(" 3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution(" "));
        System.out.println(solution("  "));
    }

    private static String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isPrefix = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isSpaceChar(c)) {
                sb.append(c);
                isPrefix = true;
            } else if(isPrefix && Character.isLetter(c)){
                sb.append(Character.toUpperCase(c));
                isPrefix = false;
            } else{
                isPrefix = false;
                sb.append(Character.toLowerCase(c));
            }

        }

        answer = sb.toString();

        return answer;
    }
}
