package StringDealing;

import DoublePoint.JudgeSquareSum;

import java.util.logging.Level;

/**
 * NC240
 */
public class Question772 {
    public int calculate(String s) {
        int n = s.length();
        int left = 0, right = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                int num = 0;
                if (s.charAt(i) == '(') {
                    int index = findClosing(s, i);
                    num = calculate(s.substring(i + 1, index));
                    i = index + 1;
                } else {
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = 10 * num + s.charAt(i++) - '0';
                    }
                }
                switch (op) {
                    case '+':
                        left += right;
                        right = num;
                        break;
                    case '-':
                        left += right;
                        right = -num;
                        break;
                    case '*':
                        right *= num;
                        break;
                    case '/':
                        right /= num;
                        break;
                }
                if (i < s.length()) {
                    op = s.charAt(i);
                }
            }
        }
        return left + right;
    }

    public int findClosing(String s, int i) {
        int n = s.length();
        int count = 0;
        for (int j = i + 1; j < n; j++) {
            if (s.charAt(j) == '(') {
                ++count;
            }
            if (s.charAt(j) == ')') {
                if (count > 0) {
                    --count;
                } else {
                    return j;
                }
            }
        }
        return n - 1;
    }
    public static void main(String[] args) {
        String s = "5*(3-2)+1";
        Question772 a = new Question772();
        System.out.println(a.calculate(s));
    }
}
