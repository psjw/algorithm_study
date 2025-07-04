package inflearn.pccp.section08;

public class 단어변환 {

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
//        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
//        System.out.println(solution("AAAA", "AABB", new String[]{"AABA", "AABB"}));
//        System.out.println(solution("hit", "cog", new String[]{"dot", "dog", "cog"}));
//        System.out.println(solution("aab", "aba", new String[]{"abb", "aba"}));
//        System.out.println(solution("hha", "hih", new String[]{"hhf", "hih"}));
//        System.out.println(solution("hit", "hot", new String[]{"hot", "dot", "dog", "lot", "log"}));
//        System.out.println(solution("1234567000", "1234567899", new String[]{"1234567800", "1234567890", "1234567899"}));
//        System.out.println(solution("hit", "hot", new String[]{"cog", "log", "lot", "dog", "hot"}));
//        System.out.println(solution("hot", "lot", new String[]{"hot", "dot", "dog", "lot", "log"}));
        System.out.println(solution("hot", "hot", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    private static int answer;
    private static boolean[] visited;

    private static int solution(String begin, String target, String[] words) {
        //hit -> hot -> dot -> dog -> lot -> log -> cog
        visited = new boolean[words.length];

        dfs(begin, target, 0,  words);

        return answer;
    }

    private static void dfs(String currentWord, String target, int count, String[] words) {
        if (currentWord.equals(target)) {
            answer =  count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            int charCnt = 0;
            String word = words[i];
            if (visited[i]) {
                continue;
            }
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == currentWord.charAt(j)) {
                    charCnt++;
                }
            }
            if (charCnt == word.length() - 1) {
                visited[i] = true;
                dfs(word, target, count + 1, words);
                visited[i] = false;
            }
        }
    }
}
