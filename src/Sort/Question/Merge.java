package Sort.Question;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 56
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int i = 0, j = 0;
        List<int[]> results = new ArrayList<>();
        while (i < n) {
            // 获得最大的右端点数字，如果后面区间左端点数字没有超过这个数，则说明都区间重叠
            int max = intervals[i][1];
            while (j+1 < n && max >= intervals[j + 1][0]) {
                j++;
                max = Math.max(max, intervals[j][1]); // 去当前重叠区间最大的右端点，递归思想，意即现在前面遍历的区间成为了一个区间，右端点即为最大
            }
            int[] temp = {intervals[i][0], max};
            results.add(temp);
            j++;
            i = j;
        }
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2,3},{4,6}};
        Merge a = new Merge();
        intervals = a.merge(intervals);
        for (int[] i : intervals) {
            for (int j : i) {
                System.out.print(j);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
