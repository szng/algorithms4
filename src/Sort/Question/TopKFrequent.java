package Sort.Question;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * leetcode 347
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int MaxCount = 0;
        Map<Integer, Integer> ret = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = ret.getOrDefault(nums[i], 0);
            ret.put(nums[i], temp + 1);

            if (MaxCount < temp) {
                MaxCount = temp;
            }
        }
        PriorityQueue<int[]> result = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Integer j : ret.keySet()) {
            if (result.size() < k) {
                result.add(new int[]{j, ret.get(j)});
            } else {
                if (ret.get(j) > result.peek()[1]) {
                    result.poll();
                    result.add(new int[]{j, ret.get(j)});
                }
            }
        }
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = result.poll()[0];
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 1;
        TopKFrequent a = new TopKFrequent();
        int[] result = a.topKFrequent(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
