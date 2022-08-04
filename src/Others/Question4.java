package Others;

public class Question4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int i, j, median1 = 0, median2 = 0;
        while (left <= right) {
            i = left + (right - left) / 2;
            j = (m + n + 1) / 2 - i;
            int nums_i1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums_i = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums_j1 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums_j = j == n ? Integer.MAX_VALUE : nums2[j];
            if (nums_i1 <= nums_j) {
                median1 = Math.max(nums_i1, nums_j1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
