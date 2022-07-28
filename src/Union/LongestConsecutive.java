package Union;
/**
 * leetcode 128
 * 初始化并差集，让每个数字都指向连续的下一个。
 * 此时找到根节点的判定条件不是等于自身，而是是否存在这个数字。
 * 进而找到最大连通分量，因为这里数字是连续的，只需要根节点减去当前数字。
 */

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    private Map<Integer, Integer> a;

    public int find(int e) {
        return a.containsKey(e) ? find(a.get(e)) : e;
    }

    public int solution(int[] nums) {
        int maxing = 0;
        //初始化并查集
        a = new HashMap<>();
        for (int num : nums) {
            a.put(num, num + 1);
        }
        for (int num : nums) {
            if (!a.containsKey(num - 1)) {
                int temp = find(num + 1);
                maxing = Math.max(maxing, temp - num);
            }
        }
        return maxing;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutive a = new LongestConsecutive();
        int ans = a.solution(nums);
        System.out.println(ans);
    }
}

