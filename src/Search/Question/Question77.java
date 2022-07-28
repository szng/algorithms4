package Search.Question;

import java.util.ArrayList;
import java.util.List;

public class Question77 {
    private int n;
    private int k;
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        result = new ArrayList<>();
        if (n < k || n < 1) {
            return result;
        }

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        backtracking(list, count, 1);
        return result;
    }

    // pos用以保持位置，不再选择前面的数字，以免造成重复,即pos到n为下一个递归的数组
    private void backtracking(List<Integer> list, int count, int pos) {
        if (count == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (k - count > n - pos + 1) {
            return;
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            backtracking(list, count + 1, i + 1);
            list.remove((Integer) i);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        Question77 a = new Question77();
        List<List<Integer>> result = a.combine(n, k);
        for (List<Integer> list : result) {
            System.out.print("[");
            for (Integer num : list) {
                System.out.print(num);
            }
            System.out.println("]");
        }
    }
}
