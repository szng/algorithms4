package Greedy;

/**
 * leetcode 135
 */
public class Candy {
    public int candy(int[] ratings) {
        int size = ratings.length;
        if (size < 2) {
            return size;
        }
        int[] nums = new int[size];
        int count = size;
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        for (int i = size - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }
        for (int i = 0; i < size; i++) {
            count += nums[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        Candy a = new Candy();
        System.out.println(a.candy(ratings));
    }
}

