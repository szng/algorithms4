package Exam.JD;
/*
长城奇数位都相同，偶数位都相同，奇偶位不相同
每次可以修改一个数字，求最少操作次数
 */
import java.util.HashMap;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int odd = 0;
        int even = 0;
        HashMap<Integer, Integer> oddResult = new HashMap<>();
        HashMap<Integer, Integer> evenResult = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (i % 2 == 0) {
                int temp = oddResult.getOrDefault(nums[i], 0);
                oddResult.put(nums[i], temp + 1);
            } else {
                int temp = evenResult.getOrDefault(nums[i], 0);
                evenResult.put(nums[i], temp + 1);
            }
        }
        int maxOdd = 0, maxEven = 0;
        for (int num : nums) {
            int temp = oddResult.getOrDefault(num, 0);
            maxOdd = Math.max(maxOdd, temp);
            temp = evenResult.getOrDefault(num, 0);
            maxEven = Math.max(maxEven, temp);
        }
        int result = maxEven + maxOdd;

        System.out.println(result);
    }
}
