package DataStruct.Question;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    deque.push(s.charAt(i));
                    break;
                case ')':
                    if (deque.isEmpty() || deque.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (deque.isEmpty() || deque.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (deque.isEmpty() || deque.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        Question20 a = new Question20();
        System.out.println(a.isValid(s));
    }
}
