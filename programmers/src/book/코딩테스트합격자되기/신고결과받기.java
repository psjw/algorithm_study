package book.코딩테스트합격자되기;

import java.util.*;
import java.util.stream.Collectors;

public class 신고결과받기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}
                , new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}
                , 2)));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {

        //"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"
        // frodo
        // frodo
        // neo
        // neo
        // muzi

        //con
        //con
        //con
        //con

        //Key : 신고 당한 아이디 , Value : 신고한 아이디
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        //Key : 아이디 , Value : id_list의 인덱스
        Map<String, Integer> indexMap = new HashMap<>();

        //초기화
        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
            indexMap.put(id_list[i], i);
        }

        //Key : 신고 당한 아이디 , Value : 신고한 아이디로 Map에 넣어주기
        for (int i = 0; i < report.length; i++) {
            String[] reporting = report[i].split(" ");
            reportMap.get(reporting[1]).add(reporting[0]);
        }
        int[] answer = new int[id_list.length];

        //신고 당한 사람의 신고자가 2보다 크면 indexMap을 통해 answer의 index에서 카운팅해주기
        for (int i = 0; i < id_list.length; i++) {
            if (reportMap.get(id_list[i]).size() >= k) {
                for (String id : reportMap.get(id_list[i])) {
                    answer[indexMap.get(id)]++;
                }
            }
        }

        return answer;
    }
}
