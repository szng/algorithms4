package Exam;

import java.util.HashMap;

public class Q3 {
    public int solution(int num, int[] first, int[] second) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int flag = num / 2;
        int res = Integer.MAX_VALUE;

        for (int coin : first) {
            if (!map.isEmpty() && map.containsKey(coin)) {
                map.put(coin, map.get(coin) + 1);
            } else {
                map.put(coin, 1);
            }
            if (map.get(coin) > flag) {
                return 0;
            }
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < second.length; i++) {
            if (!map2.isEmpty() && map2.containsKey(second[i]) && second[i] != first[i]) {
                map2.put(second[i], map2.getOrDefault(second[i], 0) + 1);

            } else if (second[i] != first[i]) {
                map2.put(second[i], 1);
            }
            if (map2.getOrDefault(second[i], 0) + map.getOrDefault(second[i], 0) > flag) {
                res = Math.min(map2.get(second[i]), res);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int solution2(int num, int[] first, int[] second) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int flag = num / 2;
        int res = Integer.MAX_VALUE;

        for (int coin : first) {
            map.put(coin, map.getOrDefault(coin, 0) + 1);
            if (map.get(coin) > flag) {
                return 0;
            }
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < second.length; i++) {
            if (second[i] != first[i]) {
                map2.put(second[i], map2.getOrDefault(second[i], 0) + 1);
                if (map2.getOrDefault(second[i], 0) + map.getOrDefault(second[i], 0) > flag) {
                    res = Math.min(map2.get(second[i]), res);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public char solution3(String s, int k) {
        String result = s + reverse(s) + "wow" + "wow";
        int length = 2 * s.length() + 6;
        int index = (k - 1) % length;
        return result.charAt(index);
    }

    private String reverse(String s) {
        StringBuilder temp = new StringBuilder(s);
        return temp.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 1;
        int[] first = new int[]{1, 1, 5, 7, 0};
        int[] second = new int[]{5, 5, 0, 5, 1};
        Q3 q3 = new Q3();
        System.out.println(q3.solution(num, first, second));
        System.out.println(q3.solution2(num, first, second));
        System.out.println(q3.solution3("Exam", 31));
        System.out.println(q3.solution3("Exam", 51));
        System.out.println(q3.solution3("Exam", 67));
    }
}
