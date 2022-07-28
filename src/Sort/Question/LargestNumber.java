package Sort.Question;

import java.util.Arrays;

/**
 * leetcode 179
 */
public class LargestNumber {
    public String solution(int[] nums) {
        int n = nums.length;
        String[] numsArr = new String[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i]+"";
        }

        Arrays.sort(numsArr, (x, y) -> (y+x).compareTo(x+y));

        StringBuilder ret = new StringBuilder();
        for (String num : numsArr) {
            ret.append(num);
        }
        int len = ret.length();
        int k = 0;
        while (k < len - 1 && ret.charAt(k) == '0') k++;
        return ret.substring(k);
    }
    public static void main(String[] args) {
        int[] nums = {0,0};
        LargestNumber a = new LargestNumber();
        System.out.println(a.solution(nums));
    }
}
