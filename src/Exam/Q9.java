package Exam;

/*
微软
 */
public class Q9 {
    public int solution(int[] A, int N, int X, int Y) {
        int[] data = new int[Y];
        int[] results = new int[Y];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j <= (X-1)*Y; j += Y) {
                if (i + j >= N) {
                    data[i] = Integer.MAX_VALUE;
                }else {
                    data[i] += A[i + j];
                }
            }
            results[i] = data[i];
        }
        for (int i = X * Y; i < N; i++) {
            int index = i % Y;
            data[index] += A[i] - A[i - X * Y];
            results[index] = Math.min(results[index], data[index]);
        }
        int result = results[0];
        for (int i : results) {
            result = Math.min(result, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 2, 5, 4, 3, 5, 1, 4, 2, 7};
        Q9 a = new Q9();
        System.out.println(a.solution(A, 10, 3, 2));
    }
}
