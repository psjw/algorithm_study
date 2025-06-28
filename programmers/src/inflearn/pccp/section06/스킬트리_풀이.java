package inflearn.pccp.section06;

import java.util.Arrays;

public class 스킬트리_풀이 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
        System.out.println(solution1("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    private static int solution1(String skill, String[] skill_trees) {

        return (int) Arrays.stream(skill_trees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(s -> skill.startsWith(s))
                .count();
    }

    private static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String s : skill_trees) {
            String s2 = s.replaceAll("[^" + skill + "]", "");
            if (skill.startsWith(s2)) {
                answer++;
            }
        }
        return answer;
    }
}
