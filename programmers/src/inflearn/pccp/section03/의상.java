package inflearn.pccp.section03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 의상 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
//        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    private static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;
        for (String[] cloth : clothes) {
            String clothType = cloth[1];
            map.put(clothType,map.getOrDefault(clothType,0) + 1);
        }
        System.out.println(map);
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            answer *= it.next() + 1;
        }

        return answer - 1;
    }
}
