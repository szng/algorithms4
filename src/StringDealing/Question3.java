package StringDealing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        int left = 0, right = 0, result = 0;
        Map<Character, Integer> data = new HashMap<>();
        while (right < n) {
            char c = s.charAt(right);
            if (data.containsKey(c)) {
                int temp = data.get(c) + 1;
                result = Math.max(result, right - left);
                while (left < temp) {
                    data.remove(s.charAt(left++));
                }
            }
            data.put(c, right);
            ++right;
        }
        result = Math.max(result, right - left);
        return result;
    }
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        int right = 0, result = 0;
        Set<Character> data = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                data.remove(s.charAt(i - 1));
            }
            while (right < n && !data.contains(s.charAt(right))) {
                data.add(s.charAt(right));
                ++right;
            }
            result = Math.max(result, right - i);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Question3 a = new Question3();
        System.out.println(a.lengthOfLongestSubstring2(s));
    }
}
