package StringDealing;

import java.util.Arrays;

/**
 * leetcode 28
 */
public class kmp {
    private int[] next;

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int p = needle.length();
        int k = -1;
        calNext(needle);
        for (int i = 0; i < n; i++) {
            while (k > -1 && haystack.charAt(i) != needle.charAt(k + 1)) {
                k = next[k];
            }
            if (needle.charAt(k + 1) == haystack.charAt(i)) {
                ++k;
            }
            if (k == p - 1) {
                return i - p + 1;
            }
        }
        return -1;
    }

    public void calNext(String needle) {
        int n = needle.length();
        int j = -1;
        next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 1; i < n; i++) {
            while (j > -1 && needle.charAt(j + 1) != needle.charAt(i)) {
                j = next[j];
            }
            if (needle.charAt(j + 1) == needle.charAt(i)) {
                ++j;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        kmp a = new kmp();
        System.out.println(a.strStr(haystack, needle));
    }
}
