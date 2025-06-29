package inflearn.pccp.section07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }

    static String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<MyData> myDataList = new ArrayList<>();
        for(int i = 0; i < strings.length; i++) {
            myDataList.add(new MyData(strings[i].charAt(n), strings[i]));
        }

        myDataList.sort(Comparator.naturalOrder());
        answer = new String[myDataList.size()];
        for (int i = 0; i < myDataList.size(); i++) {
            answer[i] = myDataList.get(i).word;
        }

        return answer;
    }

    static class MyData implements Comparable<MyData> {
        char ch;
        String word;

        public MyData(char ch, String word) {
            this.ch = ch;
            this.word = word;
        }

        @Override
        public int compareTo(MyData o) {
            return Character.compare(ch, o.ch) == 0 ? this.word.compareTo(o.word) : Character.compare(ch, o.ch);
        }

        @Override
        public String toString() {
            return String.valueOf(word);
        }
    }
}
