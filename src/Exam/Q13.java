package Exam;

import java.util.Arrays;
import java.util.Comparator;

public class Q13 {
    public int solution(String log) {
        int n = log.length();
        if (n < 4 || n % 6 != 0 || log.charAt(0) != 'f') {
            return -1;
        }
        int k = n / 6;
        int x = 0, y = 0;
        int[][] nums = new int[k][2];
        for (int i = 0; i < n; i++) {
            if (log.charAt(i) == 'f') {
                nums[x++][0] = i;
            } else if (log.charAt(i) == 'd') {
                nums[y++][1] = i;
            }
        }
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        int count = 0;
        int right = nums[0][1];
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (right > nums[i][0]) {
                count++;
            } else {
                count = 0;
                right = nums[i][1];
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String log = "failefdailed";
        Q13 a = new Q13();
        System.out.println(a.solution(log));
    }
}
