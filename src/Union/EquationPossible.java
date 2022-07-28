/**
 * leetcode 990
 * 将相等符号连通，判断不相等是否连通
 */
package Union;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EquationPossible {
    private Map<Character, Character> id;
    private Set<String> TestCase;

    public char root(char e) {
        if (id.get(e) == e) {
            return e;
        }
        char temp = root(id.get(e));
        id.put(e, temp);
        return temp;
    }

    public boolean isConnected(char p, char q) {
        p = root(p);
        q = root(q);
        return p == q;
    }

    public void union(char p, char q) {
        p = root(p);
        q = root(q);
        id.put(p, q);
    }

    public boolean solve(String[] equations) {
        id = new HashMap<>();
        TestCase = new HashSet<>();
        int n = equations.length;
        for (int i = 0; i < n; i++) {
            char a = equations[i].charAt(0);
            char b = equations[i].charAt(3);
            if (!id.containsKey(a)) {
                id.put(a, a);
            }
            if (!id.containsKey(b)) {
                id.put(b, b);
            }
        }
        for (int i = 0; i < n; i++) {
            char a = equations[i].charAt(0);
            char b = equations[i].charAt(3);
            if (equations[i].charAt(1) == '=') {
                union(a, b);
            } else {
                TestCase.add(equations[i]);
            }
        }
        for (String s : TestCase) {
            if (isConnected(s.charAt(0), s.charAt(3))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"c==c", "b==d", "x!=z"};
        EquationPossible a = new EquationPossible();
        System.out.println(a.solve(equations));
    }
}
