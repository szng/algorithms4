package Greedy;
/**
 * leetcode 435
 */

import java.util.Arrays;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int size = intervals.length;
        if (size < 2) {
            return 0;
        }
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);
        int count = 0, pre = intervals[0][1];
        for (int i = 1; i < size; i++) {
            if (pre > intervals[i][0]) {
                ++count;
            } else {
                pre = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        EraseOverlapIntervals a = new EraseOverlapIntervals();
        System.out.println(a.eraseOverlapIntervals(intervals));
    }
}
