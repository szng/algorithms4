package Search.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Question126 {
    private List<List<String>> results;
    private List<String> path;
    private HashMap<String, ArrayList<String>> next;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<>();
        // 标记未访问的字符串
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return results;
        }
        dict.remove(beginWord);
        dict.remove(endWord);
        next = new HashMap<>();
        next.put(beginWord, new ArrayList<>());
        for (String s : dict) {
            next.put(s, new ArrayList<>());
        }

        HashSet<String> q1 = new HashSet<>();
        q1.add(beginWord);
        HashSet<String> q2 = new HashSet<>();
        q2.add(endWord);
        check(q1, q2, dict);

        path = new ArrayList<>();
        path.add(beginWord);
        backtracking(beginWord, endWord);
        return results;
    }

    private void check(HashSet<String> q1, HashSet<String> q2, HashSet<String> dict) {
        boolean reversed = false, found = false;
        while (!q1.isEmpty()) {
            HashSet<String> q = new HashSet<>();
            for (String w : q1) {
                StringBuilder s = new StringBuilder(w);
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    for (int j = 0; j < 26; j++) {
                        s.setCharAt(i, (char) (j + 'a'));
                        String str = s.toString();

                        String key = reversed ? str : w;
                        String val = reversed ? w : str;

                        if (q2.contains(str)) {
                            found = true;
                            next.get(key).add(val);
                        } else if (dict.contains(str)) {
                            next.get(key).add(val);
                            q.add(str);
                        }
                    }
                    s.setCharAt(i, ch);
                }
            }
            if (found) {
                return;
            }
            for (String s : q) {
                dict.remove(s);
            }
            if (q.size() <= q2.size()) {
                q1 = q;
            } else {
                reversed = !reversed;
                q1 = q2;
                q2 = q;
            }
        }
    }

    private void backtracking(String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (String s : next.getOrDefault(beginWord, new ArrayList<>())) {
            path.add(s);
            backtracking(s, endWord);
            path.remove(s);
        }
    }

    public static void main(String[] args) {
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");
        Question126 a = new Question126();
        List<List<String>> results = a.findLadders(beginWord, endWord, wordList);
        for (List<String> result : results) {
            System.out.println(result);
        }
    }
}
