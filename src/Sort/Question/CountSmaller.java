package Sort.Question;
/**
 * leetcode 315
 * 归并排序，后面有多少个归到前面
 */

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    private int[] auxIndex;
    private int[] index;
    private int[] aux;
    private int[] ans;

    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        aux = new int[N];
        auxIndex = new int[N];
        index = new int[N];
        ans = new int[N];

        for (int i = 0; i < N; i++) {
            index[i] = i;
            ans[i] = 0;
        }
        List<Integer> result = new ArrayList<>();
        mergeSort(nums, 0, N - 1);
        for (int num : ans) {
            result.add(num);
        }
        return result;
    }

    public void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
            auxIndex[k] = index[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j];
                index[k] = auxIndex[j++];
            } else if (j > hi) {
                index[k] = auxIndex[i];
                nums[k] = aux[i++];
                ans[index[k]] += j - mid - 1;
            } else if (aux[j] < aux[i]) {
                index[k] = auxIndex[j];
                nums[k] = aux[j++];
            } else {
                index[k] = auxIndex[i];
                nums[k] = aux[i++];
                ans[index[k]] += j - mid - 1;
            }
        }
    }

    public void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public static void main(String[] args) {
        CountSmaller a = new CountSmaller();
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = a.countSmaller(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println(result);
    }
}

