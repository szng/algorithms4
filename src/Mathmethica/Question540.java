package Mathmethica;

public class Question540 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            num = -num;
            negative = true;
        }
        while (num != 0) {
            result.append((char)(num % 7 + '0'));
            num = num / 7;
        }
        if (negative) {
            result.append('-');
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        int num = -7;
        Question540 a = new Question540();
        System.out.println(a.convertToBase7(num));
    }
}
