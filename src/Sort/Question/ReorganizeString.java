package Sort.Question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 767
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxCount = 1;
        int N = s.length();

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            if (maxCount < count[c - 'a']) {
                maxCount = count[c - 'a'];
            }
        }
        if (maxCount > (N + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> result = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2 - 'a'] - count[o1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) {
                result.offer(c);
            }
        }
        StringBuilder results = new StringBuilder();
        while (result.size() > 1) {
            char letter1 = result.poll();
            char letter2 = result.poll();
            results.append(letter1);
            results.append(letter2);
            if(--count[letter1-'a'] > 0)
                result.offer(letter1);
            if(--count[letter2-'a'] > 0)
                result.offer(letter2);
        }
        if (result.size() > 0) {
            results.append(result.poll());
        }
        return results.toString();
    }

    public static void main(String[] args) {
        String s = "zhmyo";
        ReorganizeString a = new ReorganizeString();
        System.out.println(a.reorganizeString(s));
    }
}
