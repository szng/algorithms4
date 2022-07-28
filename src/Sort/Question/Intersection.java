package Sort.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * leetcode 349
 * sort the two arrays and use the idea of mergesort to find the common element.
 *
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<Integer> common = new ArrayList<>();
        int i = 0, j = 0;
        while (i < length1 && j < length2) {
            if (i > 0 && nums1[i] == nums1[i-1]) {
                i++;
                continue;
            }
            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }
            if (nums1[i] == nums2[j]) {
                common.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] nums = new int[common.size()];
        for (i = 0; i < common.size(); i++) {
            nums[i] = common.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {9,4,9,8,4};
        Intersection a = new Intersection();
        int[] nums = a.intersection(nums1, nums2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
