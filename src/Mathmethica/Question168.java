package Mathmethica;

public class Question168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber != 0) {
            result.append((char) ((--columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        int columnNumber = 701;
        Question168 a = new Question168();
        System.out.println(a.convertToTitle(columnNumber));
    }
}
