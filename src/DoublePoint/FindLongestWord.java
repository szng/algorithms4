package DoublePoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 524
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        });
        int i, j;
        for (int k = 0; k < dictionary.size(); k++) {
            i = 0;
            j = 0;
            String temp = dictionary.get(k);
            while (i < s.length() && j < temp.length()) {
                if (s.charAt(i) == temp.charAt(j)) {
                    ++i;
                    ++j;
                } else {
                    ++i;
                }
            }
            if (j == temp.length()) {
                return temp;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ale");
        dictionary.add("apple");
        dictionary.add("monkey");
        dictionary.add("plea");
        FindLongestWord a = new FindLongestWord();
        System.out.println(a.findLongestWord(s, dictionary));
    }
}
