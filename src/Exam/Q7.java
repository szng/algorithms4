package Exam;
/*
微软
 */
public class Q7 {
    static class Pair {
        public long x;
        public long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean isLegal() {
            return x == 2 * y;
        }

        public Pair add(long x, long y) {
            long x1 = this.x * y + x * this.y;
            long y1 = this.y * y;
            return new Pair(x1, y1);
        }
    }
    private int[] x;
    private int[] y;
    private int n;
    public int solution(int[] x, int[] y) {
        n = x.length;
        this.x = x;
        this.y = y;
        return backtracking(0, new Pair(1, 1));
    }

    private int backtracking(int start, Pair target) {
        if (target.isLegal()) {
            return 1;
        }
        if (start >= n) {
            return 0;
        }
        long pre = backtracking(start + 1, target) % 1000000007;
        long result = pre + backtracking(start + 1, target.add(x[start], y[start])) % 1000000007;
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
//        int[] x = new int[]{1, 1, 1};
//        int[] y = new int[]{2, 2, 2};
        int[] x = new int[]{1, 1, 2};
        int[] y = new int[]{3, 2, 3};
        Q7 a = new Q7();
        System.out.println(a.solution(x, y));
    }
}
