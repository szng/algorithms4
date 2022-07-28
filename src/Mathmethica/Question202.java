package Mathmethica;

public class Question202 {
    public boolean isHappy(int n) {
        int fast = square(n), slow = n;
        do {
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast && fast != 1);

        return fast == 1;
    }

    public int square(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 2;
        Question202 a = new Question202();
        System.out.println(a.isHappy(n));
    }
}

