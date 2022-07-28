package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 452
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        int size = points.length;
        if (size < 2) {
            return size;
        }
//        Arrays.sort(points, (x, y) -> x[1] - y[1]);
//        减法会有溢出问题
        Arrays.sort(points, Comparator.comparingInt(x -> x[1]));
        int count = 1, pre = points[0][1];
        for (int i = 0; i < size; i++) {
            if (pre < points[i][0]) {
                ++count;
                pre = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        FindMinArrowShots a = new FindMinArrowShots();
        System.out.println(a.findMinArrowShots(points));
    }
}
