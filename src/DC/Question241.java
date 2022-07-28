package DC;

import java.util.ArrayList;
import java.util.List;

public class Question241 {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, n));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (expression.charAt(i)) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.isEmpty()) {
            ways.add(Integer.parseInt(expression));
        }
        return ways;
    }

    public List<Integer> diffWaysToCompute2(String expression) {
        int n = expression.length();
        List<Integer> data = new ArrayList<>();
        List<Character> op = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (!Character.isDigit(expression.charAt(i))) {
                op.add(expression.charAt(i++));
            } else {
                int digit = 0;
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    digit = 10 * digit + expression.charAt(i++) - '0';
                }
                data.add(digit);
            }
        }

        int m = data.size();
        List<Integer>[][] dp = new List[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[j][i].add(data.get(i));
                } else {
                    for (int k = j; k < i; k++) {
                        for (Integer l : dp[j][k]) {
                            for (Integer r : dp[k + 1][i]) {
                                switch (op.get(k)) {
                                    case '+':
                                        dp[j][i].add(l + r);
                                        break;
                                    case '-':
                                        dp[j][i].add(l - r);
                                        break;
                                    case '*':
                                        dp[j][i].add(l * r);
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[0][m - 1];
    }


        public static void main (String[]args){
            String expression = "2*3-4*5";
            Question241 a = new Question241();
            List<Integer> result = a.diffWaysToCompute2(expression);
            for (Integer i : result) {
                System.out.println(i);
            }
        }
    }
