package DC;

/**
 * 仿射变换不改变其属性
 */
public class Question932 {
    public int[] beautifulArray(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        int[] result = new int[n];
        int i = 0;
        for (int l : beautifulArray((n + 1) / 2)) {
            result[i++] = 2 * l - 1;
        }
        for (int r : beautifulArray(n / 2)) {
            result[i++] = 2 * r;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        Question932 a = new Question932();
        int[] result = a.beautifulArray(n);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
