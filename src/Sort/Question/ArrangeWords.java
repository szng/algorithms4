package Sort.Question;

import java.util.*;

public class ArrangeWords {
    public String arrangeWords(String text) {
        List<String> queue = new ArrayList<>();
        int N = text.length();
        text = text.toLowerCase();
        for (int i = 0 , j = 0; i < N; i++) {
            if (text.charAt(i) == ' ') {
                queue.add(text.substring(j, i));
                j = i + 1;
            }
            if (i == N - 1) {
                queue.add(text.substring(j, i + 1));
            }
        }

        queue.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.length() - o2.length();
            }
        });
        StringBuilder result = new StringBuilder();
        for (String s : queue) {
            result.append(s);
            result.append(' ');
        }
        result.deleteCharAt(result.length() - 1);
        char c = (char) (result.charAt(0) + 'A' - 'a');
        result.setCharAt(0, c);
        return  result.toString();
    }

    public static void main(String[] args) {
        String s = "I am your father";
        ArrangeWords a = new ArrangeWords();
        System.out.println(a.arrangeWords(s));
    }
}
