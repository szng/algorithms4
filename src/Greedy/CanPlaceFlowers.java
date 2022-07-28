package Greedy;

import Sort.Question.CountSmaller;

/**
 * leetcode 605
 * 判断条件正面太多，从方面来写
 * 或者在前后补0，将边界当作是0
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        for (int i = 0; i < size && n > 0; ++i) {
            if (flowerbed[i] != 0 || (i - 1 >= 0 && flowerbed[i - 1] != 0) || (i + 1 < size && flowerbed[i + 1] != 0)) {
                continue;
            }
            flowerbed[i] = 1;
            --n;
        }
        return n == 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        CanPlaceFlowers a = new CanPlaceFlowers();
        System.out.println(a.canPlaceFlowers(flowerbed, 2));
    }
}
