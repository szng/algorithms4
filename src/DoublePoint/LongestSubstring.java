package DoublePoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 牛客 NC356
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> ret = new HashMap<>();
        int l = 0, r = 0;
        int MaxLength = 0;
        while (r < s.length()) {
            if (ret.containsKey(s.charAt(r))) {
                ret.put(s.charAt(r), ret.get(s.charAt(r)) + 1);
            } else {
                ret.put(s.charAt(r), 1);
            }
            if (ret.size() <= k) {
                if (MaxLength < r - l + 1) {
                    MaxLength = r - l + 1;
                }
            }

            while (ret.size() > k) {
                int count = ret.get(s.charAt(l)) - 1;
                if (count == 0) {
                    ret.remove(s.charAt(l));
                } else {
                    ret.put(s.charAt(l), count);
                }
                ++l;
            }
            ++r;
        }
        return MaxLength;
    }

    public static void main(String[] args) {
        String s = "efsarcbynec";
        LongestSubstring a = new LongestSubstring();
        System.out.println(a.longestSubstring(s, 5));
    }
}
