package inflearn.pccp.section06;

import java.util.Arrays;

public class 스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    private static  int solution(String skill, String[] skill_trees) {
        int answer = 0;
        //C -> B -> D
        //1. (B) -> A -> (C -> D) -> E :가능
        //2. (C -> B) -> A -> (D) -> F : 가능
        //3. A -> E -> (C -> B) : 가능
        //4. (B) -> A -> (D) : 불가능 C를 먼저 습득
        for (int i = 0; i < skill_trees.length; i++) {
            String result = "";
            for (int k = 0; k < skill_trees[i].length(); k++) {
                String curSkillTree = skill_trees[i].charAt(k) +"";
                if(skill.contains(curSkillTree)){
                    result = result + curSkillTree;
                }
            }
            if(skill.startsWith(result)){
                answer++;
            }
        }
        return answer;
    }
}
