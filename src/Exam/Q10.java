package Exam;
/*
meituan
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q10 {
    private static int count(int[] nums) {
        int sum = 0;
        HashMap<Integer, List<Integer>> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = data.getOrDefault(nums[i], new ArrayList<>());
            tmp.add(i);
            data.put(nums[i], tmp);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 2; k < nums.length; k++) {
                int temp = nums[i] + nums[k];
                if (temp % 3 == 0) {
                    List<Integer> j = data.get(temp / 3);
                    if (j != null) {
                        for (Integer integer : j) {
                            if (integer > i && integer < k) {
                                sum++;
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    // 主函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 2) System.out.println(0);
        else {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();

            int sum = count(nums);
            System.out.println(sum);
        }
    }
}
