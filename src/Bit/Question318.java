package Bit;

import java.util.HashMap;
import java.util.Map;

public class Question318 {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> data = new HashMap<>();
        int result = 0;
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                mask |= 1 << (word.charAt(i) - 'a');
            }
            for (Integer key : data.keySet()) {
                if ((mask & key) == 0) {
                    result = Math.max(result, word.length() * data.get(key));
                }
            }
            data.put(mask, Math.max(data.getOrDefault(mask, 0), word.length()));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a", "aa", "aaa", "aaaa"};
        Question318 a = new Question318();
        System.out.println(a.maxProduct(words));
    }
}
