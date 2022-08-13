package Exam;
/*
微软
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q8 {
    public int solution(int[] a) {
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int j : a) {
            queue.offer((double) j);
            sum += j;
        }
        sum /= 2;
        int count = 0;
        while (sum > 0 && !queue.isEmpty()) {
            double x = queue.poll();
            sum -= x / 2.0;
            queue.offer(x / 2.0);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 0, 5};
        Q8 a = new Q8();
        System.out.println(a.solution(A));
    }
}
