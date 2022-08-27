package Exam.JD;

import java.util.Scanner;
/*
输出矩阵中相邻数字之和为奇数
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (n % 2 == 1 || i % 2 == 0) {
                    result.append(ans++).append(" ");
                } else {
                    result.append((i + 1) * n - j).append(" ");
                    ans++;
                }
            }
            result.deleteCharAt(result.length() - 1);
            System.out.println(result);
            result.delete(0, result.length());
        }
    }
}
