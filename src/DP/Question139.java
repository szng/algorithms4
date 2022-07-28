package DP;

import java.util.ArrayList;
import java.util.List;

public class Question139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String st : wordDict) {
                int len = st.length();
                if (i >= len && s.substring(i - len, i).equals(st)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Question139 a = new Question139();
        System.out.println(a.wordBreak(s, wordDict));
    }
}
