package Exam;


public class Micro2 {
    public String solution(String S) {
        // write your code in Java 11 (Java SE 11)
        int n = S.length();
        if (n <= 1) {
            return S;
        }
        int[] data = new int[10];
        for (int i = 0; i < n; i++) {
            data[S.charAt(i) - '0']++;
        }
        int[] odd = new int[10];
        int[] even = new int[10];
        boolean onlyZero = true;
        StringBuilder result = new StringBuilder();

        for (int i = data.length -1; i >= 0; i--) {
            if (data[i] % 2 != 0) {
                odd[i] = 1;
            }
            even[i] = data[i] / 2;
            if (i != 0 && even[i] != 0) {
                onlyZero = false;
            }
            for (int j = even[i]; j > 0; j--) {
                if(onlyZero){
                    break;
                }
                result.append(i);
            }
        }
        for (int i = odd.length-1; i >= 0; i--) {
            if (odd[i] != 0) {
                result.append(i);
                break;
            }
        }
        if(!onlyZero) {
            for (int i = 0; i < even.length; i++) {
                result.append(String.valueOf(i).repeat(Math.max(0, even[i])));
            }
        }
        String ret = result.toString();
        return ret.equals("") ? "0" : ret;
    }

    public static void main(String[] args) {
        String s = "043333333444";
        Micro2 a = new Micro2();
        System.out.println(a.solution(s));
    }
}
