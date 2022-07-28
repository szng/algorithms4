package Mathmethica;

public class Question415 {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        StringBuilder temp = new StringBuilder(num1);
        num1 = temp.reverse().toString();
        temp = new StringBuilder(num2);
        num2 = temp.reverse().toString();
        int i = 0;
        StringBuffer result = new StringBuffer();
        while (i < m && i < n) {


        }
        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "11", num2 = "123";
        Question415 a = new Question415();
        System.out.println(a.addStrings(num1, num2));
    }
}
