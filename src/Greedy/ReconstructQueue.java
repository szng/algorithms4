package Greedy;

import java.util.Arrays;

/**
 * leetcode 406
 * 后放身高低，对前面的序列不影响
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int N = people.length;
        Arrays.sort(people,(x,y)->{
            if (x[0] > y[0]) {
                return -1;
            } else if (x[0] < y[0]) {
                return 1;
            } else {
                return x[1] - y[1];
            }
        });
        for (int i = 1; i < N; ++i) {
            int j;
            for (j = 0; j < i; ++j) {
                if (j == people[i][1]) {
                    break;
                }
            }
            int[] temp = people[i];
            for (int k = i; k > j; --k) {
                people[k] = people[k - 1];
            }
            people[j] = temp;
        }
        return people;
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        ReconstructQueue a = new ReconstructQueue();
        int[][] result = a.reconstructQueue(people);
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[0].length; ++j) {
                System.out.print(" " + result[i][j]);
            }
            System.out.println();
        }
    }
}
