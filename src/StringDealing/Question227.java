package StringDealing;

public class Question227 {
    public int calculate(String s) {
        int n = s.length();
        int left = 0, right = 0;
        char op = '+';
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i++) - '0';
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

    public int parseNum(String s, int i) {
        int n = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            n = 10 * n + s.charAt(i++) - '0';
        }
        return n;
    }

    public static void main(String[] args) {
        String s = " 3 /2 ";
        Question227 a = new Question227();
        System.out.println(a.calculate(s));
    }
}
