package Sort.Question;

/**
 * leetcode 75
 * quick3way sorting
 */
public class SortColors {
    public void sort(int[] nums) {
        int lt = 0, eq = 0, gt = nums.length - 1;
        int temp;
        while (eq <= gt) {
            if (nums[eq] == 2) {
                temp = nums[gt];
                nums[gt] = nums[eq];
                nums[eq] = temp;
                gt--;
            } else if (nums[eq] == 0) {
                temp = nums[lt];
                nums[lt] = nums[eq];
                nums[eq] = temp;
                lt++;
                eq++;
            } else {
                eq++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 0};
        SortColors a = new SortColors();
        a.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
