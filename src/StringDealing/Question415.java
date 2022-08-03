package StringDealing;

public class Question415 {
    public String addStrings(String num1, String num2) {
        num1 = "0" + num1;
        num2 = "0" + num2;
        StringBuilder s1 = new StringBuilder(num1).reverse();
        StringBuilder s2 = new StringBuilder(num2).reverse();
        int m = num1.length();
        int n = num2.length();
        if (m > n) {
            for (int i = n - 1; i < m; i++) {
                s2.append('0');
            }
        } else if (m < n) {
            for (int i = m - 1; i < n; i++) {
                s1.append('0');
            }
        }
        StringBuilder result = new StringBuilder();
        int extra = 0;
        for (int i = 0; i < m || i < n; i++) {
            int temp = (s1.charAt(i) - '0') + (s2.charAt(i) - '0') + extra;
            extra = temp / 10;
            result.append(temp % 10);
        }
        result.reverse();
        if (result.charAt(0) == '0') {
            return result.substring(1);
        }
        return result.toString();
    }

    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = x + y + add;
            add = temp / 10;
            result.append(temp % 10);
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
