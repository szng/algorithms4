package StringDealing;

import Bit.Question476;

public class Question696 {
    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, count = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt((i - 1))) {
                ++cur;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "10101";
        Question696 a = new Question696();
        System.out.println(a.countBinarySubstrings(s));
    }
}
