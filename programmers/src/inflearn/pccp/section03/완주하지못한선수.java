package inflearn.pccp.section03;

import java.util.HashMap;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }
    private static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String p : participant) {
            if(map.containsKey(p) && map.get(p) > 0){
                map.put(p, map.get(p) - 1);
            }else {
                return p;
            }
        }

        return "";
    }
}
