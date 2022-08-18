package Exam;

import java.util.Arrays;
import java.util.Scanner;

public class Q12 {
    //以秒计算
    public String solution(int[] times) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        Arrays.sort(times);
        int n = times.length;
        int[] results = new int[n];
        for (int i = 1; i < n; i++) {
            results[i - 1] = times[i] - times[i - 1];
        }
        results[n - 1] = times[0] - times[n - 1] + 24 * 60 * 60;
        int max = 0, index = 0;
        for (int i = 0; i < n; i++) {
            if (max < results[i]) {
                max = results[i];
                index = i;
            }
        }
        StringBuilder result = new StringBuilder();
        int temp = times[index] / (60 * 60);
        if (temp < 10) {
            result.append(0);
        }
        result.append(temp).append(":");
        temp = times[index] % (60 * 60);
        if (temp / 60 < 10) {
            result.append(0);
        }
        result.append(temp / 60).append(":");
        temp %= 60;
        if (temp < 10) {
            result.append(0);
        }
        result.append(temp);
        return result.toString();
    }

    public static void main(String[] args) {
        int[] times = new int[]{60 * 60, 2 * 60 * 60, 3 * 60 * 60};
        Q12 a = new Q12();
        System.out.println(a.solution(times));
    }
}
