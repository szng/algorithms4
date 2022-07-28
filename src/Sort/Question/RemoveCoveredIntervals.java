package Sort.Question;
/**
 * leetcode 1288
 * 注意左端点相同的情况，后面覆盖前面
 */

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int N = intervals.length;
        if (N < 2) {
            return N;
        }
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] - y[0] == 0) {
                return y[1] - x[1];
            }
            return x[0] - y[0];
        });
        int count = 0;
        int MaxPoint = intervals[0][1];
        for (int i = 1; i < N; i++) {
            if (intervals[i][1] <= MaxPoint) {
                count++;
            } else {
                MaxPoint = intervals[i][1];
            }
        }
        return N - count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {1, 8}, {3, 8}};
        RemoveCoveredIntervals a = new RemoveCoveredIntervals();
        System.out.println(a.removeCoveredIntervals(intervals));
    }
}
