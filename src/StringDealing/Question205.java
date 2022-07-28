package StringDealing;

/**
 * 将字符映射到一个相同的数字，即其第一次出现的位置 */
public class Question205 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] s1 = new int[256];
        int[] t1 = new int[256];
        for (int i = 0; i < n; i++) {
            if (s1[s.charAt(i)] != t1[t.charAt(i)]) {
                return false;
            }
            s1[s.charAt(i)] = t1[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper", t = "title";
        Question205 a = new Question205();
        System.out.println(a.isIsomorphic(s, t));
    }
}
