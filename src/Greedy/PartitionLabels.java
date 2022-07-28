package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 763
 * 统计字母出现的起始位置，起始位置构成一个字母在字符串中所在的区间
 * 此问题转化为合并区间
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int size = s.length();
        int[][] intervals = new int[26][2];
        int[] flag = new int[26];
        int index;
        for (int i = 0; i < size; ++i) {
            index = s.charAt(i) - 'a';
            if (flag[index] == 0) {
                flag[index] = 1;
                intervals[index][0] = i;
                intervals[index][1] = i;
            } else {
                intervals[index][1] = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int pre = 0;
        int maxPoint = intervals[0][1];
        for (int i = 0; i < 26; ++i) {
            if ( maxPoint < intervals[i][0]) {
                result.add(maxPoint - intervals[pre][0] + 1);
                pre = i;
                maxPoint = intervals[i][1];
            } else if (maxPoint < intervals[i][1]) {
                maxPoint = intervals[i][1];
            }
        }
        result.add(maxPoint - intervals[pre][0] + 1);
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels a = new PartitionLabels();
        System.out.println(a.partitionLabels(s));
    }
}
