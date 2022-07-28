/***
 * leetcode 922
 * sort the array by odd-even
 * 双指针，类似快速排序，一个指针遍历奇数位置，一个偶数，遇到不相符则交换
 */
package Sort.Question;

public class OddEvenSort {
    public int[] sortArrayByParityII(int[] nums) {
       int i = 0, j = 1;
       int n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 ==0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 != 0) {
                j += 2;
            }
            if (i >= n || j > n) {
                return nums;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        OddEvenSort a = new OddEvenSort();
        a.sortArrayByParityII(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
