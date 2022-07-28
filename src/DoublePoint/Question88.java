package DoublePoint;

/**
 * leetcode 88
 */
public class Question88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; --k) {
            if (j < 0) {
                return;
            }
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }

            if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j--];
            } else {
                nums1[k] = nums1[i--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Question88 a = new Question88();
        a.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
