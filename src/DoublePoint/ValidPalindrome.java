package DoublePoint;

/**
 * leetcode 680
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s, int flag) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (++flag > 1) {
                    return false;
                }
                return validPalindrome(s.substring(l, r), flag) || validPalindrome(s.substring(l + 1, r + 1), flag);
            }
            ++l;
            --r;
        }
        return true;
    }


    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0);
    }

    public static void main(String[] args) {
        String s = "abc";
        ValidPalindrome a = new ValidPalindrome();
        System.out.println(a.validPalindrome(s));
    }
}
