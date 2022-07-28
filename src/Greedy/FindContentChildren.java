package Greedy;

import java.util.Arrays;

/**
 * leetcode 455
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int N = g.length;
        int M = s.length;
        int count = 0, j = 0;
        if (M == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < N; i++) {
            while (j < M && g[i] > s[j]) {
                j++;
            }
            if (j < M) {
                count++;
                j++;
            } else {
                break;
            }
        }
//        int children = 0, cookies = 0;
//        while (children < N && cookies < M) {
//            if (g[children] <= s[cookies]) {
//                ++children;
//            }
//            ++cookies;
//        }
//        return children;
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        FindContentChildren a = new FindContentChildren();
        System.out.println(a.findContentChildren(g, s));
    }
}
