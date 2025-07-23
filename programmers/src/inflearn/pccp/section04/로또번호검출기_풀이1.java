package inflearn.pccp.section04;

public class 로또번호검출기_풀이1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 32, 43, 22, 19}));
        System.out.println(solution(new int[]{3, 19, 34, 39, 39, 20}));
    }
    private static boolean solution(int[] lotto) {
        boolean answer = true;
        boolean[] check = new boolean[45+1];
        for (int l: lotto) {
            if(l<1 || l>45) return false;
            if(check[l]) return false;
            check[l] = true;
        }
        return answer;
    }
}
