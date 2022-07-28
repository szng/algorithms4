package StringDealing;

public class Question647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += extendSubstring(s, i, i);
            count += extendSubstring(s, i, i + 1);
        }
        return count;
    }

    private int extendSubstring(String s, int l, int r) {
        int count = 0;
        int n = s.length();
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            ++count;
            --l;
            ++r;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        Question647 a = new Question647();
        System.out.println(a.countSubstrings(s));
    }
}
