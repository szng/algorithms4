package Sort.Question;
/**
 * leetcode 350
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i = 0, j = 0; i < n1 && j < n2; ) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        Integer[] temp = (Integer[]) result.toArray(new Integer[result.size()]);
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Intersect a = new Intersect();
        int[] result = a.intersect(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
