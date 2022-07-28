package Sort.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 57
 * 方向思考，将已排序的区间插入到新区间的集合中
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> queue = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < left) {
                queue.add(interval);
            } else if (interval[0] > right) {
                if (!placed) {
                    queue.add(new int[]{left, right});
                    placed = true;
                }
                queue.add(interval);
            } else {
                left = left < interval[0] ? left : interval[0];
                right = right > interval[1] ? right : interval[1];
            }
        }
        if (!placed) {
            queue.add(new int[]{left, right});
        }
        int[][] result = new int[queue.size()][];
        for (int i = 0; i < queue.size(); i++) {
            result[i] = queue.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{6,9}};
        int[] newInterval = {2, 5};
        InsertInterval a = new InsertInterval();
        int[][] result = a.insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            System.out.println("["+result[i][0]+","+result[i][1]+"]");
        }

    }
}
