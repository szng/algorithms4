package Sort.Question;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * leetcode 1353
 * 贪心思想，先参加最先结束的会议
 */
public class MaxEvents {
    public int maxEvents(int[][] events) {
        int N = events.length;
        Arrays.sort(events, (x, y) -> x[0] - y[0]);
        int CurrentDay = 1;
        int count = 0;
        int i = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (i < N || !queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek() < CurrentDay) {
                queue.poll();
            }
            while (i < N && events[i][0] == CurrentDay) {
                queue.add(events[i][1]);
                i++;
            }

            if (!queue.isEmpty()) {
                queue.poll();
                count++;
            }
            CurrentDay++;

        }
        return count;
    }

    public static void main(String[] args) {
        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
        MaxEvents a = new MaxEvents();
        System.out.println(a.maxEvents(events));
    }
}
