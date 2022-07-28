package StringDealing;

public class Question409 {
    public int longestPalindrome(String s) {
        int n = s.length();
        boolean hasOdd = false;
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        int maxOdd = 0;
        int[] data = new int[128];
        for (int i = 0; i < n; i++) {
            data[s.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) {
            if (data[i] % 2 == 0) {
                sum += data[i];
            } else {
                hasOdd = true;
                sum += data[i] - 1;
            }
        }
        if (hasOdd) {
            ++sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "a";
        Question409 a = new Question409();
        System.out.println(a.longestPalindrome(s));
    }
}
