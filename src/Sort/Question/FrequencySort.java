package Sort.Question;

import java.util.Map;
import java.util.TreeMap;

/**
 * leetcode 451
 */
public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> ret = new TreeMap<>();
        int n = s.length();
        int MaxCount = 0;
        char MaxChar = 0;
        for (int i = 0; i < n; i++) {
            Integer temp = ret.getOrDefault(s.charAt(i), 0) + 1;
            ret.put(s.charAt(i), temp);
            if (MaxCount < temp) {
                MaxChar = s.charAt(i);
                MaxCount = temp;
            }
        }

        StringBuilder[] bucket = new StringBuilder[MaxCount];
        for (int i = 0; i < MaxCount; i++) {
            bucket[i] = new StringBuilder();
        }
        for (Character c : ret.keySet()) {
            bucket[ret.get(c) - 1].append(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = MaxCount - 1; i >= 0; i--) {
            int size = bucket[i].length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k <= i; k++) {
                    result.append(bucket[i].charAt(j));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        FrequencySort a = new FrequencySort();
        System.out.println(a.frequencySort(s));
    }
}
