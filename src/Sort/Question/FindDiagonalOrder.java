package Sort.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 1424
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int N = nums.size();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                result.add(new int[]{i + j, j, nums.get(i).get(j)});
            }
        }
        Collections.sort(result,(x,y)->{
            if (x[0] == y[0]) {
                return x[1] - y[1];
            }
            return x[0] - y[0];
        });
        int[] results = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            results[i] = result.get(i)[2];
        }
        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            temp.add(i);
        }
        for (int k = 0; k < 3; k++) {
            nums.add(temp);
        }
        FindDiagonalOrder a = new FindDiagonalOrder();
        int[] result = a.findDiagonalOrder(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
