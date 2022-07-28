package DoublePoint;

import java.util.HashMap;

/**
 * leetcode 76
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> queue = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (queue.containsKey(t.charAt(i))) {
                int value = queue.get(t.charAt(i));
                queue.put(t.charAt(i), value + 1);
            } else {
                queue.put(t.charAt(i), 1);
            }
        }
        int l, r;
        l = r = 0;
        int count = 0;
        int Minl = 0, MinSize = s.length() + 1;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (queue.containsKey(c)) {
                queue.put(c, queue.get(c) - 1);
                if (queue.get(c) >= 0) {
                    ++count;
                }
                while (count == t.length()) {
                    if (r - l + 1 < MinSize) {
                        MinSize = r - l + 1;
                        Minl = l;
                    }
                    if (queue.containsKey(s.charAt(l))) {
                        queue.put(s.charAt(l), queue.get(s.charAt(l)) + 1);
                        if (queue.get(s.charAt(l)) > 0) {
                            --count;
                        }
                    }
                    ++l;
                }
            }
            ++r;
        }
        return MinSize > s.length() ? "" : s.substring(Minl, Minl + MinSize);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        MinWindow a = new MinWindow();
        String result = a.minWindow(s, t);
        System.out.println(result);
    }
}
